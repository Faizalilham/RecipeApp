package dev.faizal.shared.utils

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight

fun String.parseHtmlToAnnotatedString(): AnnotatedString {
    return buildAnnotatedString {
        val boldRegex = "<b>(.*?)</b>".toRegex()
        var lastIndex = 0
        for (match in boldRegex.findAll(this@parseHtmlToAnnotatedString)) {
            append(this@parseHtmlToAnnotatedString.substring(lastIndex, match.range.first))
            pushStyle(SpanStyle(fontWeight = FontWeight.Bold))
            append(match.groupValues[1])
            pop()
            lastIndex = match.range.last + 1
        }
        append(this@parseHtmlToAnnotatedString.substring(lastIndex))
    }
}

@Composable
fun String.asHtmlText() {
    Text(text = this.parseHtmlToAnnotatedString())
}