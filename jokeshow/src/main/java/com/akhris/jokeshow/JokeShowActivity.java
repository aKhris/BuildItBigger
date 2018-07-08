package com.akhris.jokeshow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeShowActivity extends AppCompatActivity {

    public static final String BUNDLE_JOKE = "bundle_joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_show);
        TextView jokeText = findViewById(R.id.tv_joke_text);
        if(getIntent()!=null && getIntent().hasExtra(BUNDLE_JOKE)){
            String joke = getIntent().getStringExtra(BUNDLE_JOKE);
            jokeText.setText(joke);
        }
    }
}
