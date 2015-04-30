package com.thedeveloperworldisyours.pureconnect.Webservice;

import com.squareup.okhttp.OkHttpClient;
import com.thedeveloperworldisyours.pureconnect.Utils.Constants;
import com.thedeveloperworldisyours.pureconnect.models.Pure;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by javiergonzalezcabezas on 29/4/15.
 */
public class Client {
    public interface ClientInterface{
        @GET("/data.json")
        void getPure(Callback<Pure> callback);
    }

    public static ClientInterface initRestAdapter()
    {
        OkHttpClient client = new OkHttpClient();

        return (ClientInterface) new RestAdapter.Builder()
                .setClient(new OkClient(client))
                .setEndpoint(Constants.URL)
                .build()
                .create(ClientInterface.class);
    }
}
