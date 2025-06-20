package com.free.accordion

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class RecursiveItem<T>(
    val itemData: T,
    val children: MutableList<RecursiveItem<T>> = mutableListOf(),
) {
    var isExpanded by mutableStateOf(false)
}