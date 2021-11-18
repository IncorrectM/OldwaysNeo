package tech.zzhdev.oldwaysneo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import tech.zzhdev.oldwaysneo.data.screen.BottomNavScreen
import tech.zzhdev.oldwaysneo.data.screen.Page
import tech.zzhdev.oldwaysneo.ui.page.CommunicationPage
import tech.zzhdev.oldwaysneo.ui.page.ConnectionPage
import tech.zzhdev.oldwaysneo.ui.page.EMallPage
import tech.zzhdev.oldwaysneo.ui.page.EduPage
import tech.zzhdev.oldwaysneo.ui.screen.PersonalInfoScreen

@Composable
fun MainPageNav(
        mainPageNavController: NavHostController
) {
    NavHost(
            navController = mainPageNavController,
            startDestination = BottomNavScreen.EducationNavScreen.screen.route
    ) {
        composable(
                route = BottomNavScreen.EducationNavScreen.screen.route
        ) {

        }

        composable(
                route = BottomNavScreen.PersonalInfoNavScreen.screen.route
        ) {
            PersonalInfoScreen()
        }


        composable(route = Page.EduPage.route) {
            EduPage()
        }

        composable(route = Page.CommunicationPage.route) {
            CommunicationPage()
        }

        composable(route = Page.EMallPage.route) {
            EMallPage()
        }

        composable(route = Page.ConnectionPage.route) {
            ConnectionPage()
        }
    }
}