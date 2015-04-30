package com.thedeveloperworldisyours.pureconnect.Acitvites;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.thedeveloperworldisyours.pureconnect.R;
import com.thedeveloperworldisyours.pureconnect.Utils.Constants;
import com.thedeveloperworldisyours.pureconnect.Utils.Utils;
import com.thedeveloperworldisyours.pureconnect.Webservice.Client;
import com.thedeveloperworldisyours.pureconnect.adapter.ListViewAdapter;
import com.thedeveloperworldisyours.pureconnect.dao.AlbumDAO;
import com.thedeveloperworldisyours.pureconnect.dao.ArtistDAO;
import com.thedeveloperworldisyours.pureconnect.models.Album;
import com.thedeveloperworldisyours.pureconnect.models.Artist;
import com.thedeveloperworldisyours.pureconnect.models.Pure;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private AlbumDAO mAlbumDAO;
    private ArtistDAO mArtistDAO;
    private ProgressDialog mProgress;
    private List<Artist> mArtistList;
    private List<Album> mAlbums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.activity_main_listView);
        mAlbumDAO = new AlbumDAO(this);
        mArtistDAO = new ArtistDAO(this);
        mProgress = new ProgressDialog(this, R.style.Transparent);
        getData();
    }

    /**
     * This method get artists from database
     */

    public void getInfoArtistFromDB() {
        List<Artist> artistList = new ArrayList<Artist>();
        artistList = mArtistDAO.readAllAsc();
    }

    /**
     * this method gets data from database or from internet
     */

    public void getData() {
        if (exitsDB()) {
            getInfoArtistFromDB();
            mArtistList = (List<Artist>) mArtistDAO.readAllAsc();
            builtList();
            mProgress.cancel();
        } else if (Utils.isOnline(MainActivity.this)) {
            getPure();
        } else {
            Toast.makeText(this, R.string.no_connection, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * this method check if there is data
     * @return
     */

    public boolean exitsDB() {

        int album = mAlbumDAO.getCount();
        int artist = mArtistDAO.getCount();
        return album > 0 && artist > 0;
    }

    /**
     * this method clears the data from database when we get info from internet
     */

    public void clearDB() {
        mAlbumDAO.deleteAll();
        mArtistDAO.deleteAll();
    }

    /**
     * this methods calls REST API
     */
    public void getPure() {
        Callback<Pure> callback = new Callback<Pure>() {
            @Override
            public void success(Pure pure, Response response) {
                clearDB();
                insertArtistsAndAlbums(pure);
            }

            @Override
            public void failure(RetrofitError error) {
                mProgress.cancel();
                Toast.makeText(MainActivity.this, R.string.error_data,Toast.LENGTH_SHORT).show();
            }
        };
        Client.initRestAdapter().getPure(callback);
    }

    /**
     * this method insert artists and albums in database
     * @param pure
     */
    public void insertArtistsAndAlbums(Pure pure) {
        mArtistList = pure.getArtists();
        mAlbums = pure.getAlbums();
        builtList();
        CustomAsyncTask asyncTask = new CustomAsyncTask();
        asyncTask.execute();

    }

    /**
     * this method builds listview
     */
    public void builtList() {
        mListView.setAdapter(new ListViewAdapter(MainActivity.this, 0, mArtistList));
        mListView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        List<Artist> artistList = mArtistDAO.readAllAsc();
        if(!(artistList.size() ==0)) {
            List<Album> albumList = mAlbumDAO.readAllWhere(Constants.COLUMN_ID_ARITIST, artistList.get(position).getId());
            Intent intent = new Intent(MainActivity.this, DetailAcitivity.class).putExtra(Constants.PASS_ARTIST, artistList.get(position));
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    }

    private class CustomAsyncTask extends AsyncTask<Pure, Integer, Boolean> {

        @Override
        protected Boolean doInBackground(Pure... pure) {
            for (int i = 0; i < mArtistList.size(); i++) {
                mArtistDAO.create(mArtistList.get(i));
            }
            for (int i = 0; i < mAlbums.size(); i++) {
                mAlbumDAO.create(mAlbums.get(i));
            }
            return true;
        }

        @Override
        protected void onPreExecute() {
            mProgress.show();
            mProgress.setCancelable(false);
        }

        @Override
        protected void onPostExecute(Boolean result) {
            mProgress.cancel();
            Toast.makeText(MainActivity.this, R.string.save_data,Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onCancelled() {
            mProgress.cancel();
        }
    }

}
