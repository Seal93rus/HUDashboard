package com.seal93rus.HUdashboard.radio;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class RadioStation implements Parcelable {
    public static final Creator<RadioStation> CREATOR = new Creator<RadioStation>() { // from class: com.harman.radioservice.RadioStation.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RadioStation createFromParcel(Parcel source) {
            return new RadioStation(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RadioStation[] newArray(int size) {
            return new RadioStation[size];
        }
    };
    private int mBand;
    private int mFrequency;
    private boolean mIsMuted;
    private boolean mIsStereo;
    private boolean mIsTuned;
    private int mPICode;
    private int mPTYCode;
    private int mPresetID;
    private String mProgramService;
    private int mSignalStrength;
    private String mStationName;

    public RadioStation(int band, int frequency, int strength, int presetID, boolean tuned, boolean muted, boolean stereo, String name, int piCode, int ptyCode, String ps) {
        this.mBand = band;
        this.mFrequency = frequency;
        this.mSignalStrength = strength;
        this.mPresetID = presetID;
        this.mIsTuned = tuned;
        this.mIsMuted = muted;
        this.mIsStereo = stereo;
        this.mStationName = name;
        this.mPICode = piCode;
        this.mPTYCode = ptyCode;
        this.mProgramService = ps;
    }

    public RadioStation(int band, int frequency, int strength, int presetID, boolean tuned, boolean muted, boolean stereo, String name) {
        this.mBand = band;
        this.mFrequency = frequency;
        this.mSignalStrength = strength;
        this.mPresetID = presetID;
        this.mIsTuned = tuned;
        this.mIsMuted = muted;
        this.mIsStereo = stereo;
        this.mStationName = name;
        this.mPICode = 0;
        this.mPTYCode = 0;
        this.mProgramService = "";
    }

    private RadioStation(Parcel in) {
        this.mBand = in.readInt();
        this.mFrequency = in.readInt();
        this.mSignalStrength = in.readInt();
        this.mPresetID = in.readInt();
        this.mIsTuned = in.readByte() == 1;
        this.mIsMuted = in.readByte() == 1;
        this.mIsStereo = in.readByte() == 1;
        this.mStationName = in.readString();
        this.mPICode = in.readInt();
        this.mPTYCode = in.readInt();
        this.mProgramService = in.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(this.mBand);
        out.writeInt(this.mFrequency);
        out.writeInt(this.mSignalStrength);
        out.writeInt(this.mPresetID);
        out.writeByte((byte) (this.mIsTuned ? 1 : 0));
        out.writeByte((byte) (this.mIsMuted ? 1 : 0));
        out.writeByte((byte) (this.mIsStereo ? 1 : 0));
        out.writeString(this.mStationName);
        out.writeInt(this.mPICode);
        out.writeInt(this.mPTYCode);
        out.writeString(this.mProgramService);
    }

    public int getRadioBand() {
        return this.mBand;
    }

    public void setRadioBand(int band) {
        this.mBand = band;
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

    public int getPresetID() {
        return this.mPresetID;
    }

    public void setPresetID(int id) {
        this.mPresetID = id;
    }

    public boolean getTuned() {
        return this.mIsTuned;
    }

    public void setTuned(boolean tuned) {
        this.mIsTuned = tuned;
    }

    public boolean getMuted() {
        return this.mIsMuted;
    }

    public void setMuted(boolean muted) {
        this.mIsMuted = muted;
    }

    public boolean getStereo() {
        return this.mIsStereo;
    }

    public void setStereo(boolean stereo) {
        this.mIsStereo = stereo;
    }

    public String getStationName() {
        return this.mStationName;
    }

    public void setStationName(String name) {
        this.mStationName = name;
    }

    public int getPICode() {
        return this.mPICode;
    }

    public void setPICode(int piCode) {
        this.mPICode = piCode;
    }

    public int getPTYCode() {
        return this.mPTYCode;
    }

    public void setPTYCode(int ptyCode) {
        this.mPTYCode = ptyCode;
    }

    public String getProgramService() {
        return this.mProgramService;
    }

    public void setProgramService(String programService) {
        this.mProgramService = programService;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("RadioStation [band:%s, frequency:%s, strength:%s, preset ID:%s, tuned:%s, muted:%s, stereo:%s, name:%s]", Integer.valueOf(this.mBand), Integer.valueOf(this.mFrequency), Integer.valueOf(this.mSignalStrength), Integer.valueOf(this.mPresetID), Boolean.valueOf(this.mIsTuned), Boolean.valueOf(this.mIsMuted), Boolean.valueOf(this.mIsStereo), this.mStationName);
    }

    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass() || !(object instanceof RadioStation)) {
            return false;
        }
        RadioStation station = (RadioStation) object;
        return station.getRadioBand() == this.mBand && station.getFrequency() == this.mFrequency;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.mFrequency));
    }
}