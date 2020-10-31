package com.example.myapplication.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.myapplication.R
import com.example.myapplication.into.IntroActivity.Companion.STATE
import com.example.myapplication.into.StateEnum
import com.example.myapplication.models.MemberModel
import com.example.myapplication.states.ActivityStatusHandler
import com.example.myapplication.states.complete_personal_info.CompletePersonalState
import com.example.myapplication.states.edit_family_member.EditFamilyMemberState
import com.example.myapplication.states.personal_info.PersonalInfoState
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(),
    MainActivityContract.View {
    private var memberModel = MemberModel()
    private lateinit var statusHandler: ActivityStatusHandler
    var stateEnum: StateEnum? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        stateEnum = StateEnum.valueOf(intent?.getStringExtra(STATE) ?: "")
        setUpController()
        statusHandler = ActivityStatusHandler(window.decorView)
        val state = when (stateEnum) {
            StateEnum.PERSONAL_INFO -> get<PersonalInfoState>()
            StateEnum.COMPLETE_INFO -> get<CompletePersonalState>()
            else -> {
                get<EditFamilyMemberState>()
            }
        }
        statusHandler.setState(state)
        statusHandler.attachStatePresenterToActivityView(this)
        statusHandler.getMemberData()
        statusHandler.initViewsVisibility()
    }

    private fun setUpController() {
        nameET.addTextChangedListener {
            memberModel.name = it.toString()
        }
        emailET.addTextChangedListener {
            memberModel.email = it.toString()
        }
        personalNoteET.addTextChangedListener {
            memberModel.personalNote = it.toString()
        }
        completeNoteET.addTextChangedListener {
            memberModel.completeNote = it.toString()
        }
        roleET.addTextChangedListener {
            memberModel.role = it.toString()
        }
        statusET.addTextChangedListener {
            memberModel.status = it.toString()
        }
        editFamilyNoteET.addTextChangedListener {
            memberModel.editFamilyNote = it.toString()
        }
        saveButton.setOnClickListener {
            statusHandler.saveAllChanges(memberModel, this)
        }
    }

    override fun onGetUserDataSuccess(memberModel: MemberModel) {
        statusHandler.initViewsData(memberModel)
    }

    override fun onSaveChangesSuccess() {
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
        finish()
    }

}