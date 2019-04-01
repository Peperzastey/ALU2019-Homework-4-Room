package pl.daftacademy.androidlevelup.view.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import pl.daftacademy.androidlevelup.database.MovieDatabase
import pl.daftacademy.androidlevelup.database.Studio
import pl.daftacademy.androidlevelup.entity.Movie
import pl.daftacademy.androidlevelup.entity.Movies

class AddViewModel(private val movies: Movies) : ViewModel() {

    fun addMovie(title: String, year: String, genres: List<String>, studio: String) {
        Log.d("[psz]AddViewModel", "year: String = $year, studio: String = $studio")

        val studioDao = MovieDatabase.INSTANCE.studios()
        val studioEntity = studioDao.getByName(studio)
        if (studioEntity == null)
            studioDao.add(Studio(0, studio))

        val newMovie = Movie(title, year.toInt(), genres, studio)
        movies.add(listOf(newMovie))
    }
}
