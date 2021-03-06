package com.adruijter.koffiebestelappje;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
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
    private static final int NUM_ROWS = 2;
    private static final int NUM_COLS = 9;
    private String[] words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        showOrders();
        //this.dataTxt = (TextView)findViewById(R.id.internMemText);
    }


    public void newOrder(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void showOrders()
    {

        TableLayout table = (TableLayout) findViewById(R.id.tableInternalMemory);

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

            for ( int row = 0; row < sentences.length; row++)
            {
                words = sentences[row].split(" ");
                TableRow tableRow = new TableRow(this);


                TableLayout.LayoutParams tableRowParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);


                tableRowParams.setMargins(10, 10, 10,10);

                tableRow.setLayoutParams(tableRowParams);







                tableRow.setLayoutParams(new TableLayout.LayoutParams(
                        TableLayout.LayoutParams.MATCH_PARENT,
                        TableLayout.LayoutParams.MATCH_PARENT,
                        1.0f
                ));
                table.addView(tableRow);

                for ( int col = 0; col < words.length; col++)
                {
                    //Button button = new Button(this);
                    TextView colView = new TextView(this);
                    String text = words[col];
                    colView.setText(text);
                    colView.setPadding(0, 0, 0, 0);
                    colView.setTextSize(9);
                    colView.setBackgroundColor(Color.rgb(200, 200, 200));



                    colView.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                           TableRow.LayoutParams.MATCH_PARENT,
                           1.0f
                    ));
                    tableRow.addView(colView);
                }
                Button button = new Button(this);
                button.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.MATCH_PARENT,
                        1.0f
                ));
                button.setText("Wijzig");
                View.OnClickListener knop = new View.OnClickListener()
                {
                        public void onClick(View v)
                        {
                            Toast.makeText(getApplicationContext(), "Er is op de knop gedrukt", Toast.LENGTH_LONG).show();
                            nextActivity(words);
                        }
                };
                button.setOnClickListener(knop);

                tableRow.addView(button);
            }

            Log.v("test123", sentences[1]);

            //this.dataTxt.setText(output);


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

    private void nextActivity(String[] words)
    {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("voornaam", words[0]);
        intent.putExtra("tussenvoegsel", words[1]);
        intent.putExtra("achternaam", words[2]);
        intent.putExtra("aantalKoffie", words[3]);
        startActivity(intent);
    }
}
