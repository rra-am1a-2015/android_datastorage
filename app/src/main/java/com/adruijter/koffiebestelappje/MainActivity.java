package com.adruijter.koffiebestelappje;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private String milkYesOrNo(CheckBox chkbxMilk)
    {
        if ( chkbxMilk.isChecked())
        {
            return "wel";
        }
        else
        {
            return "geen";
        }
    }

    private String sugarYesOrNo(CheckBox chkbxSugar)
    {
        if ( chkbxSugar.isChecked())
        {
            return "wel";
        }
        else
        {
            return "geen";
        }
    }

    public void bestelKoffie(View view)
    {
        EditText txtFirstname = (EditText) findViewById(R.id.firstname);
        EditText txtInfix =  (EditText) findViewById(R.id.infix);
        EditText txtLastname = (EditText) findViewById(R.id.lastname);
        EditText txtNumberOfCoffee = (EditText) findViewById(R.id.numberOfCoffee);
        EditText txtDebugText = (EditText) findViewById(R.id.debugTekst);
        CheckBox chkbxMilk = (CheckBox) findViewById(R.id.milk);
        CheckBox chkbxSugar = (CheckBox) findViewById(R.id.sugar);
        SeekBar skbar = (SeekBar) findViewById(R.id.seek_bar);

        String output = String.format("Voornaam: %s \n" +
                                      "Tussenvoegsel: %s \n" +
                                      "Achternaam: %s \n" +
                                      "Aantal kopjes koffie: %s \n" +
                                      "Wel of geen melk: %s \n" +
                                      "Wel of geen suiker: %s \n" +
                                      "Koffie sterkte %s",
                                      txtFirstname.getText(),
                                      txtInfix.getText(),
                                      txtLastname.getText(),
                                      txtNumberOfCoffee.getText(),
                                      this.milkYesOrNo(chkbxMilk),
                                      this.sugarYesOrNo(chkbxSugar),
                                      skbar.getProgress());
        txtDebugText.setText(output);
    }
}
