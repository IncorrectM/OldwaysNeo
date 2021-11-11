package tech.zzhdev.oldwaysneo.data

sealed class Page(val route: String) {
    object EduPage: Page(route = "/eduPage")
    object Communication: Page(route = "/commPage")
    object EMallPage: Page(route = "/mallPage")
    object ConnectionPage: Page(route = "/connPage")
}
