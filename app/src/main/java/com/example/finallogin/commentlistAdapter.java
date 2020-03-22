package com.example.finallogin;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class commentlistAdapter extends BaseAdapter {

    private Context context;
    private List<receivecomment> commentList;



    public commentlistAdapter(Context context, List<receivecomment> commentList) {
        this.context = context;
        this.commentList = commentList;
    }

    @Override
    public int getCount() {
        return commentList.size();
    }

    @Override
    public Object getItem(int i) {
        return commentList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View v=View.inflate(context,R.layout.comment,null);
        TextView commentuserid=(TextView)v.findViewById(R.id.commentuserid);
        TextView comment=(TextView)v.findViewById(R.id.comment);
        TextView commentdate=(TextView)v.findViewById(R.id.commentDate);

        commentuserid.setText(commentList.get(i).getCommentuserid());
        comment.setText(commentList.get(i).getComment());
        commentdate.setText(commentList.get(i).getCommentdate());

        v.setTag(commentList.get(i).comment);
        return v;
    }
}
