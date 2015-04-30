package com.thedeveloperworldisyours.pureconnect.dao;

import android.content.Context;

import com.thedeveloperworldisyours.pureconnect.Utils.Constants;
import com.thedeveloperworldisyours.pureconnect.models.Artist;

import garin.artemiy.sqlitesimple.library.SQLiteSimpleDAO;

/**
 * Created by javiergonzalezcabezas on 29/4/15.
 */
public class ArtistDAO extends SQLiteSimpleDAO<Artist> {
    public ArtistDAO(Context context){
        super(Artist.class,context, Constants.DATABASE_NAME);
    }
}
