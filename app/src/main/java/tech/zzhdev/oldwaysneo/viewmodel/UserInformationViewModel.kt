package tech.zzhdev.oldwaysneo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import tech.zzhdev.oldwaysneo.data.ServerInfo
import tech.zzhdev.oldwaysneo.data.User

class UserInformationViewModel: ViewModel() {
    // TODO: 判断用户是否已登陆，若已登录，从服务器获取相关信息
    val user = User(
        id = "UR202111092258I-0001",
        nickname = "AliceLovesBob",
        slogan = "Never give up.",
        imageURL = ServerInfo.exampleImage
    )
}