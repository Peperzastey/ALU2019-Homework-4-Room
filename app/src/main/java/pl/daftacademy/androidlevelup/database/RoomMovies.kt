package pl.daftacademy.androidlevelup.database

import pl.daftacademy.androidlevelup.entity.Movie
import pl.daftacademy.androidlevelup.entity.Movies
import pl.daftacademy.androidlevelup.database.Movie as DbMovie

class RoomMovies(
        private val movieDao: MovieDao,
        private val studioDao: StudioDao = MovieDatabase.INSTANCE.studios()
) : Movies {

    override fun add(movies: Collection<Movie>) = movieDao.add(movies.map { DbMovie.fromEntity(it, getStudioIdByName(it.studio)) })

    override fun get(): List<Movie> = movieDao.get().map(MovieWithStudio::toEntity)

    private fun getStudioIdByName(studioName: String?): Int {
        if (studioName == null)
            throw IllegalArgumentException("A studio name must be provided for a new movie entry")
        val studioId = studioDao.getIdByName(studioName)
        return studioId ?: studioDao.add(Studio(0, studioName)).toInt()
    }
}
