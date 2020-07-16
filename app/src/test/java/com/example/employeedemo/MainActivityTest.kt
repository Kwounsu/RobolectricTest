package com.example.employeedemo

import android.content.Intent
import android.os.Build
import androidx.test.core.app.ActivityScenario
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import org.robolectric.annotation.Config

@Config(sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(RobolectricTestRunner::class)
class MainActivityTest {
    lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setup() {
        println("@Before setup")
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @After
    fun cleanup() {
        println("@After cleanup")
        scenario.close()
    }

    @Test
    fun validateButton() {
        println("@Test validateButton")
        scenario.onActivity { activity ->
            activity.button.performClick()
            val expectedIntent = Intent(activity, SecondActivity::class.java)
            val shadowActivity = Shadows.shadowOf(activity)
            val actualIntent = shadowActivity.nextStartedActivity
            assertTrue(actualIntent.filterEquals(expectedIntent))
        }
    }

    @Test
    fun validateTextViewId() {
        println("@Test validateTextViewId")
        scenario.onActivity { activity ->
            val tv = activity.textView_id
            assertNotNull("TextView could not be found", tv)
            assertTrue("TextView contains incorrect text", "13" == tv.text.toString())
        }
    }
    @Test
    fun validateTextViewName() {
        println("@Test validateTextViewName")
        scenario.onActivity { activity ->
            val tv = activity.textView_name
            assertNotNull("TextView could not be found", tv)
            assertTrue("TextView contains incorrect text", "Bob" == tv.text.toString())
        }
    }
    @Test
    fun validateTextViewAge() {
        println("@Test validateTextViewAge")
        scenario.onActivity { activity ->
            val tv = activity.textView_age
            assertNotNull("TextView could not be found", tv)
            assertTrue("TextView contains incorrect text", "99" == tv.text.toString())
        }
    }
    @Test
    fun validateTextViewAddress() {
        println("@Test validateTextViewAddress")
        scenario.onActivity { activity ->
            val tv = activity.textView_address
            assertNotNull("TextView could not be found", tv)
            assertTrue("TextView contains incorrect text", "Mars" == tv.text.toString())
        }
    }
    @Test
    fun validateTextViewCountry() {
        println("@Test validateTextViewCountry")
        scenario.onActivity { activity ->
            val tv = activity.textView_country
            assertNotNull("TextView could not be found", tv)
            assertTrue("TextView contains incorrect text", "Korea" == tv.text.toString())
        }
    }
    @Test
    fun validateTextViewDob() {
        println("@Test validateTextViewDob")
        scenario.onActivity { activity ->
            val tv = activity.textView_dob
            assertNotNull("TextView could not be found", tv)
            assertTrue("TextView contains incorrect text", "2020.12.25" == tv.text.toString())
        }
    }
    @Test
    fun validateTextViewLanguage() {
        println("@Test validateTextViewLanguage")
        scenario.onActivity { activity ->
            val tv = activity.textView_language
            assertNotNull("TextView could not be found", tv)
            assertTrue("TextView contains incorrect text", "English" == tv.text.toString())
        }
    }
    @Test
    fun validateImage() {
        println("@Test validateImage")
        scenario.onActivity { activity ->
            val imageView = activity.imageView_profilePicture
            val drawableResId: Int = Shadows.shadowOf(imageView.drawable).createdFromResId
            assertNotNull("TextView could not be found", imageView)
            assertEquals(R.drawable.ic_launcher_foreground, drawableResId)
        }
    }

    @Test
    fun changeAge() {
        scenario.onActivity{ activity ->
            val textViewAge = activity.textView_age
            val buttonChangeAge = activity.button_changeAge
            if (textViewAge.text.toString() == "99") {
                buttonChangeAge.performClick()
                assertTrue("TextView contains incorrect text", "12" == textViewAge.text.toString())
            }
            if (textViewAge.text.toString() != "99") {
                buttonChangeAge.performClick()
                assertTrue("TextView contains incorrect text", "99" == textViewAge.text.toString())
            }
        }
    }
}