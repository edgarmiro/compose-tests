package mo.example.compose.tests

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "menu",
    ) {
        composable("menu") {
            MenuScreen(
                onProgressClick = { navController.navigate("progress") }
            )
        }

        composable("progress") {
            ProgressScreen(
                onTimerFinish = { navController.navigate("finish") }
            )
        }

        composable("finish") {
            FinishScreen()
        }
    }
}
