package com.example.nero.register;

import android.content.Context;

import java.util.List;

/**
 * Created by Nero on 13/02/2017.
 */

public class CurrentUser {

    private static CurrentUser currentUser;
    private User user;

    private CurrentUser(){

    }

    public static void init() {
        logoutUser();
    }

    public static void logoutUser() {
        getInstance().user = new User(-1, "Guest", "Guest", "Guest");
    }

    public static boolean isLoggedIn() {
        return getInstance().getCurrentUser().getId() > 0;
    }

    public static CurrentUser getInstance(){
        if(currentUser == null){
            currentUser = new CurrentUser();
        }
        return currentUser;
    }

    public void setCurrentUser(User user){
        this.user = user;
    }

    public User getCurrentUser(){
        return user;
    }
}
