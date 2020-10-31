package com.example.myapplication.states.personal_info

import android.content.Context
import android.view.View
import androidx.lifecycle.Lifecycle
import com.example.myapplication.states.State
import com.example.myapplication.ext.showB
import com.example.myapplication.main.MainActivity
import com.example.myapplication.main.MainActivityContract
import com.example.myapplication.models.MemberModel
import kotlinx.android.synthetic.main.activity_main.view.*

class PersonalInfoState(
    override val presenter: MainActivityContract.Presenter
) : State {

    override fun initViewsVisibility(view: View) {
        with(view) {
            nameGroup.showB()
            emailGroup.showB()
            personalInfoGroup.showB()
        }
    }

    override fun getData() {
        presenter.getData()
    }

    override fun initViewsData(
        view: View,
        memberModel: MemberModel
    ) {
        with(view) {
            if (memberModel.name.isNotEmpty()) {
                nameET.setText(memberModel.name)
            }
            if (memberModel.email.isNotEmpty()) {
                emailET.setText(memberModel.email)
            }
            if (memberModel.personalNote.isNotEmpty()) {
                personalNoteET.setText(memberModel.personalNote)
            }
        }
    }

    override fun saveChanges(
        memberModel: MemberModel,
        context: Context
    ) {
        presenter.validateData(memberModel, context)
    }


}