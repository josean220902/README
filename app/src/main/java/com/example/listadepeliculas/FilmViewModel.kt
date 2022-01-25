package com.example.listadepeliculas

import CasoDeUsoListaPeliculas.CasoDeUsoListaPeliculas
import CasoDeUsos.CasoDeUso
import android.icu.text.CaseMap
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.domain.Pelicula
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.withContext
import java.io.FileDescriptor
import java.util.*
import javax.inject.Inject

@HiltViewModel
class FilmListViewModel @Inject constructor(
private val useCase: CasoDeUsoListaPeliculas): ViewModel(), LifecycleObserver{

var job: Job? = null
override fun onCleared(){
    super.onCleared()
    job?.cancel()
}

}

