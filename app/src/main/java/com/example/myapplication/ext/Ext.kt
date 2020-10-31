package com.example.myapplication.ext

import android.view.View

fun View.showB(){
    visibility = View.VISIBLE
}

fun View.secretB(){
    visibility = View.GONE
}
fun View.hideB(){
    visibility = View.INVISIBLE
}