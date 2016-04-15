package com.adruijter.koffiebestelappje;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends Activity {

    // Fields

    private TextView firstnameView;
    private TextView infixView;
    private TextView lastnameView;
    private TextView amountOfCoffeeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String firstname = intent.getStringExtra("voornaam");
        String infix = intent.getStringExtra("tussenvoegsel");
        String lastname = intent.getStringExtra("achternaam");
        String amountOfCoffee = intent.getStringExtra("aantalKoffie");
        this.firstnameView = (TextView)findViewById(R.id.voornaam);
        this.infixView = (TextView)findViewById(R.id.tussenvoegsel);
        this.lastnameView = (TextView)findViewById(R.id.achternaam);
        this.amountOfCoffeeView = (TextView)findViewById(R.id.aantalKoffie);

        this.firstnameView.setText("Voornaam: " + firstname);
        this.infixView.setText("Tussenvoegsel: " + infix);
        this.lastnameView.setText("Achternaam: " + lastname);
        this.amountOfCoffeeView.setText("Aantal koffie: " + amountOfCoffee);

    }


}
