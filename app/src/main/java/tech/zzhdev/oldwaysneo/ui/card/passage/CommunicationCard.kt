package tech.zzhdev.oldwaysneo.ui.card.passage

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import tech.zzhdev.oldwaysneo.data.passage.PassageInfo
import tech.zzhdev.oldwaysneo.ui.card.GenericUISetting
import tech.zzhdev.oldwaysneo.ui.image.InformationImage
import tech.zzhdev.oldwaysneo.ui.theme.FontSizeController
import tech.zzhdev.oldwaysneo.ui.theme.observeAsStateInitialed

@Composable
fun CommunicationCard(
    passageId: String,
    padding: Dp = 0.dp
) {
    val passage = PassageInfo.getById(passageId)
    val titleFontSize = FontSizeController.subtitleS.observeAsStateInitialed()
    val sloganFontSize = FontSizeController.mark.observeAsStateInitialed()
    val nicknameFontSize = FontSizeController.markL.observeAsStateInitialed()
    Card(
        modifier = Modifier
            .heightIn(
                min = GenericUISetting.CardDimension.HeightIn.min,
                max = GenericUISetting.CardDimension.HeightIn.max
            )
            .padding(padding)
            .clickable {
                Log.d("COM_CARD", "CommunicationCard: ${passage.passageId} clicked.")
            },
        elevation = GenericUISetting.Elevation.high
    ){
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(start = GenericUISetting.Padding.less),
                text = passage.title,
                fontSize = titleFontSize.value,
                textAlign = TextAlign.Start
            )
            Row {
                Row(modifier = Modifier.weight(0.2f)) {
                    InformationImage(
                        url = passage.author.imageURL,
                        circular = true
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(0.8f)
                        .padding(
                            start = GenericUISetting.Padding.less,
                            end = GenericUISetting.Padding.less
                        ),
                ){
                    Text(
                        text = passage.author.nickname,
                        fontSize = nicknameFontSize.value
                    )
                    Divider()
                    Text(
                        text = passage.author.slogan,
                        fontSize = sloganFontSize.value
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CommunicationCardPreview() {
    CommunicationCard(passageId = "PREVIEW")
}