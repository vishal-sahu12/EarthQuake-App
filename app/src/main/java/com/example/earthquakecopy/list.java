package com.example.earthquakecopy;

public class list {

    private String mLocation;
    private String mUrl;
    private Double mMagnitude;
    private Long mtimesInMilisecond;

    public list( Double mMagnitude, String mLocation,Long mTimesInMilisecond,String url) {
        this.mtimesInMilisecond = mTimesInMilisecond;
        this.mMagnitude = mMagnitude;
        this.mLocation = mLocation;
        this.mUrl = url;
    }

    public String getmUrl() {
        return mUrl;
    }

    public String getmLocation() {
        return mLocation;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }


    public Long getMtimesInMilisecond() {
        return mtimesInMilisecond;
    }


    public Double getmMagnitude() {
        return mMagnitude;
    }

    public void setmMagnitude(Double mMagnitude) {
        this.mMagnitude = mMagnitude;
    }
}
