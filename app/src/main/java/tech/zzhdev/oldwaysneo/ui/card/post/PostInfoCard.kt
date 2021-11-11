package tech.zzhdev.oldwaysneo.ui.card.post

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import tech.zzhdev.oldwaysneo.data.post.PostInfo
import tech.zzhdev.oldwaysneo.data.substringRange
import tech.zzhdev.oldwaysneo.ui.card.GenericUISetting
import tech.zzhdev.oldwaysneo.ui.image.InformationImage
import tech.zzhdev.oldwaysneo.ui.theme.FontSizeController
import tech.zzhdev.oldwaysneo.ui.theme.observeAsStateInitialed

@Composable
fun PostCard(
    info: PostInfo,
    padding: Dp = 0.dp
) {
    val titleFontSize = FontSizeController.subtitleS.observeAsStateInitialed()
    val contentPreviewFontSize = FontSizeController.markL.observeAsStateInitialed()
    Card(
        modifier = Modifier
            .heightIn(
                min = GenericUISetting.CardDimension.HeightIn.min,
                max = GenericUISetting.CardDimension.HeightIn.max
            )
            .padding(padding)
            .clickable {
                Log.d("POST_CARD", "PostCard: ${info.postId} clicked.")
            },
        elevation = GenericUISetting.Elevation.high
    ) {
        Column() {
            Row() {
                Row(
                    modifier = Modifier.weight(0.2f)
                ) {
                    InformationImage(
                        url = info.poster.imageURL,
                        circular = true
                    )
                }
                Text(
                    modifier = Modifier.weight(0.8f),
                    text = info.poster.nickname,
                    fontSize = titleFontSize.value,
                    textAlign = TextAlign.Start
                )
            }
            Text(
                text = info.contentPreview.substringRange(0, 50),
                fontSize = contentPreviewFontSize.value
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                PostImagePreview(
                    url = info.picturePreviewUrl
                )
            }
        }
    }
}