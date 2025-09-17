package dev.faizal.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.coil3.CoilImage

@Composable
fun InfoItem(
    iconUrl: String,
    text: String,
    style: TextStyle = MaterialTheme.typography.bodyMedium,
    color : Color = Color.Black,
    iconSize : Dp = 24.dp
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CoilImage(
            imageModel = { iconUrl },
            modifier = Modifier.size(iconSize),
            success = { _, painter ->
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier.size(iconSize),
                    colorFilter = ColorFilter.tint(color)
                )
            }
        )
        Text(
            text = text,
            style = style,
            color = color,
        )
    }
}