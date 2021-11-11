package tech.zzhdev.oldwaysneo.viewmodel.page

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import tech.zzhdev.oldwaysneo.data.post.Post
import tech.zzhdev.oldwaysneo.data.post.PostInfo

class ConnectionPageViewModel: ViewModel() {
    private val step = 10
    //TODO: 从服务器读取第一批posts的数据
    val initialContent = mutableListOf<Post>()
    val content = MutableLiveData<MutableList<Post>>()
    init {
        repeat(10) {
            initialContent.add(Post(
                PostInfo.getById("PPR202111112109PP-${it * 10}"),
                markdownDocument =
                "# Markdown Example" +
                        "## Banana!"
            ))
        }
    }
}