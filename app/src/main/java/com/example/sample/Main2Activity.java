package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sample.Models.CoinsItem;
import com.example.sample.Models.Response2;
import com.example.sample.RestApi.ManagerAll;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2Activity extends AppCompatActivity {

    String id;
    TextView descriptionTextView, nameTV, priceTV;
    ImageView iconUrlView;
    Response2 liste;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tanimla();
        al();
        istek();
    }

    public void al() {
        Bundle bundle = getIntent().getExtras();
        id = bundle.getString("id");
    }

    public void tanimla() {
        descriptionTextView = (TextView) findViewById(R.id.description);
        nameTV = (TextView) findViewById(R.id.name);
        priceTV = (TextView) findViewById(R.id.price2);
        iconUrlView = (ImageView) findViewById(R.id.iconUrl2);
    }

    public void atama(Response2 list) {

        for (CoinsItem item : list.getData().getCoins()) {
            if (item.getId() == Integer.parseInt(id)) {
                descriptionTextView.setText("" + item.getDescription());
                nameTV.setText("" + item.getName());
                priceTV.setText(String.format("%.2f", item.getPrice()));
                Utils.fetchSvg(activity, item.getIconUrl(), iconUrlView);
                setTitle("" + item.getSymbol());
            }
        }
    }

    public void istek() {

        Call<Response2> call = ManagerAll.getInstance().managerGetResult(id);
        call.enqueue(new Callback<Response2>() {
            @Override
            public void onResponse(Call<Response2> call, Response<Response2> response) {
                if (response.isSuccessful()) {
                    liste = response.body();
                    atama(liste);

                }
            }

            @Override
            public void onFailure(Call<Response2> call, Throwable t) {

            }
        });
    }
}

