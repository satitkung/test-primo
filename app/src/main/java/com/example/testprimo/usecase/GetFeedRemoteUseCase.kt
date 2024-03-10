package com.example.testprimo.usecase

import com.example.testprimo.base.CoroutineUseCase
import com.example.testprimo.di.DispatcherIO
import com.example.testprimo.model.FeedHomePresenter
import com.example.testprimo.repository.FeedRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetFeedRemoteUseCase @Inject constructor(
    @DispatcherIO dispatcher: CoroutineDispatcher,
    private val repository: FeedRepository
) : CoroutineUseCase<Unit, List<FeedHomePresenter>>(dispatcher) {

    override suspend fun execute(parameters: Unit): List<FeedHomePresenter> {
        return repository.getDataFromRemote()
    }
}