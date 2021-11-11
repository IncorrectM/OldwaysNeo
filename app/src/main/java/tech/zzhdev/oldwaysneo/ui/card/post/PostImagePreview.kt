package tech.zzhdev.oldwaysneo.ui.card.post

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import tech.zzhdev.oldwaysneo.data.passage.OldWaysImageURL
import tech.zzhdev.oldwaysneo.ui.card.GenericUISetting
import tech.zzhdev.oldwaysneo.ui.theme.KleinBlue

@Composable
fun PostImagePreview(
    url: OldWaysImageURL
) {
    val painter = rememberImagePainter(
        data = url,
        builder = {
            crossfade(1000)
        }
    )
    Box {
        Image(
            modifier = Modifier
                .widthIn(
                    min = GenericUISetting.ImageDimension.WidthIn.min,
                    max = GenericUISetting.ImageDimension.WidthIn.max
                )
                .heightIn(
                    min = GenericUISetting.ImageDimension.HeightIn.min,
                    max = GenericUISetting.ImageDimension.HeightIn.max
                )
                .padding(GenericUISetting.Padding.less),
            painter = painter,
            contentDescription = "Simple logo of my site.")
        when(painter.state) {
            is ImagePainter.State.Loading -> {
                // Display a circular
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            is ImagePainter.State.Error -> {
                Toast.makeText(LocalContext.current, "无法加载图片", Toast.LENGTH_SHORT).show()
                Log.d("POST_IMAGE", "PostImage: Unable to get '$url'")
            }
            else -> {
                // Do nothing
            }
        }
    }
}