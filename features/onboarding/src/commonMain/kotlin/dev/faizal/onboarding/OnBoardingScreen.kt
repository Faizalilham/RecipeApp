package dev.faizal.onboarding


import SlideToUnlock
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.faizal.shared.component.GradientView
import org.jetbrains.compose.resources.painterResource
import recipeapp.features.onboarding.generated.resources.Res
import recipeapp.features.onboarding.generated.resources.on_boarding_image

@Composable
fun OnBoardingScreen(
    navigateToHome: () -> Unit,
) {
    GradientView {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Spacer(
                modifier = Modifier.weight(1f)
            )
//            Image(
//                painter = painterResource(Res.drawable.on_boarding_image),
//                contentDescription = "Onboarding image"
//            )
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Cooking",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 60.sp,
                        color = Color.Black
                    )
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Delicious",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 60.sp,
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

                Spacer(modifier = Modifier.height(16.dp))

                SlideToUnlock(
                    isLoading = false,
                    onUnlockRequested = navigateToHome,
                )
            }
        }
    }
}
