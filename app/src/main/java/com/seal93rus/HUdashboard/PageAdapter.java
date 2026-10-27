package com.seal93rus.HUdashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.seal93rus.HUdashboard.radio.TunerView;

import java.util.List;

public class PageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<PageItem> pages;

    public PageAdapter(List<PageItem> pages) {
        this.pages = pages;
    }

    @Override
    public int getItemViewType(int position) {
        return pages.get(position).getType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {

            case PageItem.TUNER_PAGE: {
                // TunerView САМ инфлейтит R.layout.tuner_page внутри себя
                // и подписывается на RadioClient в onAttachedToWindow.
                // Инфлейтить разметку напрямую нельзя — иначе кнопки/данные не заработают.
                TunerView v = new TunerView(parent.getContext());
                v.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
                return new TunerViewHolder(v);
            }
            case PageItem.MUSIC_PAGE: {
                View v = inflater.inflate(R.layout.music_page, parent, false);
                return new MusicViewHolder(v);
            }
            default:
                throw new IllegalArgumentException("Unknown viewType: " + viewType);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PageItem item = pages.get(position);

        if (holder instanceof MusicViewHolder) {
            ((MusicViewHolder) holder).bind((MusicItem) item);
        } else if (holder instanceof TunerViewHolder) {
            ((TunerViewHolder) holder).bind((TunerItem) item);
        }
    }

    @Override
    public int getItemCount() {
        return pages.size();
    }

    // ---------- ViewHolder'ы ----------

    static class MusicViewHolder extends RecyclerView.ViewHolder {
        final TextView title;

        MusicViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.musicTitle);
        }

        void bind(MusicItem item) {
            title.setText(item.getTitle());
        }
    }

    static class TunerViewHolder extends RecyclerView.ViewHolder {
        final TunerView tuner;

        TunerViewHolder(@NonNull TunerView itemView) {
            super(itemView);
            this.tuner = itemView;
        }

        void bind(TunerItem item) {
            // Ничего не пишем в tunerNote: это поле статуса сервиса внутри TunerView.
            // Если нужен заголовок страницы — добавь отдельный TextView в tuner_page.xml
            // (например, R.id.tvPageTitle) и пиши туда.
            // item.getNote() здесь намеренно не используется.
        }
    }
}