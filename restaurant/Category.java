package com.example.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class Category extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private Button logout;
    private ImageView foodorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        firebaseAuth = FirebaseAuth.getInstance();

        logout = (Button)findViewById(R.id.buttonLogout);

        ImageView foodorder = (ImageView) findViewById(R.id.foodordericon);
        TextView ordertext = (TextView) findViewById(R.id.ordertext);

        ImageView map = (ImageView) findViewById(R.id.mapicon);
        TextView maptext = (TextView) findViewById(R.id.maptext);

        ImageView reserve = (ImageView) findViewById(R.id.tableicon);
        TextView reservetext = (TextView) findViewById(R.id.tabletext);

        ImageView setting = (ImageView) findViewById(R.id.settingicon);
        TextView settigtext = (TextView) findViewById(R.id.settingtext);



        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logout();
            }
        });

        foodorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent foodorder = new Intent(Category.this,Foodorder.class);
                startActivity(foodorder);
            }
        });

        ordertext.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent ordertext = new Intent(Category.this,Foodorder.class);
                startActivity(ordertext);
            }
        });

       map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent map = new Intent(Category.this,Map.class);
                startActivity(map);
            }
        });

        maptext.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent maptext = new Intent(Category.this,Map.class);
                startActivity(maptext);
            }
        });

        reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reserve = new Intent(Category.this,Reservation.class);
                startActivity(reserve);
            }
        });

        reservetext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reservetext = new Intent(Category.this, Reservation.class);
                startActivity(reservetext);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setting = new Intent(Category.this,Setting.class);
                startActivity(setting);
            }
        });

        settigtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settigtext = new Intent(Category.this,Setting.class);
                startActivity(settigtext);
            }
        });

    }



    private void Logout(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(Category.this, MainActivity.class));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logoutMenu:{
                Logout();
            }
        }
        return super.onOptionsItemSelected(item);
    }






}
