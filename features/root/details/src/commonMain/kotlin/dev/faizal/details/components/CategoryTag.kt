package dev.faizal.details.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp


@Composable
fun RecipeCategoryTags(
    dishTypes: List<String> = listOf("lunch", "main course", "main dish", "dinner"),
    isVegetarian: Boolean = false,
    isVegan: Boolean = false
) {

    fun formatDishType(dishType: String): String {
        return dishType.uppercase().replace(Regex("\\s+"), " ")
    }

    val mainDishType = dishTypes.find {
        it.contains("main") || it == "dinner" || it == "lunch"
    } ?: dishTypes.firstOrNull() ?: "MAIN DISH"

    val categories = listOf(
        formatDishType(mainDishType),
        if (isVegetarian) "VEGAN" else "NON-VEGAN",
        if (isVegetarian) "VEGETARIAN" else "NON-VEGETARIAN"
    ).distinct()

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categories) { category ->
            CategoryTag(text = category)
        }
    }
}

@Composable
fun CategoryTag(text: String) {
    Surface(
        modifier = Modifier
            .clickable { /* Handle click */ }
            .padding(horizontal = 4.dp)
            .width(100.dp),
        shape = RoundedCornerShape(8.dp),
        color = Color(0xFFF5F5F5),
        border = BorderStroke(1.dp, Color(0xFFE0E0E0))
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight.Medium,
                color = Color(0xFF616161)
            ),
            fontSize = 8.sp
        )
    }
}