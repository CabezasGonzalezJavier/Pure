package com.thedeveloperworldisyours.pureconnect.models;
import com.google.gson.annotations.Expose;
import com.thedeveloperworldisyours.pureconnect.Utils.Constants;

import java.io.Serializable;

import garin.artemiy.sqlitesimple.library.annotations.Column;

/**
 * Created by javiergonzalezcabezas on 29/4/15.
 */
public class Album implements Serializable {
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_Title = "title";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_PICTURE = "picture";

    @Column(name = COLUMN_ID)
    @Expose
    private String id;
    @Column(name = Constants.COLUMN_ID_ARITIST)
    @Expose
    private String artistId;
    @Column(name = COLUMN_Title)
    @Expose
    private String title;
    @Column(name = COLUMN_TYPE)
    @Expose
    private String type;
    @Column(name = COLUMN_PICTURE)
    @Expose
    private String picture;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The artistId
     */
    public String getArtistId() {
        return artistId;
    }

    /**
     *
     * @param artistId
     * The artistId
     */
    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     *
     * @param picture
     * The picture
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

}
