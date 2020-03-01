package com.android.contacts.activities;

import android.content.Intent;
import android.provider.ContactsContract;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.filters.LargeTest;
import androidx.test.runner.AndroidJUnit4;

import com.android.contacts.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class PeopleActivityTest {
    @Rule
    public IntentsTestRule<PeopleActivity> intentsTestRule =
            new IntentsTestRule<>(PeopleActivity.class);

//    @Rule
//    public ActivityTestRule<PeopleActivity> activityRule =
//            new ActivityTestRule<>(PeopleActivity.class);


    @Test
    public void ClickToCreateContact() {
        onView(withId(R.id.floating_action_button))
                .perform(click());
        //检测发送了intent
        intended(allOf(hasAction(Intent.ACTION_INSERT),hasData(ContactsContract.Contacts.CONTENT_URI)));

    }
}