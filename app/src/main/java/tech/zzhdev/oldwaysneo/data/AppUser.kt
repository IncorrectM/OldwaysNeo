package tech.zzhdev.oldwaysneo

import androidx.compose.runtime.remember
import androidx.lifecycle.MutableLiveData
import tech.zzhdev.oldwaysneo.data.User

object AppUser {
    val user = MutableLiveData(User.getById("123"))
    // TODO: 应用启动时，从本地读取用户ID，或者弹出登录界面要求登录
    private var userId = ""
    fun init(
        id: String
    ) {
        this.userId = id
    }
}