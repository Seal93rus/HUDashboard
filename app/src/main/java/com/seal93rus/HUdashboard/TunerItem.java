package com.seal93rus.HUdashboard;

public class TunerItem extends PageItem {
    private final String note;

    public TunerItem(String note) { this.note = note == null ? "" : note; }
    public String getNote() { return note; }

    @Override public int getType() { return TUNER_PAGE; }
}