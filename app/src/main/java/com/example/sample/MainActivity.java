package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.sample.Models.Response2;
import com.example.sample.RestApi.ManagerAll;
import com.example.sample.adapters.CoinsAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    CoinsAdapter coinsAdapter;
    Response2 list;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();
        istek();
    }

    public void tanimla() {
        listView = (ListView) findViewById(R.id.list_view);
    }

    public void istek() {

        Call<Response2> bilgiList = ManagerAll.getInstance().getirBilgileri();
        bilgiList.enqueue(new Callback<Response2>() {
            @Override
            public void onResponse(Call<Response2> call, Response<Response2> response) {
                if (response.isSuccessful()) {
                    coinsAdapter = new CoinsAdapter(response.body(), getApplicationContext(), MainActivity.this);
                    listView.setAdapter(coinsAdapter);

                }
            }

            @Override
            public void onFailure(Call<Response2> call, Throwable t) {

            }
        });
    }
}
