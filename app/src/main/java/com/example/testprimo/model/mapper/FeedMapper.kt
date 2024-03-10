package com.example.testprimo.model.mapper

import com.example.testprimo.model.FeedItem
import com.example.testprimo.room.FeedEntity

fun FeedItem.toEntity(): FeedEntity {
    return FeedEntity(
        title = title,
        pubDate = pubDate,
        detail = encodedContent.orEmpty()
    )
}