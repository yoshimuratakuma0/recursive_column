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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RecursiveItem(
    modifier: Modifier,
    item: Item,
) {
    Column(
        modifier = modifier,
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
            Text(
                text = item.itemData.title,
                modifier = Modifier
                    .padding(8.dp),
            )
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
                    RecursiveItem(
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .animateContentSize(),
                        item = child,
                    )
                }
            }
        }
    }
}