package com.example.takhleeqproject;

import android.telephony.mbms.MbmsErrors;

public class UserCredentials {
    static String id = "nulled";
    static String name = "nulled";
    static String phone = "nulled";
    static String email = "nulled";
    static String imgUri = "nulled";

    public UserCredentials() {
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        UserCredentials.id = id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        UserCredentials.name = name;
    }

    public static String getPhone() {
        return phone;
    }

    public static void setPhone(String phone) {
        UserCredentials.phone = phone;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        UserCredentials.email = email;
    }

    public static String getImgUri() {
        return imgUri;
    }

    public static void setImgUri(String imgUri) {
        UserCredentials.imgUri = imgUri;
    }
}
