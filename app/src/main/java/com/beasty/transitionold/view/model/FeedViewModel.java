package com.beasty.transitionold.view.model;

/**
 *
 */
public class FeedViewModel {
    private String title;
    private String urlAvatar;
    private int id;

    public FeedViewModel(String band, String avatar, int id) {
        title = band;
        urlAvatar = avatar;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }
}
