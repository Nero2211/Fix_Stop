package com.example.nero.register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

public class Login extends Activity {


    EditText et_Username, et_Password;
    String login_username, login_password;
    TextView registerTV, guest;
    Boolean userLoggedin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        et_Username = (EditText) findViewById(R.id.login_username);
        et_Password = (EditText) findViewById(R.id.login_password);
        registerTV = (TextView)findViewById(R.id.register_textview);
        guest = (TextView)findViewById(R.id.guest_textview);

        registerTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });

        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Categories.class);
                startActivity(intent);
            }
        });
    }

    //LOGIN BUTTON ON CLICK METHOD
    public void userLogin(View view)
    {

        //login_username = et_Username.getText().toString();
        //login_password = et_Password.getText().toString();

        login_username = "ShadowH11";
        login_password = "hams1121";

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://fixstop.hopto.org/")
                .build();

        FromWebsite fromWebsite = retrofit.create(FromWebsite.class);
        Call<List<Userfromapi>> stringCall = fromWebsite.userDetails(login_username, login_password);
        stringCall.enqueue(new Callback<List<Userfromapi>>() {
            @Override
            public void onResponse(Call<List<Userfromapi>> call, Response<List<Userfromapi>> response) {
                //User User = new User(response.body());
                Toast.makeText(Login.this, "Logged in successful!",
                        Toast.LENGTH_LONG).show();

                // TODO check body size()
                Userfromapi body = response.body().get(0);
                User user = new User(body.id, body.firstname, body.lastname, body.username);

                //User user = new User(1, "NERO", "MC", "NEROOOO.VV1111");
                CurrentUser currentUser = CurrentUser.getInstance();
                currentUser.setCurrentUser(user);
                Intent intent = new Intent(Login.this, Categories.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<List<Userfromapi>> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
                Toast.makeText(Login.this, "Logged in failed!",
                        Toast.LENGTH_LONG).show();

            }
        });

    }
}




/*login_username = et_Username.getText().toString();
        login_password = et_Password.getText().toString();
        String method = "login";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,login_username,login_password);*/