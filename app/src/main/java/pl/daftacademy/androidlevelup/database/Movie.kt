package pl.daftacademy.androidlevelup.database

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import pl.daftacademy.androidlevelup.entity.Movie as EntityMovie

@Entity(
    foreignKeys = [
        ForeignKey(entity = Studio::class, parentColumns = ["id"], childColumns = ["studioId"])
    ]
)
class Movie(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val year: Int,
    val genres: String,
    val studioId: Int
) {
    //added studio name
    fun toEntity() = EntityMovie(title, year, genres.split(','), MovieDatabase.INSTANCE.studios().getById(studioId)?.name ?: "ERROR: NO STUDIO")

    companion object {
        //added studio id
        fun fromEntity(entity: EntityMovie) = Movie(0, entity.title, entity.year, entity.genres.joinToString(","), MovieDatabase.INSTANCE.studios().getByName(entity.studio!!)?.id!!)
    }
}
