package com.example.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OrderDetail extends AppCompatActivity {

    TextView listView, priceView;
    String list_choice;
    Double price_thb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_order_detail);
        listView = (TextView) findViewById(R.id.listView);

        priceView = (TextView) findViewById(R.id.priceView);

        Bundle bundle = getIntent().getExtras();

        list_choice = bundle.getString("choices");

        price_thb = bundle.getDouble("price");

        listView.setText(list_choice);
        priceView.setText(String.format("total price = %s ฿", price_thb));


    }

    public void Address(View view) {
        Intent alarcarte = new Intent(OrderDetail.this, Address.class);
        startActivity(alarcarte);
    }
}
