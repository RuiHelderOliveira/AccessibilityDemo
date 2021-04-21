package com.example.accessibilitydemo

import android.graphics.Color
import android.util.Log
import androidx.core.graphics.ColorUtils
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.accessibility.AccessibilityChecks
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import com.example.accessibilitydemo.activities.MainActivity
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class AccessibilityTest {

    @Before
    fun setUp() {
        AccessibilityChecks.enable()
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.accessibilitydemo", appContext.packageName)
    }

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testTransferClick() {
        onView(withId(R.id.transfer_button))
            .check(matches(isDisplayed()))
            .perform(click())
    }

    @Test
    fun testShareClick() {
        onView(withId(R.id.share_button))
            .check(matches(isDisplayed()))
            .perform(click())
    }

    @Test
    fun testContrast() {
        val foregroundColor = Color.WHITE
        val backgroundColor = Color.BLUE

        val contrast = ColorUtils.calculateContrast(foregroundColor, backgroundColor)

        Log.d("Test", contrast.toString())

        assertTrue(contrast > 3);
    }
}