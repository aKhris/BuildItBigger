package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.akhris.jokeshow.JokeShowActivity;
import com.udacity.gradle.builditbigger.MainActivityFragment;

public class MainActivity extends AppCompatActivity implements GetJokesTask.JokesTaskCallback {

    private MainActivityFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment = (MainActivityFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        onLoadingStarted(true);
        new GetJokesTask(this).execute();
    }


    @Override
    public void gotJoke(String joke) {
        onLoadingStarted(false);
        Intent jokeIntent = new Intent(this, JokeShowActivity.class);
        jokeIntent.putExtra(JokeShowActivity.BUNDLE_JOKE, joke);
        startActivity(jokeIntent);
    }

    public void onLoadingStarted(boolean isStarted) {
    if(isStarted){
        fragment.onJokeLoadingStarted();
    } else {
        fragment.onJokeLoaded();
    }
    }
}
