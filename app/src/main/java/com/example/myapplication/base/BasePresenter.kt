package com.example.myapplication.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable


abstract class BasePresenter<View> : MvpPresenter<View> {

    protected var view: View? = null

    override fun attachView(view: View) {
        this.view = view
    }
}