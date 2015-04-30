package com.thedeveloperworldisyours.pureconnect.models;

import com.google.gson.annotations.Expose;
import java.io.Serializable;


import garin.artemiy.sqlitesimple.library.annotations.Column;

/**
 * Created by javiergonzalezcabezas on 29/4/15.
 */
public class Artist implements Serializable {
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_ARTIST_GENRES = "genres";
    public static final String COLUMN_ARTIST_PICTURES = "picture";
    public static final String COLUMN_ARTIST_NAME = "name";
    public static final String COLUMN_ARTIST_DESCRIPTION = "description";

    @Column(name = COLUMN_ID)
    @Expose
    private String id;
    @Column(name = COLUMN_ARTIST_GENRES)
    @Expose
    private String genres;
    @Column(name = COLUMN_ARTIST_PICTURES)
    @Expose
    private String picture;
    @Column(name = COLUMN_ARTIST_NAME)
    @Expose
    private String name;
    @Column(name = COLUMN_ARTIST_DESCRIPTION)
    @Expose
    private String description;

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The genres
     */
    public String getGenres() {
        return genres;
    }

    /**
     * @param genres The genres
     */
    public void setGenres(String genres) {
        this.genres = genres;
    }

    /**
     * @return The picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * @param picture The picture
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
