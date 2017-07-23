package com.sbagadi.apps.algorithmsvisualized.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * A data class to represent an Algorithm.
 */
public class Algorithm implements Parcelable {

    /**
     * A {@link String} representing the name of the algorithm.
     */
    private String mName;

    /**
     * A {@link String} representing the description of the algorithm.
     */
    private String mDescription;

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    /**
     * The default constructor for this data class.
     *
     * @param name        The name of the algorithm.
     * @param description A simple description of the algorithm.
     */
    public Algorithm(String name, String description) {
        mName = name;
        mDescription = description;
    }

    /**
     * A constructor to re-create the object from parcel.
     *
     * @param in An Android {@link Parcel} containing data to re-create this object.
     */
    protected Algorithm(Parcel in) {
        mName = in.readString();
        mDescription = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mDescription);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * A {@link android.os.Parcelable.Creator} needed by {@link Parcelable} to generates instances
     * of this class from a Parcel.
     */
    public static final Creator<Algorithm> CREATOR = new Creator<Algorithm>() {
        @Override
        public Algorithm createFromParcel(Parcel in) {
            return new Algorithm(in);
        }

        @Override
        public Algorithm[] newArray(int size) {
            return new Algorithm[size];
        }
    };
}
