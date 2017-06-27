package com.gigigo.mvvmapp.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingConversion;
import android.view.View;

import com.android.databinding.library.baseAdapters.BR;

/**
 * @author Juan Godínez Vera - 6/23/2017.
 */
public class BaseViewModel
        extends BaseObservable {

    private boolean isBusy;

    private final Context context;

    public BaseViewModel(Context context) {
        this.context = context;
        this.isBusy = false;
    }

    public Context getContext() {
        return this.context;
    }

    @Bindable
    public boolean getIsBusy() {
        return this.isBusy;
    }

    public void setIsBusy(boolean isBusy) {
        this.isBusy = isBusy;
        notifyPropertyChanged(BR.isBusy);
    }

    @BindingConversion
    public static int convertBooleanToVisibility(boolean visible) {
        return visible ? View.VISIBLE : View.GONE;
    }
}
