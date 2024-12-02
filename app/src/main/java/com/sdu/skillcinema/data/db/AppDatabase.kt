package com.sdu.skillcinema.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sdu.skillcinema.data.entities.WatchedMovie
import com.sdu.skillcinema.domain.dao.WatchedMovieDao

@Database(
    entities = [WatchedMovie::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun visitHistoryDao(): WatchedMovieDao
}
