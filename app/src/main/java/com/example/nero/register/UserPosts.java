package com.example.nero.register;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserPosts extends Fragment {

    ListView listView;
    int userID = 8;
    ArrayList<posts>storePost = new ArrayList();

    public UserPosts() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_posts, container, false);

        listView = (ListView)view.findViewById(R.id.userPosts);

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://fixstop.hopto.org/")
                .build();

        FromWebsite fromWebsite = retrofit.create(FromWebsite.class);
        Call<List<Postfromapi>> stringCall = fromWebsite.userID(userID);
        stringCall.enqueue(new Callback<List<Postfromapi>>() {
            @Override
            public void onResponse(Call<List<Postfromapi>> call, Response<List<Postfromapi>> response) {
                Usercustomadapter usercustomadapter = new Usercustomadapter(getActivity(), response.body());
                listView.setAdapter(usercustomadapter);
            }

            @Override
            public void onFailure(Call<List<Postfromapi>> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                if(position < storePost.size()) {
                    Intent intent = new Intent(getActivity(), postViewDescription.class);
                    posts chosenPost = storePost.get(position);
                    intent.putExtra("postid", chosenPost.getPostid());
                    intent.putExtra("title", chosenPost.getPostTitle());
                    intent.putExtra("description", chosenPost.getPostDescription());
                    intent.putExtra("date", chosenPost.getPostDatetime());

                    //NEED TO CHANGE IT TO USE ID .GETUSERID!!!!
                    intent.putExtra("userid", chosenPost.getPostDatetime());
                    startActivity(intent);
                }
            }
        });

        return view;
    }

}
