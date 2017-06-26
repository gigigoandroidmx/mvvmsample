package com.gigigo.mvvmapp;

import android.app.Application;

import com.gigigo.kretrofitmanager.CallAdapterFactory;
import com.gigigo.kretrofitmanager.ServiceClient;
import com.gigigo.mvvmapp.utils.Connectivity;
import com.gigigo.mvvmapp.utils.RequestInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ihsanbal.logging.Level;
import com.ihsanbal.logging.LoggingInterceptor;

import okhttp3.internal.platform.Platform;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Juan Godínez Vera - 6/26/2017.
 */
public class App
        extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initialize();
    }

    private void initialize() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();

        LoggingInterceptor loggerInterceptor = new LoggingInterceptor.Builder()
                .loggable(BuildConfig.DEBUG)
                .setLevel(Level.BASIC)
                .log(Platform.INFO)
                .request("Request")
                .response("Response")
                .build();

        if (BuildConfig.DEBUG) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        }

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .serializeNulls()
                .create();

        RequestInterceptor requestInterceptor = new RequestInterceptor(
                new Connectivity(this));

        ServiceClient.init()
                .setLoggingInterceptor(loggerInterceptor)
                .setCallAdapterFactory(new CallAdapterFactory())
                .setConnectivityInterceptor(requestInterceptor)
                .addEndpoint(BuildConfig.HOST)
                .addConverterFactory(GsonConverterFactory.create(gson));

    }
}
