package mo.example.compose.tests

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MenuScreenTests {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun full_user_journey() {
        composeTestRule.onNodeWithText("Go to progress screen").performClick()

        composeTestRule.onNodeWithContentDescription("Circular progress").assertIsDisplayed()
        composeTestRule.onNodeWithText("GO!").assertIsDisplayed()

        composeTestRule.onNodeWithText("Finish").assertIsDisplayed()
    }
}
