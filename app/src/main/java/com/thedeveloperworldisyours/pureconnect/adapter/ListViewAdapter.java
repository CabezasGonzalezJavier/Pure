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
import com.thedeveloperworldisyours.pureconnect.models.Artist;
import com.thedeveloperworldisyours.pureconnect.models.Pure;
import com.thedeveloperworldisyours.pureconnect.view.CircleTransform;

import java.util.List;

/**
 * Created by javiergonzalezcabezas on 29/4/15.
 */
public class ListViewAdapter extends ArrayAdapter<Artist>{

    private Activity mActivity;
    private List<Artist> mListArtist;

    public ListViewAdapter(Context context, int resource, List<Artist> objects) {
        super(context, resource, objects);
        mActivity = (Activity) context;
        mListArtist = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mActivity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item_list, parent, false);
        TextView name = (TextView) rowView.findViewById(R.id.item_list_firstLine);
        TextView genres = (TextView) rowView.findViewById(R.id.item_list_secondLine);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.item_list_icon);

        name.setText(mListArtist.get(position).getName());
        genres.setText(mListArtist.get(position).getGenres());
        Picasso.with(mActivity).load(mListArtist.get(position).getPicture()).transform(new CircleTransform()).into(imageView);


        return rowView;
    }

}
