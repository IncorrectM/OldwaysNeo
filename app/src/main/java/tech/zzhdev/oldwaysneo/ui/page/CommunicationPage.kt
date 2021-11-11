package tech.zzhdev.oldwaysneo.ui.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import tech.zzhdev.oldwaysneo.ui.card.GenericUISetting
import tech.zzhdev.oldwaysneo.ui.card.half
import tech.zzhdev.oldwaysneo.ui.card.passage.CommunicationCard
import tech.zzhdev.oldwaysneo.ui.card.passage.EduCard

@Composable
fun CommunicationPage() {
    val step = 10
    val currentContentCount: Int by remember() {
        mutableStateOf(step)
    }
    //TODO： 改为从服务器获取指定数量的信息
    Scaffold(){
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(currentContentCount) {
                CommunicationCard(
                    passageId = "CR202111111838CC-$it",
                    padding = GenericUISetting.Padding.less.half()
                )
            }
        }
    }
}