package com.codurance;

import javax.swing.text.StringContent;

public class Timeline {
    private String user;
    private String userPost;

    public boolean isEmpty() {
        if(userPost != null) {
            return false;
        }
        return true;
    }

    public void post(String user, String userPost) {
        this.user = user;
        this.userPost = userPost;
    }
}
