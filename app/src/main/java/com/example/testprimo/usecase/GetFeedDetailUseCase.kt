package com.example.testprimo.usecase

import com.example.testprimo.base.CoroutineUseCase
import com.example.testprimo.di.DispatcherIO
import com.example.testprimo.model.FeedDetailPresenter
import com.example.testprimo.repository.FeedRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetFeedDetailUseCase @Inject constructor(
    @DispatcherIO dispatcher: CoroutineDispatcher,
    private val repository: FeedRepository
) : CoroutineUseCase<GetFeedDetailUseCase.Param, FeedDetailPresenter>(dispatcher) {

    data class Param(
        val id: String
    )

    override suspend fun execute(parameters: Param): FeedDetailPresenter {
        return repository.getFeedDetail(parameters.id)
    }
}