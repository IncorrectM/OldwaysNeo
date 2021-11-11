package tech.zzhdev.oldwaysneo.data.passage

import tech.zzhdev.oldwaysneo.data.ServerInfo
import java.util.*

//TODO: 可能的话，把<publishTime>的类型改为日期
data class PassageAuthorInformation( val authorId: String, val nickname: String, val publishTime: String, val pictureUrl: String) {
    companion object {
        fun getById(id: String): PassageAuthorInformation {
            // TODO: 使用文章ID通过服务器获取作者信息
            return PassageAuthorInformation(
                authorId = "UR202111091912R0001",
                nickname = "Bob$id",
                publishTime = Date().toString(),
                pictureUrl = ServerInfo.exampleImage
            )
        }
    }
}
