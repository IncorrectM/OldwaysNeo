package tech.zzhdev.oldwaysneo.ui.card.information

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import tech.zzhdev.oldwaysneo.data.passage.PassageAuthorInformation
import tech.zzhdev.oldwaysneo.ui.card.GenericUISetting
import tech.zzhdev.oldwaysneo.ui.image.InformationImage
import tech.zzhdev.oldwaysneo.ui.theme.FontSizeController

@Composable
fun PassageAuthorInfoCard(
    passageId: String,
    userId: String
) {
    val passageInfo = remember {
        PassageAuthorInformation.getById(passageId)
    }
    val context = LocalContext.current
    val nicknameSize = FontSizeController.markL.observeAsState()
    val subscribeSize = FontSizeController.subtitleS.observeAsState()
    val dateSize = FontSizeController.markS.observeAsState()
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(GenericUISetting.ImageDimension.height),
        elevation = GenericUISetting.Elevation.high,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            InformationImage(
                url = passageInfo.pictureUrl
            )
            Column(
                modifier = Modifier.padding(start = GenericUISetting.Padding.medium)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = passageInfo.nickname,
                        textAlign = TextAlign.Center,
                        fontSize = nicknameSize.value ?: MaterialTheme.typography.subtitle1.fontSize
                    )
                    Button(
                        onClick = {
                            Toast.makeText(
                                context,
                                "$userId \n已关注\n ${passageInfo.authorId}",
                                Toast.LENGTH_SHORT
                            ).show()
                            /*TODO:关注该作者*/
                        },
                    ) {
                        // TODO: 已关注和未关注显示不同的样子
                        Text(
                            text = "关注",
                            fontSize = subscribeSize.value ?: MaterialTheme.typography.subtitle1.fontSize
                        )
                    }
                }
                Divider(modifier = Modifier.padding(top = GenericUISetting.Padding.less))
                Text(
                    text = passageInfo.publishTime,
                    fontSize = dateSize.value ?: MaterialTheme.typography.subtitle1.fontSize
                )
            }
        }
    }
}

@Preview
@Composable
fun AuthorInfoCardPreview() {
    PassageAuthorInfoCard(
        passageId = "123",
        userId = "123"
    )
}