package com.example.testprimo.repository

import com.example.testprimo.model.FeedDetailPresenter
import com.example.testprimo.model.FeedHomePresenter

interface FeedRepository {
    suspend fun getFeedDetail(id: String): FeedDetailPresenter
    suspend fun getDataFromRemote(): List<FeedHomePresenter>
    suspend fun getDataFromLocal(): List<FeedHomePresenter>
}