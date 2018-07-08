package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    ProgressBar progressBar;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        progressBar = rootView.findViewById(R.id.pb_loading_progress);
        return rootView;
    }

    public void onJokeLoadingStarted(){
        progressBar.setVisibility(View.VISIBLE);
    }

    public void onJokeLoaded(){
        progressBar.setVisibility(View.INVISIBLE);
    }
}
