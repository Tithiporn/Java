package com.example.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Alarcarte extends AppCompatActivity {


    String choices = " ";
    double price = 0.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarcarte);




    }

    public void add_to_list(View view){
        if (view == findViewById(R.id.Btnpizza)){
            choices = choices+"Pizza"+"\n";
            price = price + 470;

        }

        else if(view == findViewById(R.id.Btnminestone)){
            choices = choices+"Mind Stone Soup"+"\n";
            price = price + 80;
        }

        else if(view == findViewById(R.id.Btnburger)){
            choices = choices+"Burger"+"\n";
            price = price + 150;
        }

        else if(view == findViewById(R.id.Btncornsoup)){
            choices = choices+"Corn Soup"+"\n";
            price =price +100;
        }

        else if(view == findViewById(R.id.Btnsalad)){
            choices = choices+"Greek Salad"+"\n";
            price =price +130;
        }

        else if(view == findViewById(R.id.Btnraviolo)){
            choices = choices+"Ravioli"+"\n";
            price =price +120;
        }

        else if(view == findViewById(R.id.Btnfrenchfries)){
            choices = choices+"French Fries"+"\n";
            price = price + 80;
        }

        else if(view == findViewById(R.id.Btnlasagna)){
            choices = choices+"Lasagna"+"\n";
            price = price + 200;
        }

        else if(view == findViewById(R.id.Btnmushroomcarbonara)){
            choices = choices+"Mushroom Carbonara"+"\n";
            price = price + 110;
        }

        else if(view == findViewById(R.id.Btnporkball)){
            choices = choices+"Spaghetti Pork Ball"+"\n";
            price = price + 200;
        }

        else if(view == findViewById(R.id.Btnrisotto)){
            choices = choices+"Risotto"+"\n";
            price = price + 130;
        }

        else if(view == findViewById(R.id.Btnpestolinguine)){
            choices = choices+"Pesto Lingunie"+"\n";
            price = price + 180;
        }


        //drinks
        else if(view == findViewById(R.id.Btnapplejuice)){
            choices = choices+"Apple Juice"+"\n";
            price = price + 60;
        }

        else if(view == findViewById(R.id.Btndrinkingwater)){
            choices = choices+"Drinking water"+"\n";
            price = price + 20;
        }

        else if(view == findViewById(R.id.Btngrapejuice)){
            choices = choices+"Grape Juice"+"\n";
            price = price + 60;
        }

        else if(view == findViewById(R.id.Btnhotcappuccino)){
            choices = choices+"Hot Cappuccino"+"\n";
            price = price + 80;
        }

        else if(view == findViewById(R.id.Btnhotmocha)){
            choices = choices+"Hot Mocha"+"\n";
            price = price + 80;
        }

        else if(view == findViewById(R.id.Btnorangejuice)){
            choices = choices+"Orange Juice"+"\n";
            price = price + 60;
        }

        else if(view == findViewById(R.id.Btnspakling)){
            choices = choices+"Sparkling water"+"\n";
            price = price + 25;
        }

        else if(view == findViewById(R.id.Btnminaral)){
            choices = choices+"Mineral water"+"\n";
            price = price + 25;
        }

        //dessert
        else if(view == findViewById(R.id.Btnchocolatepanforte)){
            choices = choices+"Chocolate Panforte"+"\n";
            price = price + 150;
        }

        else if(view == findViewById(R.id.Btnchouxcream)){
            choices = choices+"Choux Cream"+"\n";
            price = price + 160;
        }

        else if(view == findViewById(R.id.Btngelato)){
            choices = choices+"Gelato Ice-cream"+"\n";
            price = price + 60;
        }

        else if(view == findViewById(R.id.Btnpannacotta)){
            choices = choices+"Pannacotta"+"\n";
            price = price + 50;
        }

        else if(view == findViewById(R.id.Btnpandorosemifreddo)){
            choices = choices+"Pandoro Semifreddo"+"\n";
            price = price + 170;
        }

        else if(view == findViewById(R.id.Btncannoli)){
            choices = choices+"Cannoli"+"\n";
            price = price + 120;

        }

        else if(view == findViewById(R.id.Btntriamisu)){
            choices = choices+"Tiramisu"+"\n";
            price = price + 100;
        }

        else if(view == findViewById(R.id.Btnrascake)){
            choices = choices+"Raspberry Ricotta Cake"+"\n";
            price = price + 130;
        }
    }

   

    public void placeOder(View view) {
        Intent i =  new Intent(Alarcarte.this, OrderDetail.class);
        Bundle bundle = new Bundle();
        bundle.putString("choices",choices);
        bundle.putDouble("price",price);
        i.putExtras(bundle);
        startActivity(i);
    }

    public void LinktoDrink(View view) {

        startActivity(new Intent(Alarcarte.this, Drink.class));
    }

    public void LinktoDessert(View view) {
        startActivity(new Intent(Alarcarte.this, Dessert.class));
    }

    public void LinktoAlacarte(View view) {
        startActivity(new Intent(Alarcarte.this, Alarcarte.class));
    }
}
