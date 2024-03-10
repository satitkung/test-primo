package com.example.testsalehere.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T> LifecycleOwner.observeFor(liveData: LiveData<T>?, perform: (T) -> Unit) {
    liveData?.observe(this, Observer {
        it ?: return@Observer
        perform(it)
    })
}