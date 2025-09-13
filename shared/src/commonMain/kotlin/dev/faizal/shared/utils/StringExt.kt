package dev.faizal.shared.utils



fun String.stripHtmlTags(): String {
    return this.replace(Regex("<[^>]*>"), "")
}