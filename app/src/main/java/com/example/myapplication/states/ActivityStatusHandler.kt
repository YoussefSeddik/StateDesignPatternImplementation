package com.example.myapplication.states

import android.content.Context
import android.view.View
import androidx.lifecycle.Lifecycle
import com.example.myapplication.main.MainActivity
import com.example.myapplication.main.MainActivityContract
import com.example.myapplication.models.MemberModel
import com.example.myapplication.states.personal_info.PersonalInfoState
import org.koin.android.ext.android.get
import org.koin.core.context.GlobalContext.get

class ActivityStatusHandler(
    var view: View
) {
    var mState: State? = null

    fun setState(state: State) {
        mState = state
    }

    fun attachStatePresenterToActivityView(
        mainActivity: MainActivityContract.View
    ) {
        mState?.presenter?.attachView(mainActivity)
    }

    fun initViewsVisibility() {
        mState?.initViewsVisibility(view)
    }

    fun initViewsData(memberModel: MemberModel) {
        mState?.initViewsData(view, memberModel)
    }

    fun saveAllChanges(memberModel: MemberModel, context: Context) {
        mState?.saveChanges(memberModel, context)
    }

    fun getMemberData() {
        mState?.getData()
    }
}

