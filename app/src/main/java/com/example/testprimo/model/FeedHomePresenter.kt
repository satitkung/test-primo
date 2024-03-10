package com.example.testprimo.model

import androidx.room.ColumnInfo

data class FeedHomePresenter(
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "pubDate")
    val pubDate: String
)
