package dev.faizal.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import dev.faizal.domain.model.instructions.AnalyzedInstruction

@Composable
fun InstructionView(analyzedInstructions: List<AnalyzedInstruction>) {
    val steps = analyzedInstructions.flatMap { it.steps }

    val instructionsText = steps.joinToString("\n\n") { step ->
        "${step.number}. ${step.step}"
    }

    Text(
        text = instructionsText,
        style = MaterialTheme.typography.bodySmall,
    )
}