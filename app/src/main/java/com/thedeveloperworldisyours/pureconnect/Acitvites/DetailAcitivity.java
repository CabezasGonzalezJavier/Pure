package com.thedeveloperworldisyours.pureconnect.Acitvites;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.thedeveloperworldisyours.pureconnect.R;
import com.thedeveloperworldisyours.pureconnect.Utils.Constants;
import com.thedeveloperworldisyours.pureconnect.adapter.ListViewAlbumsAdapter;
import com.thedeveloperworldisyours.pureconnect.dao.AlbumDAO;
import com.thedeveloperworldisyours.pureconnect.models.Album;
import com.thedeveloperworldisyours.pureconnect.models.Artist;
import com.thedeveloperworldisyours.pureconnect.view.CircleTransform;

import java.util.List;

public class DetailAcitivity extends ActionBarActivity {

    private AlbumDAO mAlbumDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_acitivity);

        mAlbumDAO = new AlbumDAO(this);
        Intent i = getIntent();
        Artist artist = (Artist)i.getSerializableExtra(Constants.PASS_ARTIST);
        List<Album> albumList = mAlbumDAO.readAllWhere(Constants.COLUMN_ID_ARITIST,artist.getId());
        TextView name = (TextView) findViewById(R.id.activity_detail_firstLine);
        TextView genres = (TextView) findViewById(R.id.activity_detail_secondLine);
        ImageView image = (ImageView) findViewById(R.id.activity_detail_icon);
        ListView listView = (ListView) findViewById(R.id.activity_detail_listView);
        TextView description = (TextView) findViewById(R.id.activity_detail_description);

        name.setText(artist.getName());
        genres.setText(artist.getGenres());
        description.setText(artist.getDescription());
        Picasso.with(DetailAcitivity.this).load(artist.getPicture()).transform(new CircleTransform()).into(image);
        listView.setAdapter(new ListViewAlbumsAdapter(DetailAcitivity.this, 0, albumList));
    }

    /**
     * this method was created for animation between activities
     */
    public void cameback()
    {
        finish();
        overridePendingTransition(R.anim.right, R.anim.left);
    }

    @Override
    public void onBackPressed()
    {
        cameback();
    }


}
