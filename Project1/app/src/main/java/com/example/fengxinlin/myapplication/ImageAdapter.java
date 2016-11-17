package com.example.fengxinlin.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by fengxinlin on 11/16/16.
 */
public class ImageAdapter extends ArrayAdapter<String> {
    private LayoutInflater mLayoutInflater;
    private Context context;
    private int layoutId;
    private int imageViewId;

    public ImageAdapter(Context context, int layoutId, int imageViewId, ArrayList<String> urls) {
        super(context, 0, urls);
        this.mLayoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.layoutId = layoutId;
        this.imageViewId = imageViewId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;
        if (view == null) {
            view = mLayoutInflater.inflate(layoutId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) view.findViewById(imageViewId);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        String url = getItem(position);
        Picasso.with(context).load(url).into(viewHolder.imageView);
        return view;
    }

    static class ViewHolder {
        ImageView imageView;
    }
}
