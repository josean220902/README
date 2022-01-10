package com.example.listadepeliculas

import android.util.Log
import javax.inject.Inject

class MyLog @Inject constructor(){
    fun log(message: String){
        Log.d("JoseLuis", message)
    }

}