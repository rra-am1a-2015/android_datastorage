package com.adruijter.koffiebestelappje;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        //Toast.makeText(getBaseContext(),"Hallo de knop werkt", Toast.LENGTH_LONG).show();

        FileInputStream fis;
        int read;
        StringBuffer buffer = new StringBuffer();
        ArrayList<String> test = new ArrayList<String>();
        int index = 0;
        int teller = 0;
        try {
            fis = openFileInput("bestelling.txt");

            while((read = fis.read()) != -1)
            {
                buffer.append((char) read);

                /*
                if (buffer.lastIndexOf(" ") != -1)
                {
                    test.add(buffer.substring(index, buffer.length()));

                    index = buffer.lastIndexOf(" ");


                    teller++;
                }
                */


                //Toast.makeText(getApplicationContext(), buffer.substring(0, buffer.length()) +  Integer.toString(buffer.lastIndexOf(" ")) + test.get(0), Toast.LENGTH_SHORT).show();
            }

            String output = buffer.substring(0, buffer.length());
           // test.addAll(Arrays.asList(output.split(" ")));




            //Toast.makeText(getBaseContext(), output, Toast.LENGTH_LONG).show();
            Log.v("test", );

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
