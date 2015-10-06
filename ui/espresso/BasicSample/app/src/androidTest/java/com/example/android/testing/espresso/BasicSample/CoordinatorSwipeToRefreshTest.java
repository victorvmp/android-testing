/*
 * Copyright 2015, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.testing.espresso.BasicSample;

import android.app.Activity;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Basic tests showcasing simple view matchers and actions like {@link ViewMatchers#withId},
 * {@link ViewActions#click} and {@link ViewActions#typeText}.
 * <p>
 * Note that there is no need to tell Espresso that a view is in a different {@link Activity}.
 */
@RunWith(AndroidJUnit4.class) @SmallTest public class CoordinatorSwipeToRefreshTest {

  /**
   * A JUnit {@link Rule @Rule} to launch your activity under test. This is a replacement
   * for {@link ActivityInstrumentationTestCase2}.
   * <p>
   * Rules are interceptors which are executed for each test method and will run before
   * any of your setup code in the {@link Before @Before} method.
   * <p>
   * {@link ActivityTestRule} will create and launch of the activity for you and also expose
   * the activity under test. To get a reference to the activity you can use
   * the {@link ActivityTestRule#getActivity()} method.
   */
  @Rule public ActivityTestRule<CoordinatorSwipeToRefreshActivity> mActivityRule =
      new ActivityTestRule<>(CoordinatorSwipeToRefreshActivity.class);

  @Test public void coordinatorSwipeToRefreshLoadData() throws Exception {
    onView(withId(R.id.refresh_layout)).perform(swipeDown());
    onView(withText("Item 1")).check(matches(isDisplayed()));
  }

  @Test public void coordinatorRecyclerSwipeToRefreshLoadData() throws Exception {
    onView(withId(R.id.recycler)).perform(swipeDown());
    onView(withText("Item 1")).check(matches(isDisplayed()));
  }
}