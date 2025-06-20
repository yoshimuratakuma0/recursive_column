package com.free.accordion

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Item<T>(
    val itemData: T,
    val children: MutableList<Item<T>>,
) {
    var isExpanded by mutableStateOf(false)
}