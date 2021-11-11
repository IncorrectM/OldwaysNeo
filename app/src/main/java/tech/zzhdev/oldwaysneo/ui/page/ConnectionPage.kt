package tech.zzhdev.oldwaysneo.ui.page

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import tech.zzhdev.oldwaysneo.data.StaticString
import tech.zzhdev.oldwaysneo.ui.card.GenericUISetting
import tech.zzhdev.oldwaysneo.ui.card.half
import tech.zzhdev.oldwaysneo.ui.card.post.PostCard
import tech.zzhdev.oldwaysneo.viewmodel.page.ConnectionPageViewModel

@Composable
fun ConnectionPage(
    vm: ConnectionPageViewModel = viewModel()
) {
    val content = vm.content.observeAsState(initial = vm.initialContent)
    Scaffold(
        floatingActionButton = {
            Button(
                shape = CircleShape,
                onClick = {
                    //TODO: 发帖功能
                    Log.d("Connection", "ConnectionPage: posted a new post")
                }
            ) {
                Row() {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
                    Text(
                        text = StaticString.NewPostLabel,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    ) {
        LazyColumn() {
            Log.d("Connection", "ConnectionPage: loaded posts ${content.value.size}")
            items(content.value.size) {
                PostCard(
                    info = content.value[it].info,
                    padding = GenericUISetting.Padding.less.half()
                )
            }
        }
    }
}