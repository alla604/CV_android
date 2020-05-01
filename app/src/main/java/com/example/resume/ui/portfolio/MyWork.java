package com.example.resume.ui.portfolio;

public class MyWork {
    private String title;
    private String hashtag;
    private String description;
    private int imgId;

    public MyWork (String title, String hashtag, String description, int imgId) {
        this.title = title;
        this.hashtag = hashtag;
        this.description = description;
        this.imgId = imgId;
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getHashtag() {
        return hashtag;
    }

    public int getImgId() {
        return imgId;
    }
}
