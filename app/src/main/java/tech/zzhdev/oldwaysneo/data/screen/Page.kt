package tech.zzhdev.oldwaysneo.data.screen

sealed class Page(route: String): Screen(route = route) {
    object EduPage: Page(route = "/eduPage")
    object CommunicationPage: Page(route = "/commPage")
    object EMallPage: Page(route = "/mallPage")
    object ConnectionPage: Page(route = "/connPage")
}
