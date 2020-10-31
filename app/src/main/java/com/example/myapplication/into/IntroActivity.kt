package com.example.myapplication.into

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.main.MainActivity
import com.example.myapplication.states.personal_info.PersonalInfoState
import kotlinx.android.synthetic.main.activity_intro.*
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.get

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        personalInfo.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(STATE,StateEnum.PERSONAL_INFO.name)
            startActivity(intent)
        }
        completeInfo.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(STATE,StateEnum.COMPLETE_INFO.name)
            startActivity(intent)
        }
        editFamilyInfo.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(STATE,StateEnum.EDIT_FAMILY_INFO.name)
            startActivity(intent)
        }
    }

    companion object {
        const val STATE = "STATE"
    }
}

enum class StateEnum {
    PERSONAL_INFO,
    COMPLETE_INFO,
    EDIT_FAMILY_INFO
}