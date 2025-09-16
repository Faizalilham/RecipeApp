package dev.faizal.onboarding

import SlideToUnlock
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skydoves.landscapist.coil3.CoilImage
import dev.faizal.ui.GradientView
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun OnBoardingScreen(
    navigateToHome: () -> Unit,
) {
    var isLoading by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    GradientView {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            CoilImage(
                imageModel = { "https://res.cloudinary.com/dmhpacb7m/image/upload/v1757911613/aauaouu6pmfe9qdxq0ck.png" },
                modifier = Modifier
                    .align(Alignment.Start)
                    .offset(x = (-48).dp)
            )

            Spacer(modifier = Modifier.weight(0.8f))

            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Cooking",
                    style = MaterialTheme.typography.headlineLarge
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Delicious",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        color = Color.Gray
                    )
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Like a Chef",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 60.sp,
                        color = Color.Gray
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "This recipe app offers a wide selection of diverse and easy recipes suitable for all cooking levels!",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.Gray,
                    ),
                )

                Spacer(modifier = Modifier.height(32.dp))

                SlideToUnlock(
                    isLoading = isLoading,
                    onUnlockRequested = {
                        isLoading = true
                        scope.launch {
                            delay(2000)
                            isLoading = false
                            navigateToHome()
                        }
                    }
                )
            }
        }
    }
}