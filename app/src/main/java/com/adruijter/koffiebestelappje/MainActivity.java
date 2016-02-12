package com.adruijter.koffiebestelappje;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void bestelKoffie(View view)
    {
        EditText txtFirstname = (EditText) findViewById(R.id.firstname);
        EditText txtInfix =  (EditText) findViewById(R.id.infix);
        EditText txtLastname = (EditText) findViewById(R.id.lastname);
        EditText txtNumberOfCoffee = (EditText) findViewById(R.id.numberOfCoffee);
        EditText txtDebugText = (EditText) findViewById(R.id.debugTekst);
        CheckBox chkbxMilk = (CheckBox) findViewById(R.id.milk);
        txtDebugText.setText("Voornaam: " + txtFirstname.getText() + "\n" +
                "Tussenvoegsel: " + txtInfix.getText() + "\n" +
                "Achternaam: " + txtLastname.getText() + "\n" +
                "Aantal kopjes koffie: " + txtNumberOfCoffee.getText());
    }
}
