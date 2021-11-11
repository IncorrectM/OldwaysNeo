package tech.zzhdev.oldwaysneo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import tech.zzhdev.oldwaysneo.data.Screen
import tech.zzhdev.oldwaysneo.data.ScreenArgumentLabel
import tech.zzhdev.oldwaysneo.ui.screen.CommodityScreen
import tech.zzhdev.oldwaysneo.ui.screen.MainScreen

@Composable
fun RootScreenNavGraph(
    rootScreenNavController: NavHostController
) {
    NavHost(
        navController = rootScreenNavController,
        startDestination = Screen.MainScreen.route
    ) {
        composable(
            route = Screen.MainScreen.route
        ) {
            MainScreen()
        }
        composable(
            route = Screen.CommodityScreen.route,
            arguments = listOf(
                navArgument(
                    name = ScreenArgumentLabel.ID
                ) {
                }
            )
        ) {
            CommodityScreen()
        }
    }
}