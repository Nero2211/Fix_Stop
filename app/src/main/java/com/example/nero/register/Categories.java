package com.example.nero.register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Categories extends Activity {
    // do you have skype on your phone?
    //yeah but i need to log in, sec


    TextView phonesBtn, userProfile;
    Boolean test = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories);

        phonesBtn = (TextView) findViewById(R.id.categories_phones);
        phonesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Categories.this, Phones.class);
                startActivity(intent);
            }
        });


        userProfile = (TextView)findViewById(R.id.user);
        userProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(test == true){
                    Toast.makeText(Categories.this, "Please make sure you're logged in",
                            Toast.LENGTH_LONG).show();
                }
                else
                {
                    Intent intent = new Intent(Categories.this, UserProfile.class);
                    startActivity(intent);
                }
            }
        });

    }
}
