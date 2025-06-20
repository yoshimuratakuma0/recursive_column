package com.free.accordion

interface RecursiveData<T> {
    val value: T
    val children: List<RecursiveData<T>>
    var isExpanded: Boolean
}
