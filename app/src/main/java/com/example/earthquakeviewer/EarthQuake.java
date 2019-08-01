package com.example.earthquakeviewer;

import android.location.Location;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class EarthQuake {
    private String mId;
    private Date mDate;
    private String mDetails;
    private Location mLocation;
    private double mMagnitude;
    private String mLink;

    EarthQuake(String id, Date date, String details, Location location, double magnitude, String link) {
        mId = id;
        mDate = date;
        mDetails = details;
        mLocation = location;
        mMagnitude = magnitude;
        mLink = link;
    }

    String getId() {
        return mId;
    }

    Date getDate() {
        return mDate;
    }

    String getDetails() {
        return mDetails;
    }

    Location getLocation() {
        return mLocation;
    }

    double getMagnitude() {
        return mMagnitude;
    }

    String getLink() {
        return mLink;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH.mm", Locale.US);
        String dateString = sdf.format(mDate);
        return dateString + ": " + mMagnitude + " " + mDetails;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof EarthQuake)
            return (((EarthQuake)obj).getId().contentEquals(mId));
        else
            return false;
    }
}
