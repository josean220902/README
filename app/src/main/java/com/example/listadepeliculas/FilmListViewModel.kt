package com.example.listadepeliculas

import CasoDeUsoListaPeliculas.GetFilmsUseCase
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.Pelicula
import kotlinx.coroutines.*
import java.util.*
import javax.inject.Inject

class FilmListViewModel @Inject constructor(
    private val useCase: GetFilmsUseCase
) : ViewModel(), LifecycleObserver{
    private val filmsLiveData = MutableLiveData<List<FilmOverviewDataView>>()
    val films: LiveData<List<FilmOverviewDataView>> = filmsLiveData
    var job: Job? = null
    fun loadFilms(){
        val language= Locale.getDefault().language
        job = CoroutineScope(Dispatchers.IO).launch {
            val loadedFilms= useCase.execute(language)
            withContext(Dispatchers.Main){
                loadedFilms?.let{
                    filmsLiveData.value = it.map { film -> FilmOverviewDataView(film.id, film.url) }
                }
            }
        }
    }
}
