package tech.zzhdev.oldwaysneo.data.passage

import tech.zzhdev.oldwaysneo.data.ServerInfo
import tech.zzhdev.oldwaysneo.data.User

typealias OldWaysImageURL = String
typealias MarkdownDocument = String

data class PassageInfo(val passageId: String, val title: String, val author: User) {
    companion object {
        fun getById(id: String): PassageInfo {
            //TODO：从服务器获取文章
            return PassageInfo(
                passageId = id,
                title = "Composable YES:$id",
                author = User(
                    id = "UR202111092310ID-0001",
                    nickname = "BobLovesAlice",
                    slogan = "Just Do It!",
                    ServerInfo.exampleImage
                )
            )
        }
    }
}