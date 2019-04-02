package pl.daftacademy.androidlevelup.database

import androidx.room.Embedded
import androidx.room.Relation
import pl.daftacademy.androidlevelup.entity.Movie as EntityMovie

data class MovieWithStudio(
    @Embedded var movie: Movie
) {
    @Relation(parentColumn = "studioId", entityColumn = "id", entity = Studio::class, projection = ["name"])
    lateinit var studioNames: List<String>  //TODO? MutableList

    fun toEntity() = EntityMovie(movie.title, movie.year, movie.genres.split(','), studioNames.getOrNull(0))
}