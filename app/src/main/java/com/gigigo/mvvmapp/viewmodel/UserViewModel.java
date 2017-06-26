package com.gigigo.mvvmapp.viewmodel;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.gigigo.mvvmapp.model.User;

/**
 * @author Juan Godínez Vera - 6/23/2017.
 */
public class UserViewModel
        extends BaseViewModel {

    private User user;

    public UserViewModel(Context context, User user) {
        super(context);
        this.user = user;
    }

    public void setUser(User user) {
        this.user = user;
        notifyChange();
    }

    public String getFirstName() {
        return user.getFirstName();
    }

    public String getLastName() {
        return user.getLastName();
    }

    public String getAvatar() {
        return user.getAvatar();
    }

    @BindingAdapter("imageSource")
    public static void setImageSource(ImageView view, String source) {
        Glide.with(view.getContext())
                .load(source)
                .into(view);
    }
}
