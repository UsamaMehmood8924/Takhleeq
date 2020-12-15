package com.example.takhleeqproject;

import java.io.Serializable;
import java.lang.ref.SoftReference;

public class EventDetails implements Serializable {
    private String id;
    private String Name;
    private String Date;
    private String Time;
    private String Venue;
    private String Performer;
    private String Guest1;
    private String Guest2;
    private String Guest3;
    private String Organizer1;
    private String Organizer2;
    private String Organizer3;
    private String Sponser;

    public EventDetails(){
        Name = "Qawali Night";
        Date = "10/10/2020";
        Time = "10:24pm";
        Venue = "Brand New Hotel";
        Guest1 = "Ali";
        Guest2 = "Ahmad";
        Guest3 = "Raza";
        Organizer1 = "ABC";
        Organizer2 = "DEF";
        Organizer3 = "GHI";
        Sponser = "Asad Mahmood";
    }
    public EventDetails(String name,String date, String time, String venue, String performer, String guest1, String gues2, String guest3, String organizer1, String organizer2, String organizer3, String sponser) {
        Name = name;
        Date = date;
        Time = time;
        Venue = venue;
        Performer = performer;
        Guest1 = guest1;
        Guest2 = gues2;
        Guest3 = guest3;
        Organizer1 = organizer1;
        Organizer2 = organizer2;
        Organizer3 = organizer3;
        Sponser = sponser;
    }

    public String getDate() {
        return Date;
    }
    public String getName() {
        return Name;
    }
    public String getId() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
    public void setName(String name) {
        Name = name;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getVenue() {
        return Venue;
    }

    public void setVenue(String venue) {
        Venue = venue;
    }

    public String getPerformer() {
        return Performer;
    }

    public void setPerformer(String performer) {
        Performer = performer;
    }

    public String getGuest1() {
        return Guest1;
    }

    public void setGuest1(String guest1) {
        Guest1 = guest1;
    }

    public String getGuest2() {
        return Guest2;
    }

    public void setGuest2(String guest2) {
        Guest2 = guest2;
    }

    public String getGuest3() {
        return Guest3;
    }

    public void setGuest3(String guest3) {
        Guest3 = guest3;
    }

    public String getOrganizer1() {
        return Organizer1;
    }

    public void setOrganizer1(String organizer1) {
        Organizer1 = organizer1;
    }

    public String getOrganizer2() {
        return Organizer2;
    }

    public void setOrganizer2(String organizer2) {
        Organizer2 = organizer2;
    }

    public String getOrganizer3() {
        return Organizer3;
    }

    public void setOrganizer3(String organizer3) {
        Organizer3 = organizer3;
    }

    public String getSponser() {
        return Sponser;
    }

    public void setSponser(String sponser) {
        Sponser = sponser;
    }
}
