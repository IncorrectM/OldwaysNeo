package tech.zzhdev.oldwaysneo.data

object StaticString {
    const val ReceivingAddressLabel = "收货地址"
    const val PriceFilterLabel = "价格筛选"
    const val NewPostLabel = "我要发贴"
    const val ReturnLabel = "返回"
    const val LikeLabel = "赞同"
    const val MarkLabel = "收藏"
    const val CommentLabel = "评论"

    const val PersonalInformationLabel = "我的"
    const val EducationLabel = "教育"
    const val CommunicationLabel = "交流"
    const val ConnectionLabel = "社交"
    const val EMallLabel = "商城"
}

/**
 * This function's return value includes following conditions:
 *  1. <this>.length is lesser than (<end> - <start>), return <this>
 *  2. <this>.length is greater or equals (<end> - <start>), return this substring of <this>,
 *      containing character ranging from start to end - 1
 * */
fun String.substringRange(start: Int, end: Int): String = if (this.length < end - start) this else {
    this.substring(start, end) + "..."
}