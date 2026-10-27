package com.seal93rus.HUdashboard;

public class MusicItem extends PageItem {
    private final String title;
    private final int coverRes;

    public MusicItem(String title, int coverRes) {
        this.title = title;
        this.coverRes = coverRes;
    }

    public String getTitle() { return title; }
    public int getCoverRes() { return coverRes; }

    @Override public int getType() { return MUSIC_PAGE; }
}