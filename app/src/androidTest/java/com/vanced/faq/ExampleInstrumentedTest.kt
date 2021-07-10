package com.vanced.faq

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.vanced.faq.ui.layout.main.MainLayout
import com.vanced.faq.ui.theme.VancedGuideTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun launchAboutScreen() {
        composeTestRule.setContent {
            VancedGuideTheme {
                MainLayout()
            }
        }
        composeTestRule.onNodeWithContentDescription("More").performClick()
        composeTestRule.onNodeWithText("About").performClick()
    }

}