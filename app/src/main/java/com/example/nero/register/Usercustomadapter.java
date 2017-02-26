package com.example.nero.register;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10146504 on 07/02/2017.
 */

public class Usercustomadapter extends BaseAdapter {

    List<Postfromapi> result;
    Context context;
    private static LayoutInflater inflater = null;

    public Usercustomadapter(Context mainActivity, List<Postfromapi> posts){
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
    }

    @Override
    public View getView(final int position, View counvertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.userpostlistview, null);
        holder.title = (TextView) rowView.findViewById(R.id.userpost_title);
        holder.desc = (TextView) rowView.findViewById(R.id.userpost_desc);
        holder.date = (TextView) rowView.findViewById(R.id.userpost_date);

        holder.title.setText(result.get(position).title);
        holder.desc.setText(result.get(position).description);
        holder.date.setText(result.get(position).datetime);

        return rowView;
    }
}
