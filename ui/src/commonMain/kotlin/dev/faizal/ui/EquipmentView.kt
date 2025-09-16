package dev.faizal.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage
import dev.faizal.domain.model.instructions.Equipment

@Composable
fun EquipmentView(equipment: Equipment){
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(Color(0xFFF5F5F5)),
            contentAlignment = Alignment.Center
        ) {

            if(equipment.image.isNotBlank()){
                CoilImage(
                    imageModel = { equipment.image },
                    imageOptions = ImageOptions(
                        contentScale = ContentScale.Crop,
                    )
                )
            }else{
                Text(
                    text = equipment.name.take(1).uppercase(),
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray
                )
            }
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = equipment.name,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Black
            )
            Text(
                text = equipment.localizedName,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
        }
    }
}