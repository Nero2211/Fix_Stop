package com.example.nero.register;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Nero on 03/02/2017.
 */

public interface FromWebsite {


    @FormUrlEncoded
    @POST("Webapp/getpostcomment.php")
    Call<List<Commentfromapi>> passID(@Field("postid") int first);


    @FormUrlEncoded
    @POST("Webapp/getuserpost.php")
    Call<List<Postfromapi>> userID(@Field("userid")int first);

    @FormUrlEncoded
    @POST("Webapp/login.php")
    Call<List<Userfromapi>> userDetails(@Field("username")String username,
                                        @Field("password")String password);


}
