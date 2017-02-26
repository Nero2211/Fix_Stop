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
 * Created by Nero on 01/02/2017.
 */

public class CommentCustomAdapter extends BaseAdapter {

    List<Commentfromapi> result;
    Context context;
    private static LayoutInflater inflater = null;

    public CommentCustomAdapter(Context mainActivity, List<Commentfromapi> comments)
    {
        result = comments;
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
        TextView userComment;
        TextView date;
        TextView username;
    }

    @Override
    public View getView(final int position, View counvertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView;
            rowView = inflater.inflate(R.layout.comment_listitem, null);
            holder.userComment = (TextView) rowView.findViewById(R.id.comment_description_xml);
            holder.date = (TextView) rowView.findViewById(R.id.comment_date_xml);
            holder.username = (TextView) rowView.findViewById(R.id.comment_writer_xml);

            holder.userComment.setText(result.get(position).description);
            holder.date.setText(result.get(position).date_time);
            holder.username.setText(result.get(position).username);

        return rowView;
    }
}
