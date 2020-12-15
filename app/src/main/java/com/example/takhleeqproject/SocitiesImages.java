package com.example.takhleeqproject;

import android.net.Uri;

public class SocitiesImages {
    String imgUri;
    String uploadedBy;
    String societyName;
    String imgDescription;
    String Date;

    public SocitiesImages(String imgUri, String uploadedBy, String societyName, String imgDescription, String date) {
        this.imgUri = imgUri;
        this.uploadedBy = uploadedBy;
        this.societyName = societyName;
        this.imgDescription = imgDescription;
        Date = date;
    }

    public String getImgUri() {
        return imgUri;
    }

    public void setImgUri(String imgUri) {
        this.imgUri = imgUri;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public String getSocietyName() {
        return societyName;
    }

    public void setSocietyName(String societyName) {
        this.societyName = societyName;
    }

    public String getImgDescription() {
        return imgDescription;
    }

    public void setImgDescription(String imgDescription) {
        this.imgDescription = imgDescription;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
