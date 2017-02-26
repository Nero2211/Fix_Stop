package com.example.nero.register;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Phones extends AppCompatActivity {

    private String TAG = Phones.class.getSimpleName();
    Context context;
    private ProgressDialog progressDialog;
    private ListView listView;
    private static String url = "http://fixstop.hopto.org/webapp/getpost.php";
    ArrayList<posts>storePost = new ArrayList();
    Button addPost;

    //ArrayList<String> postList;
    //ArrayList<LinkedHashMap<String, String>> postList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phones);

        context = this;
        addPost = (Button)findViewById(R.id.phones_addPost);
        listView = (ListView) findViewById(R.id.phonesListView);
        getPost GetPost = new getPost();
        GetPost.execute();

        addPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Phones.this, postAdd.class);
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(position < storePost.size()){

                    Intent intent = new Intent(Phones.this, postViewDescription.class);

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
    }

    private class getPost extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            progressDialog = new ProgressDialog(Phones.this);
            progressDialog.setMessage("Please wait...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            BackgroundTask sh = new BackgroundTask();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONArray jsonObj = new JSONArray(jsonStr);

                    for (int i = 0; i < jsonObj.length(); i++) {

                        JSONObject c = jsonObj.getJSONObject(i);
                        posts postss = new posts(c.getInt("id"),
                                c.getString("title"),
                                c.getString("description"),
                                c.getString("datetime"),
                                c.getString("userid"));
                        storePost.add(postss);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });
                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (progressDialog.isShowing())
                progressDialog.dismiss();
            ArrayList<String> tempArray = new ArrayList<String>();
            if(storePost == null){
                tempArray.add("No Records Found...");
            }
            if(storePost != null){

                for(posts posts : storePost){
                    tempArray.add(posts.getPostTitle() + posts.getPostDescription() + posts.getPostDatetime() + posts.getUsername());
                }
            }
            CustomAdapter adapter = new CustomAdapter(getApplicationContext(), storePost);
            listView.setAdapter(adapter);
        }
    }
}















