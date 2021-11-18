package tech.zzhdev.oldwaysneo.data

import androidx.lifecycle.MutableLiveData

object AppUser {
    val user = MutableLiveData(User.getById("123"))
    // TODO: 应用启动时，从本地读取用户ID，或者弹出登录界面要求登录
    private var userId = ""
    fun init(
        id: String
    ) {
        userId = id
    }
}