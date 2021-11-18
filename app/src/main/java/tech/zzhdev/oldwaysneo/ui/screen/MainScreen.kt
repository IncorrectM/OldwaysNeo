package tech.zzhdev.oldwaysneo.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import tech.zzhdev.oldwaysneo.data.screen.BottomNavScreen
import tech.zzhdev.oldwaysneo.ui.navigation.MainPageNav
import tech.zzhdev.oldwaysneo.ui.theme.FontSizeController
import tech.zzhdev.oldwaysneo.ui.theme.observeAsStateInitialed

@Composable
fun MainScreen(
        mainPageNavController: NavHostController
) {
    Scaffold(
            bottomBar = {
                MainBottomNavBar(
                        mainPageNavController = mainPageNavController
                )
            }
    ){
        MainPageNav(
                mainPageNavController = mainPageNavController
        )
    }
}

@Composable
fun MainBottomNavBar(
        mainPageNavController: NavHostController
) {
    val screens = BottomNavScreen.allScreens
    val navBackStackEntry by mainPageNavController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation {
        screens.forEach { screen ->
            BottomNavBarItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    mainPageNavController = mainPageNavController
            )
        }
    }
}

@Composable
fun RowScope.BottomNavBarItem(
        screen: BottomNavScreen,
        currentDestination: NavDestination?,
        mainPageNavController: NavHostController
) {
    BottomNavigationItem(
            label = {
                    Text(
                            text = screen.title,
                            fontSize = FontSizeController.mark.observeAsStateInitialed().value
                    )
            },
            icon = {
                   Icon(
                           imageVector = screen.icon,
                           contentDescription = "导航栏项目"
                   )
            },
            selected = currentDestination?.hierarchy?.any() {
                                                            it.route == screen.screen.route
            } == true,
            onClick = {
                mainPageNavController.navigate(screen.screen.route) {
                        popUpTo(mainPageNavController.graph.startDestinationId)
                        launchSingleTop = true
                }
//                if (
//                        screen.screen.route == BottomNavScreen.PersonalInfoNavScreen.screen.route ||
//                        screen.screen.route == BottomNavScreen.EducationNavScreen.screen.route
//                ) {
//                    mainPageNavController.navigate(screen.screen.route) {
//                        popUpTo(mainPageNavController.graph.startDestinationId)
//                        launchSingleTop = true
//                    }
//                } else {
//                    Log.d("MainScreenNav", "BottomNavBarItem: to ${screen.screen.route}")
//                    mainPageNavController.navigate(BottomNavScreen.startScreen.screen.route) {
//                        popUpTo(mainPageNavController.graph.startDestinationId)
//                        launchSingleTop = true
//                    }
//                    mainContentNavController.navigate(screen.screen.route) {
//                        popUpTo(mainPageNavController.graph.startDestinationId)
//                        launchSingleTop = true
//                    }
//                }
            }
    )
}