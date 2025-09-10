package dev.faizal.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.shimmer

@Composable
fun DetailSkeletonScreen(){
    Column(
        modifier = Modifier
            .shimmer()
            .fillMaxSize()
            .padding(horizontal = 12.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Box(
            modifier = Modifier
                .shimmer()
                .background(Color.Gray.copy(alpha = 0.2f))
                .clip(RoundedCornerShape(12.dp))
                .height(300.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .shimmer()
                    .background(Color.Gray.copy(alpha = 0.2f))
                    .height(16.dp)
                    .width(120.dp)
                    .alpha(0.5f)
            )
            Box(
                modifier = Modifier
                    .shimmer()
                    .background(Color.Gray.copy(alpha = 0.2f))
                    .height(24.dp)
                    .width(80.dp)
                    .clip(RoundedCornerShape(50))
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Box(
            modifier = Modifier
                .shimmer()
                .background(Color.Gray.copy(alpha = 0.2f))
                .height(24.dp)
                .fillMaxWidth(0.6f)
                
        )

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .shimmer()
                .background(Color.Gray.copy(alpha = 0.2f))
                .height(80.dp)
                .fillMaxWidth()
                
        )

        Spacer(modifier = Modifier.height(24.dp))

        repeat(2) {
            Box(
                modifier = Modifier
                    .shimmer()
                    .background(Color.Gray.copy(alpha = 0.2f))
                    .height(60.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    
            )
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}