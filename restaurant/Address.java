package com.example.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Address extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
    }

    public void OrderConfirm(View view) {
        Toast.makeText(Address.this, "Your oder has been confirmed!!!", Toast.LENGTH_SHORT).show();
        Intent Category = new Intent(Address.this, Category.class);
        startActivity(Category);
    }


}
