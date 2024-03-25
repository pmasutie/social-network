package com.codurance;

public class Timeline {
    private String username;
    private String userPost;

    public boolean isEmpty() {
        return userPost == null;
    }

    public void post(String username, String userPost) {
        this.username = username;
        this.userPost = userPost;
    }
}
