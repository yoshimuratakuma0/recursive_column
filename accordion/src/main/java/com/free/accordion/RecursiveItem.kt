package com.free.accordion

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class RecursiveItem<T>(
    internal val itemData: T,
    internal val children: MutableList<RecursiveItem<T>> = mutableListOf(),
) {
    internal var isExpanded by mutableStateOf(false)
    fun addChild(child: RecursiveItem<T>) {
        children.add(child)
    }
}