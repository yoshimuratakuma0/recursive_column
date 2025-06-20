package com.free.accordion

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun <T> AccordionItem(
    modifier: Modifier,
    item: Item<T>,
    content: @Composable (T) -> Unit,
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
            content(item.itemData)
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
                    AccordionItem(
                        modifier = Modifier
                            .padding(start = 16.dp),
                        item = child,
                    ) {
                        content(child.itemData)
                    }
                }
            }
        }
    }
}