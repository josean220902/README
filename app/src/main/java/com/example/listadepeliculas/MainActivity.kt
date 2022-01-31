package com.example.listadepeliculas

import CasoDeUsos.CasoDeUso
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.domain.Pelicula
import com.example.listadepeliculas.databinding.ActivityMainBinding

import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var log: MyLog

    @Inject
    lateinit var usecase: CasoDeUso
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.loadFilm()
        viewModel.pelicula.observe(this) {

            binding.rating.rating = it.rating.toFloat()
            binding.title.text = it.title
            binding.description.text = it.title
            binding.director.text = it.title
            Glide.with(this).load(it.imageUrl).into(binding.imageView10)

        }
        log.log("joseluis la actividad se ha creado")
        

    }

    private val viewModel: MainViewModel by viewModels()

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
        binding.title.text = "joseluis Empieza el estado foreground"
        binding.imageView.setImageResource(R.drawable.ic_bookmark)
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