package com.example.sample.RestApi;

import com.example.sample.MainActivity;
import com.example.sample.Models.Response2;

import retrofit2.Call;

public class ManagerAll extends BaseManager {
    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance() {
        return ourInstance;
    }

    public Call<Response2> getirBilgileri() {
        Call<Response2> call = getRestApiClient().bilgiGetir(MainActivity.class.getPackage().getName());
        return call;
    }

    public Call<Response2> managerGetResult(String id) {
        Call<Response2> call2 = getRestApiClient().ozellikGetir(MainActivity.class.getPackage().getName(), id);
        return call2;
    }
}
