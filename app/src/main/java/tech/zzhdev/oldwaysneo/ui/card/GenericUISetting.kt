package tech.zzhdev.oldwaysneo.ui.card

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object GenericUISetting {
    object Elevation {
        private const val base = 5;

        val higher
            get() = getLevel(level = 4)

        val high
            get() = getLevel(level = 3, offset = 1)

        val low
            get() = getLevel(level = 2, offset = 2)

        val lower
            get() = getLevel(level = 2, offset = -4)

        private fun getLevel(level: Int, offset: Int = 0) = (base * level + offset).dp
    }

    object ImageDimension {
        object WidthInSmall {
            val min = 100.dp
            val max = 150.dp
        }

        object HeightInSmall {
            val min = 100.dp
            val max = 150.dp
        }

        object WidthIn {
            val min = 300.dp
            val max = 300.dp
        }

        object HeightIn {
            val min = 300.dp
            val max = 300.dp
        }

        val height = 100.dp
        val width = 100.dp
    }

    object CardDimension {
        object WidthInSmall {
            val min = 200.dp
            val max = 300.dp
        }

        object HeightInSmall {
            val min = 250.dp
            val max = 350.dp
        }

        object WidthIn {
            val min = 200.dp
            val max = 300.dp
        }

        object HeightIn {
            val min = 200.dp
            val max = 300.dp
        }

        val height = 100.dp
        val width = 100.dp
    }

    object Padding {
        private const val base = 5

        val much
            get() = getLevel(8)

        val mediumMuch
            get() = getLevel(6)

        val medium
            get() = getLevel(4)

        val mediumLess
            get() = getLevel(3)

        val less
            get() = getLevel(2)

        private fun getLevel(level: Int, offset: Int = 0) = (base * level + offset).dp
    }
}

fun Dp.half(): Dp = (this.value / 2).dp