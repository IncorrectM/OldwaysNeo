package tech.zzhdev.oldwaysneo.ui.card.information

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import tech.zzhdev.oldwaysneo.data.StaticString
import tech.zzhdev.oldwaysneo.ui.card.GenericUISetting
import tech.zzhdev.oldwaysneo.ui.image.InformationImage
import tech.zzhdev.oldwaysneo.ui.theme.FontSizeController
import tech.zzhdev.oldwaysneo.ui.theme.observeAsStateInitialed
import tech.zzhdev.oldwaysneo.viewmodel.UserInformationViewModel

@Composable
fun PersonalInfoCard(
    userId: String,
    padding: Dp = 0.dp,
    userViewModel: UserInformationViewModel = viewModel()
) {
    val nicknameFontSize = FontSizeController.subtitleL.observeAsStateInitialed()
    val sloganFontSize = FontSizeController.markL.observeAsStateInitialed()
    val receiveFontSize = FontSizeController.articleTitleS.observeAsStateInitialed()
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(padding),
        elevation = GenericUISetting.Elevation.high
    ) {
        Column {
            Row() {
                Row(
                    modifier = Modifier
                        .weight(0.2f)
                ) {
                    InformationImage(
                        url = userViewModel.user.imageURL,
                        circular = true
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(0.8f)
                        .padding(start = GenericUISetting.Padding.medium),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = userViewModel.user.nickname,
                        fontSize = nicknameFontSize.value
                    )
                    Text(
                        text = userViewModel.user.slogan,
                        fontSize = sloganFontSize.value
                    )
                }
            }
            Divider(
                modifier = Modifier.padding(start = GenericUISetting.Padding.medium)
            )
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.background),
                elevation = GenericUISetting.Elevation.low
            ) {
                Text(
                    text = StaticString.ReceivingAddressLabel,
                    textAlign = TextAlign.Center,
                    fontSize = receiveFontSize.value
                )
            }
        }
    }
} 