package com.gigigo.mvvmapp.viewmodel;

import android.content.Context;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

/**
 * @author Juan Godínez Vera - 6/27/2017.
 */
public class AddUserViewModel
        extends BaseViewModel {

    private String name;
    private String job;

    public AddUserViewModel(Context context) {
        super(context);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
        notifyPropertyChanged(BR.job);
    }
}
