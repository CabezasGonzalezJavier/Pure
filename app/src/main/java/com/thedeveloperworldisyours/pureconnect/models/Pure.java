package com.thedeveloperworldisyours.pureconnect.models;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by javiergonzalezcabezas on 29/4/15.
 */
public class Pure {

    @Expose
    private List<Artist> artists = new ArrayList<Artist>();
    @Expose
    private List<Album> albums = new ArrayList<Album>();

    /**
     *
     * @return
     * The artists
     */
    public List<Artist> getArtists() {
        return artists;
    }

    /**
     *
     * @param artists
     * The artists
     */
    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    /**
     *
     * @return
     * The albums
     */
    public List<Album> getAlbums() {
        return albums;
    }

    /**
     *
     * @param albums
     * The albums
     */
    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

}
