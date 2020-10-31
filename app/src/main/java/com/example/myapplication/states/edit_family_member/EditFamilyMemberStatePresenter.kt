package com.example.myapplication.states.edit_family_member

import android.content.Context
import android.widget.Toast
import com.example.myapplication.base.BasePresenter
import com.example.myapplication.main.MainActivityContract
import com.example.myapplication.models.MemberModel

class EditFamilyMemberStatePresenter : BasePresenter<MainActivityContract.View>(),
    MainActivityContract.Presenter {


    override fun validateData(
        memberModel: MemberModel,
        context: Context
    ) {
        val errMassage = memberModel.validateDataForAddFamilyMember(context)
        if(errMassage.isEmpty()){
            saveChanges(memberModel)
        }else{
            Toast.makeText(context,errMassage,Toast.LENGTH_SHORT).show()
        }
    }

    override fun getData() {
        val memberModel = MemberModel()
        memberModel.name = "Youssef Seddik"
        memberModel.email = "Joe@gmail.com"
        memberModel.personalNote = "Personal info text"
        memberModel.completeNote = "Complete info text"
        memberModel.editFamilyNote = "Edit family member text"
        memberModel.role = "Father"
        memberModel.status = "Single"
        view?.onGetUserDataSuccess(memberModel)
    }

    override fun saveChanges(memberModel: MemberModel) {
        view?.onSaveChangesSuccess()
    }

}