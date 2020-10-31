package com.example.myapplication.base

import androidx.lifecycle.Lifecycle

interface MvpPresenter<View> {
    fun attachView(view: View)
}