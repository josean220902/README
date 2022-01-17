package com.example.listadepeliculas

import CasoDeUsos.CasoDeUso
import android.icu.text.CaseMap
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.domain.Pelicula
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
data class  FilmDataView(val title: String)
class MainViewModel @Inject constructor(
private val useCase: CasoDeUso
): ViewModel(), LifecycleObserver{
    private val filmLiveData = MutableLiveData<FilmDataView>()
    val pelicula: LiveData<FilmDataView> =filmLiveData

    fun loadFilm(){
        val loadedFilm = useCase.execute()
        filmLiveData.value = FilmDataView(loadedFilm.tittle)
    }


}
