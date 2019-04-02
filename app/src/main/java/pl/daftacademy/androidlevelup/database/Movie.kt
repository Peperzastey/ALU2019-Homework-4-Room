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

    companion object {

        fun fromEntity(entity: EntityMovie, studioId: Int) = Movie(0, entity.title, entity.year, entity.genres.joinToString(","), studioId)
    }
}
