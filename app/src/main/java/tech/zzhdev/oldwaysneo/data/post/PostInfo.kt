package tech.zzhdev.oldwaysneo.data.post

import tech.zzhdev.oldwaysneo.data.ServerInfo
import tech.zzhdev.oldwaysneo.data.User
import tech.zzhdev.oldwaysneo.data.passage.OldWaysImageURL

data class PostInfo(val postId: String, val poster: User, val contentPreview: String, val picturePreviewUrl: OldWaysImageURL) {
    companion object {
        fun getById(id: String) : PostInfo {
            //TODO: 从服务器获取数据
            return PostInfo(
                postId = "PR202111102016PP-0001",
                poster = User(
                    id = "UR202111102017ID-0001",
                    nickname = "Sheldon",
                    slogan = "Live long and prosper.",
                    imageURL = ServerInfo.exampleImage
                ),
                contentPreview = "I don't know what to post here as an example. So I wrote these!!!",
                picturePreviewUrl = ServerInfo.exampleImage
            )
        }
    }
}