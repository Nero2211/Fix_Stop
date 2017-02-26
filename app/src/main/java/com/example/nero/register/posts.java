package com.example.nero.register;

import java.util.Date;

/**
 * Created by Nero on 31/01/2017.
 */

public class posts {

    private int postid;
    private String postTitle;
    private String postDescription;
    private String postDatetime;
    private String idPostedBy;
    private String userName;



    public posts(int ID, String Title, String Description, String Datetime, String userID){
        this.postid = ID;
        this.postTitle = Title;
        this.postDescription = Description;
        this.postDatetime = Datetime;
        this.idPostedBy = userID;;
    }


    public String getUsername() {
        return userName;
    }

    public int getPostid() {
        return postid;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public String getPostDatetime() {
        return postDatetime;
    }

    public String getIdPostedBy() {
        return idPostedBy;
    }
}
