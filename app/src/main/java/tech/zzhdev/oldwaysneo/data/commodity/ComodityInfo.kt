package tech.zzhdev.oldwaysneo.data.commodity

import tech.zzhdev.oldwaysneo.data.ServerInfo
import tech.zzhdev.oldwaysneo.data.passage.OldWaysImageURL

data class CommodityInfo(val commodityId: String,val title: String, val description: String, val imageURL: OldWaysImageURL) {
    companion object {
        fun getById(id: String) : CommodityInfo{
            // TODO: 从服务器获取数据
            return CommodityInfo(
                commodityId = id,
                title = "Commodity:$id",
                description = "A commodity with Id: $id",
                imageURL = ServerInfo.exampleImage
            )
        }
    }
}
