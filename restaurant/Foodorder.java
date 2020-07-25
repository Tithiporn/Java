package com.example.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Foodorder extends AppCompatActivity {


    Button alacarte;
    Button dessert;
    Button drinks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodorder);

        alacarte = (Button) findViewById(R.id.alacartebtn);
        dessert = (Button) findViewById(R.id.desserbtn);
        drinks = (Button) findViewById(R.id.drinkbtn);


        alacarte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent alarcarte = new Intent(Foodorder.this, Alarcarte.class);
                startActivity(alarcarte);
            }
        });


        dessert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dessert = new Intent(Foodorder.this, Dessert.class);
                startActivity(dessert);
            }
        });

        drinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent drink = new Intent(Foodorder.this , Drink.class);
                startActivity(drink);
            }
        });
    }

}
