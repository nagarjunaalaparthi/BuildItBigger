package com.udacity.jokeandroidlibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokesActivity extends AppCompatActivity {

    public static final String GET_JOKE = "GET_JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            TextView jokesView = (TextView) findViewById(R.id.joke_tv);
            jokesView.setText(extras.getString(GET_JOKE));
        }
    }
}
