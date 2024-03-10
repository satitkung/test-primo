package com.example.testprimo.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testprimo.model.FeedHomePresenter
import com.example.testprimo.usecase.GetFeedRemoteUseCase
import com.example.testprimo.base.data
import com.example.testprimo.usecase.GetFeedListLocalUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getFeedRemoteUseCase: GetFeedRemoteUseCase,
    private val getFeedListLocalUseCase: GetFeedListLocalUseCase
) : ViewModel() {

    private val _feedList = MutableLiveData<List<FeedHomePresenter>>()
    val feedList: LiveData<List<FeedHomePresenter>>
        get() = _feedList

    fun loadData() {
        viewModelScope.launch {
            getFeedLocal()
            getFeedRemote()
        }
    }

    private suspend fun getFeedLocal() {
        getFeedListLocalUseCase.invoke(Unit).data?.let {
            _feedList.postValue(it)
        }
    }

    private suspend fun getFeedRemote() {
        getFeedRemoteUseCase.invoke(Unit).data?.let {
            _feedList.postValue(it)
        }
    }

}