package com.example.testprimo.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testprimo.model.FeedDetailPresenter
import com.example.testprimo.usecase.GetFeedDetailUseCase
import com.example.testprimo.base.data
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getFeedDetailUseCase: GetFeedDetailUseCase
) : ViewModel() {

    private val _feedDetail = MutableLiveData<FeedDetailPresenter>()
    val feedDetail: LiveData<FeedDetailPresenter>
        get() = _feedDetail

    fun loadDetail(id: String) {
        viewModelScope.launch {
            getFeedDetailUseCase.invoke(GetFeedDetailUseCase.Param(id)).data?.let {
                _feedDetail.postValue(it)
            }
        }
    }
}