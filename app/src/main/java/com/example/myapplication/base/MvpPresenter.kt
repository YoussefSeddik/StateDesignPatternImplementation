package com.example.myapplication.base


interface MvpPresenter<View> {
    fun attachView(view: View)
}