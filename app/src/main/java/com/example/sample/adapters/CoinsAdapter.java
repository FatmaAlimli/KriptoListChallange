package com.example.sample.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.sample.Main2Activity;
import com.example.sample.Models.Response2;
import com.example.sample.R;
import com.example.sample.Utils;

public class CoinsAdapter extends BaseAdapter {
    Response2 list;
    Context context;
    Activity activity;

    public CoinsAdapter(Response2 list, Context context, Activity activity) {
        this.list = list;
        this.context = context;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return list.getData().getCoins().size();
    }

    @Override
    public Object getItem(int position) {
        return list.getData().getCoins().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.layout, parent, false);

        LinearLayout layoutList;
        layoutList = convertView.findViewById(R.id.layoutList);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.iconUrl);
        TextView symbol = (TextView) convertView.findViewById(R.id.symbol);
        TextView price = (TextView) convertView.findViewById(R.id.price);

        symbol.setText(list.getData().getCoins().get(position).getSymbol());
        price.setText(String.format("%.2f", list.getData().getCoins().get(position).getPrice()));

        if (list.getData().getCoins().get(position).getColor() != null) {
            try {
                symbol.setTextColor(Color.parseColor(list.getData().getCoins().get(position).getColor()));
                price.setTextColor(Color.parseColor(list.getData().getCoins().get(position).getColor()));
            } catch (Exception e) {
                symbol.setTextColor(Color.rgb(0, 0, 0));
                price.setTextColor(Color.rgb(0, 0, 0));
            }
        }

        Utils.fetchSvg(activity, list.getData().getCoins().get(position).getIconUrl(), imageView);

        final String Id = "" + list.getData().getCoins().get(position).getId();

        layoutList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ıntent = new Intent(activity, Main2Activity.class);
                ıntent.putExtra("id", Id);
                activity.startActivity(ıntent);
            }
        });

        return convertView;
    }
}
