package com.example.nero.register;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity {

    EditText ETname, ETlast, ETusername, ETpassword;
    String firstname, lastname, user_name, user_pass;
    Button register;
    boolean registerPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        ETname = (EditText)findViewById(R.id.register_name);
        ETlast = (EditText)findViewById(R.id.register_last);
        ETusername = (EditText)findViewById(R.id.register_username);
        ETpassword = (EditText)findViewById(R.id.register_password);
    }

    public void userRegister(View view)
    {

        firstname = ETname.getText().toString();
        lastname = ETlast.getText().toString();
        user_name = ETusername.getText().toString();
        user_pass = ETpassword.getText().toString();

        if(firstname.equals("")){
            Toast.makeText(Register.this, "Please input firstname",
                    Toast.LENGTH_LONG).show();
        }
        else if (lastname.equals(""))
        {
            Toast.makeText(Register.this, "Please input lastname",
                    Toast.LENGTH_LONG).show();
        }
        else if (user_name.equals(""))
        {
            Toast.makeText(Register.this, "Please input username",
                    Toast.LENGTH_LONG).show();
        }
        else if (user_pass.equals(""))
        {
            Toast.makeText(Register.this, "Please input password",
                    Toast.LENGTH_LONG).show();
        }
        else
        {
            String method = "register";
            BackgroundTask backgroundTask = new BackgroundTask(this);
            backgroundTask.execute(method, firstname, lastname, user_name, user_pass);
            finish();
        }

    }




}
