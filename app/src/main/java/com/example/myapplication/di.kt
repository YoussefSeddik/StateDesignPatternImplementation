package com.example.myapplication

import androidx.lifecycle.Lifecycle
import com.example.myapplication.main.MainActivityContract
import com.example.myapplication.main.MainActivityPresenter
import com.example.myapplication.states.complete_personal_info.CompletePersonalSatePresenter
import com.example.myapplication.states.complete_personal_info.CompletePersonalState
import com.example.myapplication.states.edit_family_member.EditFamilyMemberState
import com.example.myapplication.states.edit_family_member.EditFamilyMemberStatePresenter
import com.example.myapplication.states.personal_info.PersonalInfoState
import com.example.myapplication.states.personal_info.PersonalInfoStatePresenter
import org.koin.core.qualifier.named
import org.koin.dsl.module


val appModule = module {
    single<MainActivityContract.Presenter> {
        MainActivityPresenter()
    }

    single<MainActivityContract.Presenter>(named("PersonalPresenter")) {
        PersonalInfoStatePresenter()
    }
    single {
        PersonalInfoState(get(named("PersonalPresenter")))
    }

    single<MainActivityContract.Presenter>(named("CompletePresenter")) {
        CompletePersonalSatePresenter()
    }
    single {
        CompletePersonalState(get(named("CompletePresenter")))
    }

    single<MainActivityContract.Presenter>(named("EditPresenter")) {
        EditFamilyMemberStatePresenter()
    }
    single {
        EditFamilyMemberState(get(named("EditPresenter")))
    }
}
