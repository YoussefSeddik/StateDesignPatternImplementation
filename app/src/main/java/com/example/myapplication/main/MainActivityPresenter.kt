package com.example.myapplication.main

import android.content.Context
import com.example.myapplication.base.BasePresenter
import com.example.myapplication.models.MemberModel

class MainActivityPresenter :BasePresenter<MainActivityContract.View>(),MainActivityContract.Presenter {
    override fun validateData(memberModel: MemberModel, context: Context) {

    }

    override fun getData() {
    }

    override fun saveChanges(memberModel: MemberModel) {
    }
}