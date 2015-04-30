package com.thedeveloperworldisyours.pureconnect;

import android.app.Application;

import com.thedeveloperworldisyours.pureconnect.Utils.Constants;
import com.thedeveloperworldisyours.pureconnect.models.Album;
import com.thedeveloperworldisyours.pureconnect.models.Artist;

import garin.artemiy.sqlitesimple.library.SQLiteSimple;
import garin.artemiy.sqlitesimple.library.util.SimpleDatabaseUtil;

/**
 * Created by javiergonzalezcabezas on 29/4/15.
 */
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (SimpleDatabaseUtil.isFirstApplicationStart(this)) {
            SQLiteSimple databaseSimple = new SQLiteSimple(this, Constants.DATABASE_NAME);
            databaseSimple.create(Album.class);
            databaseSimple.create(Artist.class);
        }
    }

}
