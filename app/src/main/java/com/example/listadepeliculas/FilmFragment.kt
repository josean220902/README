package com.example.listadepeliculas

import CasoDeUsos.CasoDeUso
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide

import com.example.listadepeliculas.databinding.ActivityMainBinding

import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FilmFragment : Fragment() {
    companion object {
        const val FILM_ID = "ID"
    }

    @Inject
    lateinit var log: MyLog

    @Inject
    lateinit var usecase: CasoDeUso
    private lateinit var binding: ActivityMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityMainBinding.inflate(layoutInflater)


        val id = arguments?.getInt(FILM_ID) ?: 512195
        viewModel.loadFilm(id)


        viewModel.pelicula.observe(this) {

            binding.rating.rating = it.rating.toFloat()
            binding.title.text = it.title
            binding.description.text = it.title
            binding.director.text = it.title
            Glide.with(this).load(it.imageUrl).into(binding.imageView)
            if (it.videoId == null) {
                binding.buttonRent.visibility = View.GONE


            } else {
                binding.buttonRent.visibility = View.VISIBLE
                binding.buttonRent.setOnClickListener { _ ->
                    launchYoutube(it.videoId)
                }
            }

        }


        return binding.root

    }



    private fun launchYoutube(id: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?=$id"))
        startActivity(intent)
    }

    private val viewModel: FilmViewModel by viewModels()

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