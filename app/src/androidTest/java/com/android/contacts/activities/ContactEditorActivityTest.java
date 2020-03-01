package com.android.contacts.activities;

import android.content.Intent;
import android.widget.EditText;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.core.content.ContextCompat.startActivity;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.android.contacts.R;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ContactEditorActivityTest {
    @Rule
    public ActivityTestRule<PeopleActivity> intentsTestRule =
            new ActivityTestRule<>(PeopleActivity.class);
    @Before
    public void setup(){
        onView(withId(R.id.floating_action_button))
                .perform(click());

    }

    @Test
    public void test_edit_first_name(){
        onView(allOf(withHint("First name"),is(instanceOf(EditText.class)))).perform(typeText("liu"),closeSoftKeyboard());

    }


}