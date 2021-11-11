package tech.zzhdev.oldwaysneo.data.post

import tech.zzhdev.oldwaysneo.data.passage.MarkdownDocument

data class Post(val info: PostInfo, val markdownDocument: MarkdownDocument) {
}