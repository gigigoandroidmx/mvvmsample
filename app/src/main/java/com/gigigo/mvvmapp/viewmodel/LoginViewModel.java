package com.gigigo.mvvmapp.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.databinding.Bindable;
import android.view.View;

import com.android.databinding.library.baseAdapters.BR;
import com.gigigo.kretrofitmanager.ICall;
import com.gigigo.kretrofitmanager.ICallbackAdapter;
import com.gigigo.kretrofitmanager.ResponseState;
import com.gigigo.kretrofitmanager.ServiceClient;
import com.gigigo.mvvmapp.data.IApiService;
import com.gigigo.mvvmapp.model.Credentials;
import com.gigigo.mvvmapp.model.Identity;
import com.gigigo.mvvmapp.utils.sharedpreferences.SharedPreferencesManager;
import com.gigigo.mvvmapp.view.MainActivity;

/**
 * @author Juan Godínez Vera - 6/26/2017.
 */
public class LoginViewModel
        extends BaseViewModel {

    private String email;
    private String password;

    public LoginViewModel(Context context) {
        super(context);
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        if(this.email != null && this.email.equals(email)) return;

        this.email = email;
        notifyPropertyChanged(BR.email);
    }

    public void setPassword(String password) {
        if(this.password != null && this.password.equals(password)) return;

        this.password = password;
        notifyPropertyChanged(BR.password);
    }


    public void onLogin(View view) {
        setIsBusy(true);
        Credentials credentials = new Credentials();
        credentials.setEmail(this.email);
        credentials.setPassword(this.password);

        IApiService service = ServiceClient.createService(IApiService.class);
        ICall<Identity> call = service.login(credentials);

        call.enqueue(new ICallbackAdapter<Identity>() {
            @Override
            public void onDataEmpty() {

            }

            @Override
            public void onSuccess(Identity data) {
                setIsBusy(false);
                boolean saved = SharedPreferencesManager.setSharedPreferenceAs(SharedPreferencesManager.SharedKeys.LOGIN_KEY,
                        data,
                        true);
                if(saved) {
                    Intent intent = new Intent(getContext(), MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    getContext().startActivity(intent);
                }
            }

            @Override
            public void onUnauthorized() {

            }

            @Override
            public void onError(Throwable exception) {

            }

            @Override
            public void onDataNotAvailable(ResponseState entryState) {

            }
        });
    }

}
