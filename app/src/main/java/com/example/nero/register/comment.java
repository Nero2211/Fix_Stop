package com.example.nero.register;

/**
 * Created by Nero on 01/02/2017.
 */

public class comment {

    private String id, userid, postid, comment, date, userFirstname, userLastname, username;



    public comment(String commentID, String userID, String postID, String commentDesc,
                   String datetime, String firstname, String lastname, String username){
        this.id = commentID;
        this.userid = userID;
        this.postid = postID;
        this.comment = commentDesc;
        this.date = datetime;
        this.userFirstname = firstname;
        this.userLastname = lastname;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public String getUserid() {
        return userid;
    }

    public String getPostid() {
        return postid;
    }

    public String getComment() {
        return comment;
    }

    public String getDate() {
        return date;
    }

    public String getUserFirstname() {
        return userFirstname;
    }

    public String getUserLastname() {
        return userLastname;
    }

    public String getUsername() {
        return username;
    }
}
