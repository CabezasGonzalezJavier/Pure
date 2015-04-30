package com.thedeveloperworldisyours.pureconnect.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.thedeveloperworldisyours.pureconnect.R;
import com.thedeveloperworldisyours.pureconnect.models.Album;
import com.thedeveloperworldisyours.pureconnect.view.CircleTransform;

import java.util.List;

/**
 * Created by javiergonzalezcabezas on 30/4/15.
 */
public class ListViewAlbumsAdapter extends ArrayAdapter<Album> {

private Activity mActivity;
private List<Album> mListAlbums;

public ListViewAlbumsAdapter(Context context, int resource, List<Album> objects) {
        super(context, resource, objects);
        mActivity = (Activity) context;
        mListAlbums = objects;
        }


@Override
public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mActivity
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item_list, parent, false);
        TextView name = (TextView) rowView.findViewById(R.id.item_list_firstLine);
        TextView genres = (TextView) rowView.findViewById(R.id.item_list_secondLine);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.item_list_icon);

        name.setText(mListAlbums.get(position).getTitle());
        genres.setText(mListAlbums.get(position).getType());
        Picasso.with(mActivity).load(mListAlbums.get(position).getPicture()).transform(new CircleTransform()).into(imageView);


        return rowView;
        }
}
