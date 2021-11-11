package tech.zzhdev.oldwaysneo.ui.card.commodity

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import tech.zzhdev.oldwaysneo.data.commodity.CommodityInfo
import tech.zzhdev.oldwaysneo.data.substringRange
import tech.zzhdev.oldwaysneo.ui.card.GenericUISetting
import tech.zzhdev.oldwaysneo.ui.theme.FontSizeController
import tech.zzhdev.oldwaysneo.ui.theme.observeAsStateInitialed

@Composable
fun CommodityCard(
    info: CommodityInfo,
    padding: Dp = 0.dp,
) {
    val titleFontSize = FontSizeController.subtitleS.observeAsStateInitialed()
    val descriptionFontSize = FontSizeController.markL.observeAsStateInitialed()
    Card(
        modifier = Modifier
            .heightIn(
                min = GenericUISetting.CardDimension.HeightIn.min,
                max = GenericUISetting.CardDimension.HeightIn.max
            )
            .padding(padding)
            .clickable {
                Log.d("POST_CARD", "PostCard: ${info.commodityId} clicked.")
            },
        elevation = GenericUISetting.Elevation.high
    ) {
        Row() {
            Row() {
                CommodityInformationImage(
                    url = info.imageURL
                )
            }
            Column(
                modifier = Modifier.padding(start = GenericUISetting.Padding.less)
            ) {
                Text(
                    text = info.title.substringRange(0, 50),
                    fontSize = titleFontSize.value
                )
                Divider()
                Text(
                    text = info.description.substringRange(0, 50),
                    fontSize = descriptionFontSize.value
                )
            }
        }
    }
}