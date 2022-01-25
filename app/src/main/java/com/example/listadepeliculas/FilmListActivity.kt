package com.example.listadepeliculas

import CasoDeUsos.CasoDeUso
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.listadepeliculas.databinding.ActivityMainBinding
import com.example.listadepeliculas.databinding.FilmListBinding

import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FilmListActivity : AppCompatActivity() {
   private lateinit var binding: FilmListBinding
   private val viewModel: FilmListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            binding = FilmListBinding.inflate(layoutInflater)
            setContentView(binding.root)
        }

    }


