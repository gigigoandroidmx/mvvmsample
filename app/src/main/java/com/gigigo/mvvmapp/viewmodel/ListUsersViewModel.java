package com.gigigo.mvvmapp.viewmodel;

import android.content.Context;
import android.databinding.ObservableInt;
import android.view.View;

import com.gigigo.kretrofitmanager.ICall;
import com.gigigo.kretrofitmanager.ICallbackAdapter;
import com.gigigo.kretrofitmanager.ResponseState;
import com.gigigo.kretrofitmanager.ServiceClient;
import com.gigigo.mvvmapp.data.IApiService;
import com.gigigo.mvvmapp.model.ListUsers;
import com.gigigo.mvvmapp.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Juan Godínez Vera - 6/26/2017.
 */
public class ListUsersViewModel
        extends BaseViewModel {

    public ObservableInt recycleVisibility;
    public ObservableInt progressviewVisibility;

    public ListUsersViewModel(Context context) {
        super(context);
        this.userList = new ArrayList<>();
        recycleVisibility = new ObservableInt(View.GONE);
        progressviewVisibility = new ObservableInt(View.GONE);
    }

    public void fetchUserList() {
        progressviewVisibility = new ObservableInt(View.VISIBLE);
        IApiService service = ServiceClient.createService(IApiService.class);

        ICall<ListUsers> call = service.getListUsers(0);
        call.enqueue(new ICallbackAdapter<ListUsers>() {
            @Override
            public void onDataEmpty() {

            }

            @Override
            public void onSuccess(ListUsers data) {
                recycleVisibility.set(View.VISIBLE);
                progressviewVisibility = new ObservableInt(View.GONE);

                setUserList(data.getUserList());
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

    private List<User> userList;


    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList.addAll(userList);
        notifyChange();
    }
}
