package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private ProgressBar progressBar;
    private InterstitialAd mInterstitialAd;
    private AdRequest adRequest;


    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        progressBar = root.findViewById(R.id.pb_loading_progress);
            AdView mAdView = root.findViewById(R.id.adView);


                // Create an ad request. Check logcat output for the hashed device ID to
                // get test ads on a physical device. e.g.
                // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
                adRequest = new AdRequest.Builder()
                        .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                        .build();
                mAdView.loadAd(adRequest);

            mInterstitialAd = new InterstitialAd(getContext());
            mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
            mInterstitialAd.loadAd(adRequest);

        return root;
    }

    public void onJokeLoadingStarted(){
        progressBar.setVisibility(View.VISIBLE);
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    public void onJokeLoaded(){
        progressBar.setVisibility(View.INVISIBLE);
    }
}
