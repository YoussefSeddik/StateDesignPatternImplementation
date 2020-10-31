package com.example.myapplication.states.edit_family_member

import android.content.Context
import android.view.View
import androidx.lifecycle.Lifecycle
import com.example.myapplication.states.State
import com.example.myapplication.ext.showB
import com.example.myapplication.main.MainActivity
import com.example.myapplication.main.MainActivityContract
import com.example.myapplication.models.MemberModel
import kotlinx.android.synthetic.main.activity_main.view.*

class EditFamilyMemberState(
    override val presenter: MainActivityContract.Presenter
) : State {

    override fun initViewsVisibility(view: View) {
        with(view) {
            nameGroup.showB()
            roleGroup.showB()
            statusGroup.showB()
            editFamilyNoteGroup.showB()
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
            if (memberModel.role.isNotEmpty()) {
                roleET.setText(memberModel.role)
            }
            if (memberModel.status.isNotEmpty()) {
                statusET.setText(memberModel.status)
            }
            if (memberModel.editFamilyNote.isNotEmpty()) {
                editFamilyNoteET.setText(memberModel.editFamilyNote)
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