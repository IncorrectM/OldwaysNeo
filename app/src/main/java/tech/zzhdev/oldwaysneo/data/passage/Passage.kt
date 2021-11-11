import tech.zzhdev.oldwaysneo.data.passage.MarkdownDocument
import tech.zzhdev.oldwaysneo.data.passage.PassageInfo

data class Passage(val passageInfo: PassageInfo, val content: MarkdownDocument) {
    companion object {
        fun getById(id: String): Passage{
            // TODO: 从服务器获取文章
            val info = PassageInfo.getById(id)
            return Passage(
                passageInfo = info,
                content = "# $id" +
                        "## author: ${info.author}"
            )
        }
    }
}