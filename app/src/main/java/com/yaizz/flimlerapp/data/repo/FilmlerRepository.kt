package com.yaizz.flimlerapp.data.repo

import com.yaizz.flimlerapp.data.datasource.FilmlerDataSource
import com.yaizz.flimlerapp.data.entitiy.Filmler
import kotlinx.coroutines.CoroutineScope

class FilmlerRepository {
    var fds = FilmlerDataSource()

    suspend fun filmleriYukle() : List<Filmler> = fds.filmleriYukle()
}