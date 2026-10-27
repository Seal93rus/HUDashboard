package com.seal93rus.HUdashboard.radio;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class RadioEngineerData implements Parcelable {
    public static final Creator<RadioEngineerData> CREATOR = new Creator<RadioEngineerData>() { // from class: com.harman.radioservice.RadioEngineerData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RadioEngineerData createFromParcel(Parcel source) {
            return new RadioEngineerData(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RadioEngineerData[] newArray(int size) {
            return new RadioEngineerData[size];
        }
    };
    private int mAdjacentChannel;
    private boolean mAntennaConnected;
    private int mAutoGainControl;
    private int mBitErrorRate;
    private int mFMDeviation;
    private long mFMOffset;
    private int mFieldStrength;
    private int mFrequency;
    private long mHighCut;
    private int mMultiPath;
    private int mOscInjection;
    private int mPiCode;
    private int mQuality;
    private String mRegion;
    private int mSNR;
    private String mSenderName;
    private int mSignalStrength;
    private int mWaveBand;
    private long mZFBandWidth;

    public RadioEngineerData(boolean antennaConnected, int waveBand, int frequency, int signalStrength, int fieldStrength, int pi, int quality, int bitErrorRate, int multiPath, int autoGainControl, int oscInjection, int snr, int adjacentChannel, int fmDeviation, long fmOffset, long zfBandWidth, long highCut, String region, String senderName) {
        this.mAntennaConnected = antennaConnected;
        this.mWaveBand = waveBand;
        this.mFrequency = frequency;
        this.mSignalStrength = signalStrength;
        this.mFieldStrength = fieldStrength;
        this.mPiCode = pi;
        this.mQuality = quality;
        this.mBitErrorRate = bitErrorRate;
        this.mMultiPath = multiPath;
        this.mAutoGainControl = autoGainControl;
        this.mOscInjection = oscInjection;
        this.mSNR = snr;
        this.mAdjacentChannel = adjacentChannel;
        this.mFMDeviation = fmDeviation;
        this.mFMOffset = fmOffset;
        this.mZFBandWidth = zfBandWidth;
        this.mHighCut = highCut;
        this.mRegion = region;
        this.mSenderName = senderName;
    }

    private RadioEngineerData(Parcel in) {
        this.mAntennaConnected = in.readByte() == 1;
        this.mWaveBand = in.readInt();
        this.mFrequency = in.readInt();
        this.mSignalStrength = in.readInt();
        this.mFieldStrength = in.readInt();
        this.mPiCode = in.readInt();
        this.mQuality = in.readInt();
        this.mBitErrorRate = in.readInt();
        this.mMultiPath = in.readInt();
        this.mAutoGainControl = in.readInt();
        this.mOscInjection = in.readInt();
        this.mSNR = in.readInt();
        this.mAdjacentChannel = in.readInt();
        this.mFMDeviation = in.readInt();
        this.mFMOffset = in.readLong();
        this.mZFBandWidth = in.readLong();
        this.mHighCut = in.readLong();
        this.mRegion = in.readString();
        this.mSenderName = in.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        out.writeByte((byte) (this.mAntennaConnected ? 1 : 0));
        out.writeInt(this.mWaveBand);
        out.writeInt(this.mFrequency);
        out.writeInt(this.mSignalStrength);
        out.writeInt(this.mFieldStrength);
        out.writeInt(this.mPiCode);
        out.writeInt(this.mQuality);
        out.writeInt(this.mBitErrorRate);
        out.writeInt(this.mMultiPath);
        out.writeInt(this.mAutoGainControl);
        out.writeInt(this.mOscInjection);
        out.writeInt(this.mSNR);
        out.writeInt(this.mAdjacentChannel);
        out.writeInt(this.mFMDeviation);
        out.writeLong(this.mFMOffset);
        out.writeLong(this.mZFBandWidth);
        out.writeLong(this.mHighCut);
        out.writeString(this.mRegion);
        out.writeString(this.mSenderName);
    }

    public boolean getAntennaConnected() {
        return this.mAntennaConnected;
    }

    public void setAntennaConnected(boolean status) {
        this.mAntennaConnected = status;
    }

    public int getWaveBand() {
        return this.mWaveBand;
    }

    public void setWaveBand(int band) {
        this.mWaveBand = band;
    }

    public int getFrequency() {
        return this.mFrequency;
    }

    public void setFrequency(int frequency) {
        this.mFrequency = frequency;
    }

    public int getSignalStrength() {
        return this.mSignalStrength;
    }

    public void setSignalStrength(int signalStrength) {
        this.mSignalStrength = signalStrength;
    }

    public int getFiledStrength() {
        return this.mFieldStrength;
    }

    public void setFiledStrength(int filedStrength) {
        this.mFieldStrength = filedStrength;
    }

    public int getPiCode() {
        return this.mPiCode;
    }

    public void setPiCode(int pi) {
        this.mPiCode = pi;
    }

    public int getQuality() {
        return this.mQuality;
    }

    public void setQuality(int quality) {
        this.mQuality = quality;
    }

    public int getBitErrorRate() {
        return this.mBitErrorRate;
    }

    public void setBitErrorRate(int rate) {
        this.mBitErrorRate = rate;
    }

    public int getMultiPath() {
        return this.mMultiPath;
    }

    public void setMultiPath(int path) {
        this.mMultiPath = path;
    }

    public int getAutoGainControl() {
        return this.mAutoGainControl;
    }

    public void setAutoGainControl(int acg) {
        this.mAutoGainControl = acg;
    }

    public int getOscInjection() {
        return this.mOscInjection;
    }

    public void setOscInjection(int osc) {
        this.mOscInjection = osc;
    }

    public int getSNR() {
        return this.mSNR;
    }

    public void setSNR(int snr) {
        this.mSNR = snr;
    }

    public int getAdjacentChannel() {
        return this.mAdjacentChannel;
    }

    public void setAdjacentChannel(int adj) {
        this.mAdjacentChannel = adj;
    }

    public int getFMDeviation() {
        return this.mFMDeviation;
    }

    public void setFMDeviation(int fmDeviation) {
        this.mFMDeviation = fmDeviation;
    }

    public long getFMOffset() {
        return this.mFMOffset;
    }

    public void setFMOffset(long offset) {
        this.mFMOffset = offset;
    }

    public long getZFBandWidth() {
        return this.mZFBandWidth;
    }

    public void setZFBandWidth(long zfBandWidth) {
        this.mZFBandWidth = zfBandWidth;
    }

    public long getHighCut() {
        return this.mHighCut;
    }

    public void setHighCut(long highCut) {
        this.mHighCut = highCut;
    }

    public String getRegion() {
        return this.mRegion;
    }

    public void setRegion(String name) {
        this.mRegion = name;
    }

    public String getSenderName() {
        return this.mSenderName;
    }

    public void setSenderName(String name) {
        this.mSenderName = name;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("RadioEngineerData [antennaConnected:%s, waveBand:%s, frequency:%s, signalStrength:%s, fieldStrength:%s, piCode:%s, quality:%s, bitErrorRate:%s, multiPath:%s, autoGainControl:%s, oscInjection:%s, SNR:%s, adjacentChannel:%s, FMDeviation:%s, FMOffset:%s, ZFBandWidth:%s, highCut:%s, region:%s, sender name:%s]", Boolean.valueOf(this.mAntennaConnected), Integer.valueOf(this.mWaveBand), Integer.valueOf(this.mFrequency), Integer.valueOf(this.mSignalStrength), Integer.valueOf(this.mFieldStrength), Integer.valueOf(this.mPiCode), Integer.valueOf(this.mQuality), Integer.valueOf(this.mBitErrorRate), Integer.valueOf(this.mMultiPath), Integer.valueOf(this.mAutoGainControl), Integer.valueOf(this.mOscInjection), Integer.valueOf(this.mSNR), Integer.valueOf(this.mAdjacentChannel), Integer.valueOf(this.mFMDeviation), Long.valueOf(this.mFMOffset), Long.valueOf(this.mZFBandWidth), Long.valueOf(this.mHighCut), this.mRegion, this.mSenderName);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        if (!(object instanceof RadioEngineerData)) {
            return false;
        }
        RadioEngineerData data = (RadioEngineerData) object;
        return data.getWaveBand() == this.mWaveBand && data.getFrequency() == this.mWaveBand;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.mFrequency));
    }
}