package com.example.hihihahahehe.portablept.models.JSONModel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hihihahahehe on 8/17/17.
 */

public class PackJSONModel{
    @SerializedName("phoneNumber")
    private String phoneNumber;
    @SerializedName("purpose")
    private String purpose;
    private String packName;
    @SerializedName("coach")
    private String coach;
    @SerializedName("price")
    private String price;
    @SerializedName("duration")
    private String duration;
    private String packImgUrl;
    private String address;

    public PackJSONModel(String phoneNumber, String purpose, String packName, String coach, String price, String duration, String packImgUrl, String address) {
        this.phoneNumber = phoneNumber;
        this.purpose = purpose;
        this.packName = packName;
        this.coach = coach;
        this.price = price;
        this.duration = duration;
        this.packImgUrl = packImgUrl;
        this.address = address;
    }

    public String getPackImgUrl() {
        return packImgUrl;
    }

    public void setPackImgUrl(String packImgUrl) {
        this.packImgUrl = packImgUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getPackName() {
        return packName;
    }

    public void setPackName(String packName) {
        this.packName = packName;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
