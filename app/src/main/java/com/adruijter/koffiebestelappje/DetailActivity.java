package com.adruijter.koffiebestelappje;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends Activity {

    // Fields

    private TextView firstname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //Intent intent = new

        this.firstname = (TextView)findViewById(R.id.voornaam);

    }


}
