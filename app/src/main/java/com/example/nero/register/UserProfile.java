package com.example.nero.register;

import android.content.Intent;
import android.media.Image;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class UserProfile extends AppCompatActivity {

    TextView userFirstname, userLastname, username;
    private FragmentManager fm = getSupportFragmentManager();
    private UserPosts userPosts;
    private User user;
    ImageView goBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        //WIRING IN THE VARIABLES
        userFirstname = (TextView)findViewById(R.id.profile_fname);
        userLastname = (TextView)findViewById(R.id.profile_lname);
        username = (TextView)findViewById(R.id.profile_username);
        goBack = (ImageView)findViewById(R.id.user_profile_goback);

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserProfile.this, Categories.class);
                startActivity(intent);
            }
        });

        //USER DETAILS
        CurrentUser currentUser = CurrentUser.getInstance();

        if(currentUser != null){
            //SETTING CURRENT USER VALUES
            userFirstname.setText(currentUser.getCurrentUser().getFirstname().toString());
            userLastname.setText(currentUser.getCurrentUser().getLastname().toString());
            username.setText(currentUser.getCurrentUser().getUsername());
            //userFirstname.setText(user.getFirstname());
            //userLastname.setText(user.getLastname());
            //username.setText(user.getUsername());
        }
        //FRAGMENT
        userPosts = new UserPosts();
        fm.beginTransaction().replace(R.id.fragmentContainer, new UserPosts()).commit();

    }
}
