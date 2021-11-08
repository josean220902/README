package com.example.listadepeliculas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("joseluis", "La actividad se ha creado")
    }
    override fun onStart() {
        super.onStart()
        Log.d("joseluis","Pasa a estado visible")
    }
    override fun onPause() {
        super.onPause()
        Log.d("joseluis","Sale de estado visible")
    }
    override fun onResume() {
        super.onResume()
        Log.d("joseluis", "Empieza el estado foreground")
    }

    override fun onStop() {
        super.onStop()
        Log.d("joseluis","la aplicacion se ha parado")
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d("joseluis","La actividad se ha destruido")
    }




}