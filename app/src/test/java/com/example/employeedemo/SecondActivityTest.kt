package com.example.employeedemo

import android.os.Build
import androidx.test.core.app.ActivityScenario
import kotlinx.android.synthetic.main.activity_second.*
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(RobolectricTestRunner::class)
class SecondActivityTest {
    lateinit var scenario: ActivityScenario<SecondActivity>

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(SecondActivity::class.java)
    }

    @After
    fun cleanup() {
        scenario.close()
    }

    @Test
    fun onCreate() {
        scenario.onActivity { activity ->
            assertTrue("TextView contains incorrect text", activity.textView_secondActivity.text == "Hello")
        }
    }
}