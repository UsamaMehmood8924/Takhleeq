package com.example.takhleeqproject;

import java.io.Serializable;

public class Announcement_content implements Serializable {
    private String name;
    private String heading;
    private String content;
    private String date;
    private String time;

    public Announcement_content(){
        name = "Asad";
        heading = "This is the heading text of the announcement";
        content = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like)";
        date = "Jan,05,1998";
        time = "10:10:10 am";
    };
    public Announcement_content(String name, String heading,String content, String date, String time) {
        this.name = name;
        this.heading = heading;
        this.content = content;
        this.date = date;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeading() {
        return heading;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
