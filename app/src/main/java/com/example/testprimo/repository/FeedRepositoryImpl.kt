package com.example.testprimo.repository

import com.example.testprimo.model.FeedDetailPresenter
import com.example.testprimo.model.FeedHomePresenter
import com.example.testprimo.model.mapper.toEntity
import com.example.testprimo.room.FeedDao
import com.example.testprimo.service.FeedApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FeedRepositoryImpl(
    private val feedApi: FeedApi,
    private val feedDao: FeedDao

) : FeedRepository {

    override suspend fun getFeedDetail(id: String): FeedDetailPresenter =
        withContext(Dispatchers.IO) {
            feedDao.getFeedDetail(id)
        }

    override suspend fun getDataFromRemote(): List<FeedHomePresenter> =
        withContext(Dispatchers.IO) {
            feedApi.getFeed().channel?.itemList?.map { it.toEntity() }?.let {
                feedDao.insert(it)
            }
            getDataFromLocal()
        }

    override suspend fun getDataFromLocal(): List<FeedHomePresenter> =
        withContext(Dispatchers.IO) {
            feedDao.getFeedList()
        }

}