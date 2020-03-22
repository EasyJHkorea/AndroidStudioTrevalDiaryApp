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

public class signlistAdapter extends BaseAdapter {

    private Context context;
    private List<receivesign> signList;



    public signlistAdapter(Context context, List<receivesign> signList) {
        this.context = context;
        this.signList = signList;
    }

    @Override
    public int getCount() {
        return signList.size();
    }

    @Override
    public Object getItem(int i) {
        return signList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View v=View.inflate(context,R.layout.sign,null);


        TextView commentuserid=(TextView)v.findViewById(R.id.signtext);
        TextView commentdate=(TextView)v.findViewById(R.id.commentdate);
        TextView comment=(TextView)v.findViewById(R.id.comment123);


        commentuserid.setText(signList.get(i).getCommentuserid());
        commentdate.setText(signList.get(i).getCommentdate());
        comment.setText(signList.get(i).getComment());


        v.setTag(signList.get(i).getCommentuserid());

        return v;
    }
}
