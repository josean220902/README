package com.example.listadepeliculas

import CasoDeUsos.CasoDeUso
import android.icu.text.CaseMap
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.domain.Pelicula
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import java.io.FileDescriptor
import java.util.*
import javax.inject.Inject

@HiltViewModel
class FilmViewModel @Inject constructor(
    private val useCase: CasoDeUso
): ViewModel(), LifecycleObserver{
    private val filmLiveData = MutableLiveData<FilmDataView>()
    val pelicula: LiveData<FilmDataView> =filmLiveData


    var job: Job? = null

    fun loadFilm(){
        job = CoroutineScope(Dispatchers.IO).launch{
            val language = Locale.getDefault().language
            val loadedFilm=useCase.execute(600,language)

            withContext(Dispatchers.Main){
                loadedFilm?.let {

                    filmLiveData.value = FilmDataView(
                        it.tittle,
                        it.description,
                        it.rating,
                        it.director ?: "",
                        it.url
                    )
                }
            }
        }

    }
    override fun onCleared(){
        super.onCleared()
        job?.cancel()
    }

}

data class  FilmDataView(val title: String, val description: String,val rating: Double,val director: String, val imageUrl: String)
