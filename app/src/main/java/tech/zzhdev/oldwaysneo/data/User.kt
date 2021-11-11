package tech.zzhdev.oldwaysneo.data

import tech.zzhdev.oldwaysneo.data.passage.OldWaysImageURL

data class User(val id: String,val nickname: String, val slogan: String, val imageURL: OldWaysImageURL) {
    companion object {
        fun getById(id: String) = User(
            //TODO： 从服务器获取数据
            id = id,
            nickname = id.substring(0, id.length / 2),
            slogan = "Make it happen.",
            imageURL = ServerInfo.exampleImage
        )
    }
}
