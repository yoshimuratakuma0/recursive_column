package com.free.accordion

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Page() {
    val items = remember {
        mutableStateListOf(
            buildRootItem1(),
            buildRootItem2(),
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen(items: List<Item>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Accordion Example") },
            )
        }
    ) { padding ->
        LazyColumn(
            modifier=Modifier.fillMaxSize(),
            contentPadding = padding,
        ) {
            items(items.size) { index ->
                val item = items[index]
                RecursiveItem(
                    modifier = Modifier
                        .padding(16.dp)
                        .animateContentSize(),
                    item = item,
                )
            }
        }
    }
}

@Preview
@Composable
fun ScreenPreview() {
    Screen(
        listOf(
            buildRootItem1(),
            buildRootItem2(),
        )
    )
}

class Item(
    val itemData: ItemData,
    val children: MutableList<Item>,
)

data class ItemData(
    val title: String,
)

private fun buildRootItem1(): Item {
    val root = Item(
        itemData = ItemData(title = "猫"),
        children = mutableListOf(),
    )
    val child1 = Item(
        itemData = ItemData(title = "ミヌエット"),
        children = mutableListOf(),
    )
    val child2 = Item(
        itemData = ItemData(title = "マンチカン"),
        children = mutableListOf(),
    )
    val child3 = Item(
        itemData = ItemData(title = "スコティッシュフォールド"),
        children = mutableListOf(),
    )
    root.children.add(child1)
    root.children.add(child2)
    root.children.add(child3)
    return root
}

private fun buildRootItem2(): Item {
    val root = Item(
        itemData = ItemData(title = "ヒト科"),
        children = mutableListOf(),
    )
    val child1 = Item(
        itemData = ItemData(title = "パン属"),
        children = mutableListOf(),
    )
    val child2 = Item(
        itemData = ItemData(title = "ヒト属"),
        children = mutableListOf(),
    )
    root.children.add(child1)
    root.children.add(child2)

    val grandChild1 = Item(
        itemData = ItemData(title = "チンパンジー"),
        children = mutableListOf(),
    )
    val grandChild2 = Item(
        itemData = ItemData(title = "ボノボ"),
        children = mutableListOf(),
    )
    val grandChild3 = Item(
        itemData = ItemData(title = "ヒト"),
        children = mutableListOf(),
    )
    val grandChild4 = Item(
        itemData = ItemData(title = "ネアンデルタール人"),
        children = mutableListOf(),
    )

    child1.children.add(grandChild1)
    child1.children.add(grandChild2)
    child2.children.add(grandChild3)
    child2.children.add(grandChild4)
    return root
}