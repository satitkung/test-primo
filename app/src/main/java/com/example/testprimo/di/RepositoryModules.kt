package com.example.testprimo.di

import com.example.testprimo.repository.FeedRepository
import com.example.testprimo.repository.FeedRepositoryImpl
import com.example.testprimo.room.FeedDao
import com.example.testprimo.service.FeedApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModules {

    @Provides
    fun providesFeedRepository(
        feedApi: FeedApi,
        feedDao: FeedDao
    ): FeedRepository {
        return FeedRepositoryImpl(feedApi, feedDao)
    }

}
