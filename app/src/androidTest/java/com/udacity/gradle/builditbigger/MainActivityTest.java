package com.udacity.gradle.builditbigger;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.akhris.jokeshow.JokeShowActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public IntentsTestRule<MainActivity> mTestRule = new IntentsTestRule<>(MainActivity.class);

    @Test
    public void getJokesAndVerifyResult(){
        onView(withId(R.id.button_tell_joke))
                .perform(click());
            intended(
                    is(
                            hasExtra(is(JokeShowActivity.BUNDLE_JOKE), not(withText("")))
                    )
            );
    }
}
