package com.adruijter.koffiebestelappje;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
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
    private static final int NUM_ROWS = 4;
    private static final int NUM_COLS = 9;

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

        TableLayout table = (TableLayout) findViewById(R.id.tableInternalMemory);

        for ( int row = 0; row < NUM_ROWS; row++)
        {
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT,
                    1.0f
            ));
            table.addView(tableRow);

            for ( int col = 0; col < NUM_COLS; col++)
            {
                Button button = new Button(this);
                button.setText("" + row + ", " + col);
                button.setPadding(0, 0 , 0, 0);
                button.setTextSize(9);
                button.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.MATCH_PARENT,
                        1.0f
                ));
                tableRow.addView(button);
            }
        }



        FileInputStream fis;
        int read;




        int index = 0;
        int teller = 0;

        try {

            String[] sentences;
            fis = openFileInput("bestelling.txt");
            StringBuffer buffer = new StringBuffer();

            while((read = fis.read()) != -1)
            {
                buffer.append((char)read);
            }
            String output = buffer.substring(0, buffer.length());

            sentences = output.split(System.getProperty("line.separator"));

            Log.v("test123", sentences[1] );

            this.dataTxt.setText(output);



            //Toast.makeText(getBaseContext(),"Hallo de knop werkt", Toast.LENGTH_LONG).show();
            //Toast.makeText(getBaseContext(), output, Toast.LENGTH_LONG).show();
            // test.addAll(Arrays.asList(output.split(" ")));
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
