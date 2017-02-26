package com.example.nero.register;

import android.app.Application;

/**
 * Created by Nero on 26/02/2017.
 */
public class FixStop extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Guest User
        CurrentUser.init();
    }
}
