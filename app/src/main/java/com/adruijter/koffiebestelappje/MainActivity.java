package com.adruijter.koffiebestelappje;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    //Fields
    CalendarView cld;
    EditText txtFirstname,
             txtInfix,
             txtLastname,
             txtNumberOfCoffee,
             txtDebugText;
    CheckBox chkbxMilk,
             chkbxSugar;
    SeekBar  skbar;
    Date     date;
    String   test = "",
             saveText = "",
             saveTextData = "";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.cld = (CalendarView) findViewById(R.id.calendar);
        this.txtFirstname  = (EditText) findViewById(R.id.firstname);
        this.txtInfix =  (EditText) findViewById(R.id.infix);
        this.txtLastname = (EditText) findViewById(R.id.lastname);
        this.txtNumberOfCoffee = (EditText) findViewById(R.id.numberOfCoffee);
        this.txtDebugText = (EditText) findViewById(R.id.debugTekst);
        this.chkbxMilk = (CheckBox) findViewById(R.id.milk);
        this.chkbxSugar = (CheckBox) findViewById(R.id.sugar);
        this.skbar = (SeekBar) findViewById(R.id.seek_bar);
        this.cld.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override

            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                test = dayOfMonth + "/" + (month + 1) + "/" + year;
                Toast.makeText(getApplicationContext(), test, Toast.LENGTH_SHORT).show();
                //bestelKoffie(view);
            }
        });
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

    private String readableDate(CalendarView cld){
        this.date = new Date(cld.getDate());
        String dateOutput = new SimpleDateFormat("dd-MM-yyyy").format(date);
        return dateOutput;
    }

    public void bestelKoffie(View view)
    {
        this.cld = (CalendarView) findViewById(R.id.calendar);
        String output = String.format("Voornaam: %s \n" +
                        "Tussenvoegsel: %s \n" +
                        "Achternaam: %s \n" +
                        "Aantal kopjes koffie: %s \n" +
                        "Wel of geen melk: %s \n" +
                        "Wel of geen suiker: %s \n" +
                        "Koffie sterkte %s \n" +
                        "Datum: %s",
                this.txtFirstname.getText(),
                this.txtInfix.getText(),
                this.txtLastname.getText(),
                this.txtNumberOfCoffee.getText(),
                this.milkYesOrNo(chkbxMilk),
                this.sugarYesOrNo(chkbxSugar),
                this.skbar.getProgress(),
                //this.readableDate(this.cld));
                this.test);

        String outputTxt = String.format("%s %s %s %s %s %s %s %s" + System.lineSeparator(),
                this.txtFirstname.getText(),
                this.txtInfix.getText(),
                this.txtLastname.getText(),
                this.txtNumberOfCoffee.getText(),
                this.milkYesOrNo(chkbxMilk),
                this.sugarYesOrNo(chkbxSugar),
                this.skbar.getProgress(),
                //this.readableDate(this.cld));
                this.test);
        this.saveText = output;
        this.saveTextData = outputTxt;
        this.txtDebugText.setText(output);
        saveOrder(view);


    }

    public void saveOrder(View view)
    {
        // Deze method is verantwoordelijk voor het opslaan in het interne geheugen van onze tekst.
        FileOutputStream fos;
        File file = null;
        try
        {
            file = getFilesDir();
            fos = openFileOutput("bestelling.txt", Context.MODE_PRIVATE | MODE_APPEND);
            fos.write(this.saveTextData.getBytes());
            fos.close();
        }
        catch (FileNotFoundException e)
        {
            e.getMessage();
        }
        catch(IOException e)
        {
            e.getMessage();
        }

        Toast.makeText(getApplicationContext(), "De bestelling is opgenomen! in de map: " + file.toString(), Toast.LENGTH_LONG).show();
    }

    public void showOrder(View view)
    {
        Intent intent = new Intent(this, LoadActivity.class);
        startActivity(intent);
    }

}
