package com.example.testprimo.model

import androidx.room.ColumnInfo

data class FeedDetailPresenter(
    @ColumnInfo(name = "detail")
    val detail: String
)
