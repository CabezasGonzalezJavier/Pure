package com.thedeveloperworldisyours.pureconnect.dao;

import android.content.Context;

import com.thedeveloperworldisyours.pureconnect.Acitvites.MainActivity;
import com.thedeveloperworldisyours.pureconnect.Utils.Constants;
import com.thedeveloperworldisyours.pureconnect.models.Album;

import garin.artemiy.sqlitesimple.library.SQLiteSimpleDAO;
/**
 * Created by javiergonzalezcabezas on 29/4/15.
 */
public class AlbumDAO extends SQLiteSimpleDAO<Album> {
    public AlbumDAO(Context context) {
        super(Album.class, context, Constants.DATABASE_NAME);
    }
}