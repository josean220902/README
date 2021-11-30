package com.example.listadepeliculas

import CasoDeUsos.CasoDeUso
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
   lateinit var log: MyLog
   @Inject
   lateinit var usecase: CasoDeUso
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        log.log("joseluis la actividad se ha creado")
        val film = usecase.execute()
        log.log("El titulo es: ${film.tittle} " )

    }
    override fun onStart() {
        super.onStart()
        log.log("joseluis Pasa a estado visible")
    }
    override fun onPause() {
        super.onPause()
        log.log("joseluis Sale de estado visible")
    }
    override fun onResume() {
        super.onResume()
        log.log("joseluis Empieza el estado foreground")
    }

    override fun onStop() {
        super.onStop()
        log.log("joseluis la aplicacion se ha parado")
    }


    override fun onDestroy() {
        super.onDestroy()
        log.log("joseluis La actividad se ha destruido")
    }


}