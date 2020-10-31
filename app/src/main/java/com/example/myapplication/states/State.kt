package com.example.myapplication.states

import android.content.Context
import android.view.View
import com.example.myapplication.main.MainActivityContract
import com.example.myapplication.models.MemberModel


interface State {
    val presenter: MainActivityContract.Presenter
    fun initViewsVisibility(
        view: View)
    fun getData()
    fun initViewsData(
        view: View,memberModel: MemberModel
    )

    fun saveChanges(
        memberModel: MemberModel,
        context: Context
    )
}

