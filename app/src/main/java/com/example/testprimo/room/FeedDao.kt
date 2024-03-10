package com.example.testprimo.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testprimo.model.FeedDetailPresenter
import com.example.testprimo.model.FeedHomePresenter

@Dao
interface FeedDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: List<FeedEntity>)

    @Query("SELECT title, pubDate FROM feed")
    suspend fun getFeedList(): List<FeedHomePresenter>

    @Query("SELECT detail FROM feed WHERE title = :id")
    suspend fun getFeedDetail(id: String): FeedDetailPresenter
}