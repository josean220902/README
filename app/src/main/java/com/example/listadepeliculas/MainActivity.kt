package com.example.listadepeliculas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("joseluis", "onCreate")
    }

    override fun onResume() {
        super.onResume()
        Log.d("joseluis", "onResume")
    }
}