package tech.zzhdev.oldwaysneo.data

import tech.zzhdev.oldwaysneo.data.ScreenArgumentLabel.ID

object ScreenArgumentLabel {
    const val ID = "id"
}

sealed class Screen(val route: String) {
    object ArticleScreen: Screen(route = "/article/{$ID}") {
        fun passId(id: String): String = route.replace(ID, id)
    }
    object CommodityScreen: Screen(route = "/commodity/{$ID}"){
        fun passId(id: String): String = route.replace(ID, id)
    }
    object PostScreen: Screen(route = "/post/{$ID}"){
        fun passId(id: String): String = route.replace(ID, id)
    }

    object PersonalInfoScreen: Screen(route = "/personalInfo")
    object MainPageScreen: Screen(route = "/mainPage")
    object MainScreen: Screen(route = "/main")
}
