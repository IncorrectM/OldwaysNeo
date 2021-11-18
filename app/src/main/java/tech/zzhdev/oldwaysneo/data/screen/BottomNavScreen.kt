package tech.zzhdev.oldwaysneo.data.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import tech.zzhdev.oldwaysneo.data.StaticString

sealed class BottomNavScreen(
        val screen: Screen,
        val title: String,
        val icon: ImageVector
) {
    companion object {
        val allScreens = listOf(
                EducationNavScreen,
                CommunicationNavScreen,
                EMallNavScreen,
                ConnectionNavScreen,
                PersonalInfoNavScreen
        )

        val startScreen = EducationNavScreen
    }

    object PersonalInfoNavScreen: BottomNavScreen(
            screen = Screen.PersonalInfoScreen,
            title = StaticString.PersonalInformationLabel,
            icon = Icons.Default.Person
    )

    object EducationNavScreen: BottomNavScreen(
            screen = Page.EduPage,
            title = StaticString.EducationLabel,
            icon = Icons.Default.Star
    )

    object CommunicationNavScreen: BottomNavScreen(
            screen =Page.CommunicationPage,
            title = StaticString.CommunicationLabel,
            icon = Icons.Default.Notifications
    )

    object EMallNavScreen: BottomNavScreen(
            screen = Page.EMallPage,
            title = StaticString.EMallLabel,
            icon = Icons.Default.ShoppingCart
    )

    object ConnectionNavScreen: BottomNavScreen(
            screen = Page.ConnectionPage,
            title = StaticString.ConnectionLabel,
            icon = Icons.Default.Email
    )

}
