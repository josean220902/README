package com.example.listadepeliculas

import CasoDeUsos.CasoDeUso
import android.icu.text.CaseMap
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.domain.Pelicula
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.FileDescriptor
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
private val useCase: CasoDeUso
): ViewModel(), LifecycleObserver{
    private val filmLiveData = MutableLiveData<FilmDataView>()
    val pelicula: LiveData<FilmDataView> =filmLiveData

    fun loadFilm(){
        val loadedFilm = Locale.getDefault().language

    }


}
data class  FilmDataView(val title: String, val description: String,val rating: String,val director: String, val text: String, val imageUrl: String)
