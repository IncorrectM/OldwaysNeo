package tech.zzhdev.oldwaysneo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import tech.zzhdev.oldwaysneo.data.AppUser
import tech.zzhdev.oldwaysneo.data.screen.Screen
import tech.zzhdev.oldwaysneo.data.screen.ScreenArgumentLabel
import tech.zzhdev.oldwaysneo.ui.screen.ArticleScreen
import tech.zzhdev.oldwaysneo.ui.screen.CommodityScreen
import tech.zzhdev.oldwaysneo.ui.screen.MainScreen
import tech.zzhdev.oldwaysneo.ui.screen.PostScreen

@Composable
fun RootScreenNavGraph(
    rootScreenNavController: NavHostController,
    mainPageNavController: NavHostController
) {
    NavHost(
        navController = rootScreenNavController,
        startDestination = Screen.MainScreen.route
    ) {
        composable(
            route = Screen.MainScreen.route
        ) {
            MainScreen(
                    mainPageNavController = mainPageNavController
            )
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

        composable(
            route = Screen.ArticleScreen.route,
            arguments = listOf(
                navArgument(
                    name = ScreenArgumentLabel.ID
                ) {
                    type = NavType.StringType
                }
            )
        ) {
            ArticleScreen(
                passageId = it.arguments?.getString(ScreenArgumentLabel.ID)!!,
                userId = AppUser.user.value!!.id
            )
        }

        composable(
            route = Screen.ArticleScreen.route,
            arguments = listOf(
                navArgument(
                    name = ScreenArgumentLabel.ID
                ) {
                    type = NavType.StringType
                }
            )
        ) {
            PostScreen()
        }
    }
}