package com.beasty.transitionold.view.model;

/**
 *
 */
public class FeedViewModel {
    private String title;
    private String urlAvatar;

    public FeedViewModel(String band, String avatar) {
        title = band;
        urlAvatar = avatar;
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
}
