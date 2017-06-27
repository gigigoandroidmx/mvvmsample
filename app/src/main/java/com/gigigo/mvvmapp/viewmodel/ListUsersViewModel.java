package com.gigigo.mvvmapp.viewmodel;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.ObservableInt;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.gigigo.kretrofitmanager.ICall;
import com.gigigo.kretrofitmanager.ICallbackAdapter;
import com.gigigo.kretrofitmanager.ResponseState;
import com.gigigo.kretrofitmanager.ServiceClient;
import com.gigigo.mvvmapp.R;
import com.gigigo.mvvmapp.data.IApiService;
import com.gigigo.mvvmapp.model.ListUsers;
import com.gigigo.mvvmapp.model.User;
import com.gigigo.mvvmapp.view.ListUsersAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Juan Godínez Vera - 6/26/2017.
 */
public class ListUsersViewModel
        extends BaseViewModel {

    public ListUsersViewModel(Context context) {
        super(context);
    }

    public void fetchUserList() {
        setIsBusy(true);
        IApiService service = ServiceClient.createService(IApiService.class);

        ICall<ListUsers> call = service.getListUsers(0);
        call.enqueue(new ICallbackAdapter<ListUsers>() {
            @Override
            public void onDataEmpty() {

            }

            @Override
            public void onSuccess(ListUsers data) {
                setIsBusy(false);
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
        this.userList = userList;
        notifyChange();
    }

    @BindingAdapter("itemsSource")
    public static void setItemsSource(RecyclerView view, List<User> source) {
        ListUsersAdapter adapter = (ListUsersAdapter) view.getAdapter();
        adapter.setItemsSource(source);
    }

    public void addUser(View view) {
        new MaterialDialog.Builder(getContext())
                .title("Agregar usuario")
                .customView(R.layout.item_add_user, false)
                .positiveText("aceptar")
                .negativeText("cancelar")
                .show();
    }
}
