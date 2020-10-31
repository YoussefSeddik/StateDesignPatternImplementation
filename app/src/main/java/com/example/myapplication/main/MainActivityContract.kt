package com.example.myapplication.main

import android.content.Context
import com.example.myapplication.base.MvpPresenter
import com.example.myapplication.models.MemberModel

interface MainActivityContract {
    interface Presenter:MvpPresenter<View>{
        fun validateData(
            memberModel: MemberModel,
            context: Context
        )
        fun getData()
        fun saveChanges(memberModel: MemberModel)
    }

    interface View{
        fun onGetUserDataSuccess(memberModel: MemberModel)
        fun onSaveChangesSuccess()
    }
}