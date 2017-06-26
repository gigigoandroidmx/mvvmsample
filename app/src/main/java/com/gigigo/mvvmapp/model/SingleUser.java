package com.gigigo.mvvmapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Juan Godínez Vera - 6/23/2017.
 */
public class SingleUser {

    @SerializedName("data")
    @Expose
    private User data;

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }
}
