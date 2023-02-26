package com.github.lindsaybordier.bootcamp;

import android.content.Intent;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> testRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void correctIntentFiredOnButtonClick() {
        String str = "Enter your Name";
        String name = "Gerard";
        Intents.init();

        onView(withId(R.id.mainGoButton)).check(matches(isDisplayed()));

        onView(withId(R.id.inputText)).perform(typeText(name));

        onView(withId(R.id.inputText)).perform(closeSoftKeyboard());

        onView(withId(R.id.inputText)).check(matches(withText(name)));

        onView(withId(R.id.mainGoButton)).perform(click());

        Intents.intended(hasComponent(GreetingActivity.class.getName()));

        Intents.intended(hasExtra("name", name));

        Intents.release();
    }



}
