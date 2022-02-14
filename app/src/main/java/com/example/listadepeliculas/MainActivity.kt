package com.example.listadepeliculas

import android.os.Bundle

import androidx.fragment.app.FragmentActivity
import com.example.listadepeliculas.databinding.MainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = MainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.list, FilmListFragment())
            .commit()
    }

    override fun openDetails(id: Int) {
        val fragment = FilmFragment()
        fragment.arguments = Bundle().apply {
            putInt(FilmFragment.FILM_ID, id)
        }
        supportFragmentManager.beginTransaction()
            .add(R.id.list, fragment)
            .addToBackStack("BACKSTACK")
            .commit()
    }
}