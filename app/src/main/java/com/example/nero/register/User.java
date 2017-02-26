package com.example.nero.register;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Nero on 01/02/2017.
 */

public class User implements Serializable {
    private int id;
    private String firstname;
    private String lastname;
    private String username;

    public User(int id, String firstname, String lastname, String username){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }
}
