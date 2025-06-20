package com.free.accordion

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun <T> AccordionItem(
    modifier: Modifier = Modifier,
    item: RecursiveItem<T>,
    content: @Composable (T, level: Int) -> Unit,
) {
    InternalAccordionItem(
        modifier = modifier,
        item = item,
        level = 0,
        content = content,
    )
}

@Composable
private fun <T> InternalAccordionItem(
    modifier: Modifier = Modifier,
    item: RecursiveItem<T>,
    level: Int,
    content: @Composable (T, level: Int) -> Unit,
) {
    Column(
        modifier = modifier
            .animateContentSize(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    item.isExpanded = !item.isExpanded
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            content(item.itemData, level)
            if (item.children.isNotEmpty()) {
                if (item.isExpanded) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowUp,
                        contentDescription = null,
                    )
                } else {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = null,
                    )
                }
            }
        }

        if (item.children.isNotEmpty()) {
            if (item.isExpanded) {
                item.children.forEach { child ->
                    InternalAccordionItem(
                        item = child,
                        level = level + 1,
                        content = content,
                    )
                }
            }
        }
    }
}