package com.example.nero.register;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Retrofit;

public class postAdd extends AppCompatActivity {
    EditText ETtitle, ETdescription;
    String title, description;
    Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_add);


        ETtitle = (EditText)findViewById(R.id.phones_title);
        ETdescription = (EditText)findViewById(R.id.phones_description);
        btnSubmit = (Button)findViewById(R.id.post_submit);
    }


    public void addPost(View view){


        title = ETtitle.getText().toString();
        description = ETdescription.getText().toString();

        //if(BackgroundTask.loggedin == true) {
            if (title.equals("")) {
                Toast.makeText(postAdd.this, "Please input title!",
                        Toast.LENGTH_SHORT).show();
            } else if (description.equals("")) {
                Toast.makeText(postAdd.this, "Please input description!",
                        Toast.LENGTH_SHORT).show();
            } else {
                String method = "addpost";
                BackgroundTask backgroundTask = new BackgroundTask(this);
                backgroundTask.execute(method, title, description);
                finish();
            }
        }
        /*else{
            Toast.makeText(postAdd.this, "Please register before posting problems!",
                    Toast.LENGTH_LONG).show();
        }

    }*/

}
