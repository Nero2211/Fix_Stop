package com.example.nero.register;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class postViewDescription extends AppCompatActivity {

    TextView title, desc, date, noComment, postedBy;
    String getTitle, getDescription, getDate, getuserID;
    EditText commentET;
    int getPostID;
    String numberOfComments;
    ImageView postImage;

    private String TAG = postViewDescription.class.getSimpleName();
    Context context;
    private ListView listView;
    ArrayList<comment>storeComment = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_view_description);

        context = this;

        title = (TextView)findViewById(R.id.postview_Title);
        desc = (TextView)findViewById(R.id.postview_Description);
        date = (TextView)findViewById(R.id.postview_Datetime);
        noComment = (TextView)findViewById(R.id.description_numberofComment);
        postedBy = (TextView)findViewById(R.id.view_description_postedBy);
        commentET = (EditText)findViewById(R.id.comment_edittext);

        Bundle extras = getIntent().getExtras();
        getPostID = extras.getInt("postid");
        getTitle = extras.getString("title");
        getDescription = extras.getString("description");
        getDate = extras.getString("date");

        title.setText(getTitle);
        desc.setText(getDescription);
        date.setText(getDate);
        //noComment.setText("");

        listView = (ListView)findViewById(R.id.commentListView);

        noComment.setText("0");

        //RETROFIT MAKING CALL TO THE WEB TO DOWNLOAD COMMENTS TO THE RELATED POST
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://fixstop.hopto.org/")
                .build();

        FromWebsite fromWebsite = retrofit.create(FromWebsite.class);
        Call<List<Commentfromapi>> stringCall = fromWebsite.passID(getPostID);
        stringCall.enqueue(new Callback<List<Commentfromapi>>() {
            @Override
            public void onResponse(Call<List<Commentfromapi>> call, Response<List<Commentfromapi>> response) {
                response.body();
                CommentCustomAdapter adapter = new CommentCustomAdapter
                        (postViewDescription.this, response.body());
                listView.setAdapter(adapter);
                //Getting the numbers of items inside the listview to display the number of comments made on that post
                int count = listView.getCount();
                noComment.setText(String.valueOf(count));
            }

            @Override
            public void onFailure(Call<List<Commentfromapi>> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);

            }
        });

        commentET.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                /*if (actionId == EditorInfo.IME_ACTION_DONE) {
                    handled = true;
                }
                return handled;*/
                return true;
            }
        });

    }
}
