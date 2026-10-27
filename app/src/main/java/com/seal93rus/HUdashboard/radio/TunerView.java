package com.seal93rus.HUdashboard.radio;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatImageButton;

import com.seal93rus.HUdashboard.R;
import com.seal93rus.HUdashboard.radio.RadioClient;
import com.seal93rus.HUdashboard.radio.RadioStation;

import java.text.DecimalFormat;
import java.util.Locale;


public class TunerView extends FrameLayout implements RadioClient.Listener {

    private RadioClient client;

    private TextView tvFrequency, tvFrequencyUnit, tvBand, tvSignal, tvNote;
    private Button  btnSeekUp, btnSeekDown;

    private AppCompatImageButton btnMute;

    public TunerView(Context c) { super(c); init(c); }
    public TunerView(Context c, AttributeSet a) { super(c, a); init(c); }
    public TunerView(Context c, AttributeSet a, int s) { super(c, a, s); init(c); }

    private void init(Context c) {
        LayoutInflater.from(c).inflate(R.layout.tuner_page, this, true);
        tvFrequency     = findViewById(R.id.tvFrequency);
        tvFrequencyUnit = findViewById(R.id.tvFrequencyUnit);
        tvBand         = findViewById(R.id.tvBand);
        tvSignal       = findViewById(R.id.tvSignal);
        tvNote         = findViewById(R.id.tunerNote);


        btnSeekUp    = findViewById(R.id.btnSeekUp);
        btnSeekDown  = findViewById(R.id.btnSeekDown);
        btnMute      = findViewById(R.id.btnMute);

        client = RadioClient.get(c);
        btnSeekUp.setOnClickListener(v -> client.seekUp());
        btnSeekDown.setOnClickListener(v -> client.seekDown());
        btnMute.setOnClickListener(v -> toggleMute());
    }

    // ---------- lifecycle ----------

    @Override protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        client.addListener(this);
        client.start();
        renderAll();
    }

    @Override protected void onDetachedFromWindow() {
        client.removeListener(this);
        super.onDetachedFromWindow();
    }

    // ---------- RadioClient.Listener ----------

    @Override public void onRadioDataChanged()           { renderAll(); }
    @Override public void onAudioFocusChanged(boolean f) { /* локальному UI не нужно */ }
    @Override public void onServiceStateChanged(boolean connected) {
        if (tvNote != null) tvNote.setText(connected ? "" : "Radio service not connected");
        if (!connected) {
            tvFrequency.setText("--");
            tvFrequencyUnit.setText("");
            tvBand.setText("");
            tvSignal.setText("");
        }
    }

    // ---------- rendering ----------

    private void renderAll() {
        renderFrequency();
        renderSignal();
        renderMute();
    }

    private void renderFrequency() {
        RadioStation s = client.getCurrentStation();
        int band = s != null ? s.getRadioBand() : -1;
        int freq = s != null ? s.getFrequency() : 0;

        if (band == 1) {                                  // FM
            if (freq > 0) {
                float mhz = freq / 1000f;
                tvFrequency.setText(new DecimalFormat("0.0").format(mhz));
                tvFrequencyUnit.setText("MHz");
            } else {
                tvFrequency.setText("");
                tvFrequencyUnit.setText("");
            }
            tvBand.setText("FM");
        } else if (band == 0) {                           // AM
            tvFrequency.setText(new DecimalFormat("####").format(freq));
            tvFrequencyUnit.setText("kHz");
            tvBand.setText("AM");
        } else {
            tvFrequency.setText("--");
            tvFrequencyUnit.setText("");
            tvBand.setText("");
        }
    }

    private void renderSignal() {
        RadioStation s = client.getCurrentStation();
        if (s == null) { tvSignal.setText(""); return; }
        int strength = s.getSignalStrength();
        boolean supported = strength >= 15;
        tvSignal.setText(String.format(Locale.US, "Signal: %d %s", strength, supported ? "" : "(weak)"));
    }

    private void renderMute() {
        btnMute.setBackgroundResource(client.isMuted() ? R.drawable.btn_mute : R.drawable.btn_unmute);
    }


    // ---------- clicks ----------

    /**
     * Локальный mute/unmute — паритет с RadioPresenter.handleMuteUnMuteClick:
     *  - если радио играет (focus && !muted) — mute();
     *  - иначе — сначала requestRadioAudioFocus(), потом unmute() если было muted.
     */
    private void toggleMute() {
        if (client.isPlaying()) {
            if (!client.isMuted()) client.mute();
        } else {
            if (!client.isAudioFocused()) client.requestFocus();
            if (client.isMuted()) client.unmute();
        }
        renderMute();
    }
}