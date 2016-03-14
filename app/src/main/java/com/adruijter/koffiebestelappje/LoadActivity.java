package com.adruijter.koffiebestelappje;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadActivity extends Activity {
    //Fields
    TextView dataTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        this.dataTxt = (TextView)findViewById(R.id.internMemText);
    }


    public void newOrder(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void showOrders(View view)
    {

        Toast.makeText(getBaseContext(),"Hallo de knop werkt", Toast.LENGTH_LONG).show();

        FileInputStream fis;
        int read;
        StringBuffer buffer = new StringBuffer();
        try {
            fis = openFileInput("bestelling.txt");

            while((read = fis.read()) != -1)
            {
                buffer.append((char) read);
                Toast.makeText(getApplicationContext(),buffer.substring(0, buffer.length()) +  Integer.toString(buffer.lastIndexOf(" ")), Toast.LENGTH_SHORT).show();
            }

            String output = buffer.substring(0, buffer.length());

            Toast.makeText(getBaseContext(), output, Toast.LENGTH_LONG).show();
            this.dataTxt.setText(output);

        }
        catch(FileNotFoundException e)
        {
            e.getMessage();
        }
        catch(IOException e)
        {
            e.getMessage();
        }
    }
}
