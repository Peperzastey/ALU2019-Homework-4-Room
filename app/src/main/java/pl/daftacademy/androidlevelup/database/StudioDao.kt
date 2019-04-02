package pl.daftacademy.androidlevelup.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudioDao {

    @Insert
    fun add(studio: Studio): Long

    @Query("SELECT id FROM studio WHERE name = :name LIMIT 1")
    fun getIdByName(name: String): Int?
}