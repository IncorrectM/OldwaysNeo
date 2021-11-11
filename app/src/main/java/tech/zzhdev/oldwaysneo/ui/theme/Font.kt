package tech.zzhdev.oldwaysneo.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object FontSizeController {
    const val MAX_BASE_SIZE = 20

    var baseSize = 10
    var incrementStep = 2

    val articleTitleL
        get() = getLevel(17)
    val articleTitle
        get() = getLevel(15)
    val articleTitleS
        get() = getLevel(13)

    val subtitleL
        get() = getLevel(13)
    val subtitle
        get() = getLevel(11)
    val subtitleS
        get() = getLevel(9)

    val passageL
        get() = getLevel(9)
    val passage
        get() = getLevel(7)
    val passageS
        get() = getLevel(5)

    val markL
        get() = getLevel(5)
    val mark
        get() = getLevel(3)
    val markS
        get() = getLevel(1)

    private fun getLevel(level: Int): MutableLiveData<TextUnit> {

        return MutableLiveData((baseSize + (level - 1) * incrementStep).sp)
    }

    fun changeBaseSize(rate: Float) {
        this.baseSize = (MAX_BASE_SIZE * rate).toInt()
    }

    fun getCurrentRate(): Float = (this.baseSize.toFloat() / MAX_BASE_SIZE.toFloat())
}

@Composable
fun LiveData<TextUnit>.observeAsStateInitialed() = this.observeAsState(initial = this.value ?: MaterialTheme.typography.subtitle1.fontSize)