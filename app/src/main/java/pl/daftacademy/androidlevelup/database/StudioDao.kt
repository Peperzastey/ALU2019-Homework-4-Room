package pl.daftacademy.androidlevelup.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudioDao {

    @Insert
    fun add(studio: Studio): Long

    @Query("SELECT * FROM studio WHERE name = :name LIMIT 1")
    fun getByName(name: String): Studio?

    @Query("SELECT * FROM studio WHERE id = :id LIMIT 1")
    fun getById(id: Int): Studio?
}