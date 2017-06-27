package com.gigigo.mvvmapp.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gigigo.mvvmapp.R;
import com.gigigo.mvvmapp.model.Identity;
import com.gigigo.mvvmapp.utils.sharedpreferences.SharedPreferencesManager;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Identity identity = SharedPreferencesManager.getSharedPreferenceAs(Identity.class,
                        SharedPreferencesManager.SharedKeys.LOGIN_KEY,
                        null);

                if(identity == null) {
                    navigateTo(LoginActivity.class);
                } else {
                    navigateTo(MainActivity.class);
                }
            }
        }, 1000);
    }

    private void navigateTo(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
