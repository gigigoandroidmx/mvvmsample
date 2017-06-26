package com.gigigo.mvvmapp.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;

/**
 * @author Juan Godínez Vera - 6/23/2017.
 */
public class BaseViewModel
        extends BaseObservable {

    private final Context context;

    public BaseViewModel(Context context) {
        this.context = context;
    }
}
