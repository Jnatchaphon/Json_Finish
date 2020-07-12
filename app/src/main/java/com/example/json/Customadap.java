package com.example.json;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Customadap extends ArrayAdapter<Datamodel>{


    private ArrayList<Datamodel> dataSet;
    Context mContext;

    private static class ViewHolder {
        TextView id;
        TextView login;
        TextView display;
        TextView url;
        ImageView img;
    }

    public Customadap(ArrayList<Datamodel> data, Context context) {
        super(context, R.layout.datalist, data);
        this.dataSet = data;
        this.mContext=context;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Datamodel dataModel = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.datalist, parent, false);

            viewHolder.id = (TextView) convertView.findViewById(R.id.idlist);
            viewHolder.login = (TextView) convertView.findViewById(R.id.loginlist);
            viewHolder.display = (TextView) convertView.findViewById(R.id.displayloginlist);
            viewHolder.url = (TextView) convertView.findViewById(R.id.urllist);
            viewHolder.img = (ImageView) convertView.findViewById(R.id.imglist);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.id.setText(dataModel.getId().toString());
        viewHolder.login.setText(dataModel.getLogin());
        viewHolder.display.setText(dataModel.getDisplay());
        viewHolder.url.setText(dataModel.getUrl());

        String aa = dataModel.getImg();

        aa = aa.substring(1, aa.length() - 1);

        Picasso.get().load(aa).into(viewHolder.img);

        return convertView;
    }
}