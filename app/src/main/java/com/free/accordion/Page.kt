package com.free.accordion

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

    Screen(items = items)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen(items: List<RecursiveItem<ItemData>>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Accordion Example") },
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = padding,
        ) {
            items(items.size) { index ->
                val item = items[index]
                AccordionItem(
                    modifier = Modifier
                        .padding(16.dp),
                    item = item,
                ) { itemData ->
                    Text(
                        text = itemData.title,
                        modifier = Modifier.padding(8.dp)
                    )
                }
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

class ItemData(
    val title: String,
)

private fun buildRootItem1(): RecursiveItem<ItemData> {
    val root = RecursiveItem(
        itemData = ItemData(title = "猫"),
    )
    val child1 = RecursiveItem(
        itemData = ItemData(title = "ミヌエット"),
    )
    val child2 = RecursiveItem(
        itemData = ItemData(title = "マンチカン"),
    )
    val child3 = RecursiveItem(
        itemData = ItemData(title = "スコティッシュフォールド"),
    )
    root.addChild(child1)
    root.addChild(child2)
    root.addChild(child3)
    return root
}

private fun buildRootItem2(): RecursiveItem<ItemData> {
    val root = RecursiveItem(
        itemData = ItemData(title = "ヒト科"),
    )
    val child1 = RecursiveItem(
        itemData = ItemData(title = "パン属"),
    )
    val child2 = RecursiveItem(
        itemData = ItemData(title = "ヒト属"),
    )
    root.addChild(child1)
    root.addChild(child2)

    val grandChild1 = RecursiveItem(
        itemData = ItemData(title = "チンパンジー"),
    )
    val grandChild2 = RecursiveItem(
        itemData = ItemData(title = "ボノボ"),
    )
    val grandChild3 = RecursiveItem(
        itemData = ItemData(title = "ヒト"),
    )
    val grandChild4 = RecursiveItem(
        itemData = ItemData(title = "ネアンデルタール人"),
    )

    child1.addChild(grandChild1)
    child1.addChild(grandChild2)
    child2.addChild(grandChild3)
    child2.addChild(grandChild4)
    return root
}