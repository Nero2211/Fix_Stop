package com.example.nero.register;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nero on 31/01/2017.
 */

public class CustomAdapter extends BaseAdapter {
    ArrayList<posts> result;
    Context context;
    private static LayoutInflater inflater = null;

    public CustomAdapter(Context mainActivity, ArrayList<posts> posts){
        result = posts;
        context = mainActivity;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return result.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder
    {
        TextView title;
        TextView desc;
        TextView date;
        TextView username;
    }

    @Override
    public View getView(final int position, View counvertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView;
            rowView = inflater.inflate(R.layout.list_item, null);
            holder.title = (TextView) rowView.findViewById(R.id.post_title);
            holder.desc = (TextView) rowView.findViewById(R.id.post_desc);
            holder.date = (TextView) rowView.findViewById(R.id.post_date);
            holder.username = (TextView) rowView.findViewById(R.id.postedBy);

            holder.title.setText(result.get(position).getPostTitle());
            holder.desc.setText(result.get(position).getPostDescription());
            holder.date.setText(result.get(position).getPostDatetime());
            holder.username.setText(result.get(position).getUsername());

        return rowView;
    }
}
