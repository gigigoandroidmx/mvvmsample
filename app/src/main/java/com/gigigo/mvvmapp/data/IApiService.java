package com.gigigo.mvvmapp.data;

import com.gigigo.kretrofitmanager.ICall;
import com.gigigo.mvvmapp.model.Credentials;
import com.gigigo.mvvmapp.model.Identity;
import com.gigigo.mvvmapp.model.ListUsers;
import com.gigigo.mvvmapp.model.SingleUser;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author Juan Godínez Vera - 5/23/2017.
 */
public interface IApiService {

    @GET("/api/users")
    ICall<ListUsers> getListUsers(@Query("page") int page);

    @GET("/api/users/{id}")
    ICall<SingleUser> getSingleUser(@Path("id") int userId);

    @POST("/api/login")
    ICall<Identity> login(@Body Credentials params);


    @GET("/api/users")
    ICall<ListUsers> addUser();
}
