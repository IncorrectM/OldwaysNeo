package tech.zzhdev.oldwaysneo.ui.screen

import Passage
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import tech.zzhdev.oldwaysneo.data.StaticString
import tech.zzhdev.oldwaysneo.data.User
import tech.zzhdev.oldwaysneo.ui.card.GenericUISetting
import tech.zzhdev.oldwaysneo.ui.card.half
import tech.zzhdev.oldwaysneo.ui.card.information.PassageAuthorInfoCard
import tech.zzhdev.oldwaysneo.ui.theme.FontSizeController
import tech.zzhdev.oldwaysneo.ui.theme.observeAsStateInitialed

@Composable
fun ArticleScreen(
    passageId: String,
    userId: String
) {
    val passage = Passage.getById(passageId)
    val user = User.getById(userId)
    Scaffold(
        topBar = {
            ArticleTopBar(
                passage = passage,
                user = user
            )
        },
        bottomBar = {
            ArticleBottomBar()
        }
    ) {
        //TODO: 改为Markdown支持
        Text(text = passage.content)
    }
}

@Composable
fun ArticleTopBar(
    passage: Passage,
    user: User
) {
    Card(
        elevation = GenericUISetting.Elevation.low
    ){
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                modifier = Modifier
                    .padding(GenericUISetting.Padding.less.half())
                    .border(1.dp, MaterialTheme.colors.primaryVariant)
                    .clickable {
                        //TODO: 返回
                    }
                    .padding(GenericUISetting.Padding.less.half()),
                text = StaticString.ReturnLabel,
                fontSize = FontSizeController.subtitleS.observeAsStateInitialed().value
            )
            Card(
                elevation = GenericUISetting.Elevation.lower
            ) {
                PassageAuthorInfoCard(
                    passageId = passage.passageInfo.passageId,
                    userId = user.id
                )
            }
        }
    }
}

@Composable
fun ArticleBottomBar() {
    val fontSize = FontSizeController.markL.observeAsStateInitialed()
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        //TODO： 随着是否点过改变样式
        Button(
            modifier = Modifier
                .weight(0.5f)
                .border(5.dp, MaterialTheme.colors.primaryVariant),
            onClick = { /*TODO*/ }
        ){
            Text(
                text = StaticString.LikeLabel,
                fontSize = fontSize.value,
                textAlign = TextAlign.Center
            )
        }
        Button(
            modifier = Modifier
                .weight(0.25f)
                .border(5.dp, MaterialTheme.colors.primaryVariant),
            onClick = { /*TODO*/ }
        ){
            Text(
                text = StaticString.MarkLabel,
                fontSize = fontSize.value,
                textAlign = TextAlign.Center
            )
        }
        Button(
            modifier = Modifier
                .weight(0.25f)
                .border(5.dp, MaterialTheme.colors.primaryVariant),
            onClick = { /*TODO*/ }
        ){
            Text(
                text = StaticString.CommentLabel,
                fontSize = fontSize.value,
                textAlign = TextAlign.Center
            )
        }
    }
}