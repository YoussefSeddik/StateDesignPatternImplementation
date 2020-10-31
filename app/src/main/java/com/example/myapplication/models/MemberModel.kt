package com.example.myapplication.models

import android.content.Context
import com.example.myapplication.R

class MemberModel(
    var name: String = "",
    var email: String = "",
    var personalNote: String = "",
    var completeNote: String = "",
    var editFamilyNote: String = "",
    var role: String = "",
    var status: String = ""
) {
    fun validateDataForPersonalInfo(context: Context): String {
        return when {
            name.isEmpty() -> {
                context.getString(R.string.err_name)
            }
            email.isEmpty() -> {
                context.getString(R.string.err_email)
            }
            personalNote.isEmpty() -> {
                context.getString(R.string.err_personal_note)
            }
            else -> ""
        }
    }

    fun validateDataForCompleteProfile(context: Context): String {
        return when {
            email.isEmpty() -> {
                context.getString(R.string.err_email)
            }
            completeNote.isEmpty() -> {
                context.getString(R.string.err_complete_profile)
            }
            else -> ""
        }
    }

    fun validateDataForAddFamilyMember(context: Context): String {
        return when {
            name.isEmpty() -> {
                context.getString(R.string.err_name)
            }
            role.isEmpty() -> {
                context.getString(R.string.err_role)
            }
            status.isEmpty() -> {
                context.getString(R.string.err_status)
            }
            editFamilyNote.isEmpty() -> {
                context.getString(R.string.err_edit_family_note)
            }
            else -> ""
        }
    }
}
