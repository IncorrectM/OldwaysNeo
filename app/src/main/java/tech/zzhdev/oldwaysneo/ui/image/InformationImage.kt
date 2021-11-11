package tech.zzhdev.oldwaysneo.ui.image

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import tech.zzhdev.oldwaysneo.data.ServerInfo
import tech.zzhdev.oldwaysneo.ui.theme.KleinBlue


@Composable
fun InformationImage(
    url: String,
    circular: Boolean = false
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
                .clip(if (circular) CircleShape else RectangleShape)
                .border(2.dp, KleinBlue, RoundedCornerShape(5.dp)),
            painter = painter,
            contentDescription = "Simple logo of my site.")
        when(painter.state) {
            is ImagePainter.State.Loading -> {
                // Display a circular
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            is ImagePainter.State.Error -> {
                Toast.makeText(LocalContext.current, "无法加载图片", Toast.LENGTH_SHORT).show()
                Log.d("INFORMATION_IMAGE", "InformationImage: Unable to get '$url'")
            }
            else -> {
                // Do nothing
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InformationImagePreview() {
    InformationImage(url = ServerInfo.logoUrl)
}