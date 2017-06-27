package com.gigigo.mvvmapp.model;

/**
 * Wrapper class for user access information
 *
 * @author Juan Godínez Vera - 5/30/2017
 * @version 1.0.0
 * @since 1.0.0
 */
public class Identity {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
