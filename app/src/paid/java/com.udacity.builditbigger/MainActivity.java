package com.udacity.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.udacity.jokeandroidlibrary.JokesActivity;

public class MainActivity extends AppCompatActivity {

    private Button mJokeButtonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initViews();
    }

    private void initViews() {
        mJokeButtonView = (Button) findViewById(R.id.joke_button_view);
        mJokeButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getJoke();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void getJoke() {
        new JokesAsyncTask(new JokeAsyncHandler()).execute();
    }

    private class JokeAsyncHandler implements JokesAsyncTask.IGetJokesListener {

        @Override
        public void onGetJoke(String joke) {
            Intent intent = new Intent(MainActivity.this, JokesActivity.class);
            intent.putExtra(JokesActivity.GET_JOKE, joke);
            startActivity(intent);
        }
    }
}
