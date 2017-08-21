package com.example.hihihahahehe.portablept.models.JSONModel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by valky on 8/21/2017.
 */

public class SportsJSONModel {
    @SerializedName("sportsImgUrl")
    private String imageURL;
    @SerializedName("sportsName")
    private String sportsName;

    public SportsJSONModel(String imageURL, String sportsName) {
        this.imageURL = imageURL;
        this.sportsName = sportsName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getSportsName() {
        return sportsName;
    }

    public void setSportsName(String sportsName) {
        this.sportsName = sportsName;
    }
}
