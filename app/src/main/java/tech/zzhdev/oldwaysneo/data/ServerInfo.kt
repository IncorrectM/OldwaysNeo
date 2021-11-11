package tech.zzhdev.oldwaysneo.data

object ServerInfo {
    private const val serverUrl = "http://zzhdev.tech:8080/"
    val logoUrl: String
        get() = serverUrl + "assets/logo.png"
    const val exampleImage = "https://s3.bmp.ovh/imgs/2021/11/ae509be3d8632865.png"
}