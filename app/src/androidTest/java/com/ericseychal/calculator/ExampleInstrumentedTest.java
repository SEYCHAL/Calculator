package com.ericseychal.calculator;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void shouldDoAdditionWhenUseEqual() {
        onView(withId(R.id.button_5)).perform(click());
        onView(withId(R.id.addition_button)).perform(click());
        onView(withId(R.id.button_4)).perform(click());
        onView(withId(R.id.equal_button)).perform(click());

        onView(withId(R.id.result_textview)).check(matches(withText("9")));

    }

    @Test
    public void shouldDoSubstractionWhenUseEqual() {
        onView(withId(R.id.button_1)).perform(click());
        onView(withId(R.id.button_5)).perform(click());
        onView(withId(R.id.substraction_button)).perform(click());
        onView(withId(R.id.button_5)).perform(click());
        onView(withId(R.id.equal_button)).perform(click());

        onView(withId(R.id.result_textview)).check(matches(withText("10")));

    }
}
