package tech.zzhdev.oldwaysneo.ui.page

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import tech.zzhdev.oldwaysneo.data.StaticString
import tech.zzhdev.oldwaysneo.data.commodity.CommodityInfo
import tech.zzhdev.oldwaysneo.ui.card.GenericUISetting
import tech.zzhdev.oldwaysneo.ui.card.commodity.CommodityCard
import tech.zzhdev.oldwaysneo.ui.card.half
import tech.zzhdev.oldwaysneo.viewmodel.page.EMallFilterViewModel

@Composable
fun EMallPage() {
    val step = 10
    val currentContentCount: Int by remember() {
        mutableStateOf(step)
    }
    //TODO： 改为从服务器获取指定数量的信息
    Scaffold(
        topBar = {
            EMallFilterBar()
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(currentContentCount) {
                CommodityCard(
                    info = CommodityInfo.getById("CCR202111111839COM-$it"),
                    padding = GenericUISetting.Padding.less.half()
                )
            }
        }
    }
}

@Composable
fun EMallFilterBar(
    vm: EMallFilterViewModel = viewModel()
) {
    val start = vm.start.observeAsState(initial = 0)
    val bound = vm.bound.observeAsState(initial = 0)
    Card(
        modifier = Modifier
            .padding(GenericUISetting.Padding.less)
            .fillMaxWidth(),
        elevation = GenericUISetting.Elevation.higher,
        backgroundColor = MaterialTheme.colors.background
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier
                    .border(1.dp, color = MaterialTheme.colors.primaryVariant)
            ){
                Text(
                    modifier = Modifier
                        .padding(GenericUISetting.Padding.less),
                    text = StaticString.PriceFilterLabel,
                )
                OutlinedTextField(
                    modifier = Modifier
                        .padding(end = GenericUISetting.Padding.medium)
                        .widthIn(min = 50.dp, max = 50.dp),
                    value = start.value.toString(),
                    onValueChange = {
                        //TODO: 标题匹配关键词筛选
                        Log.d("E-MALL", "EMallFilterBar: Keys set '$it'")
                        vm.start.value = it.toIntOrNull() ?: 0
                    },
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                OutlinedTextField(
                    modifier = Modifier
                        .widthIn(min = 50.dp, max = 50.dp),
                    value = bound.value.toString(),
                    onValueChange = {
                        //TODO: 标题匹配关键词筛选
                        Log.d("E-MALL", "EMallFilterBar: Keys set '$it'")
                        vm.bound.value = it.toIntOrNull() ?: 0
                    },
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }
            Divider(
                modifier = Modifier
                    .width(1.dp)
                    .height(50.dp)
                    .padding(
                        start = GenericUISetting.Padding.medium,
                        end = GenericUISetting.Padding.medium
                    )
            )
        }
    }
}