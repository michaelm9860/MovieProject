package com.example.finalproject.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.finalproject.data.dao.MovieDao
import com.example.finalproject.data.models.Genre
import com.example.finalproject.data.models.Movie

private const val DB_NAME = "MovieDatabase"
private const val DB_VERSION = 3

@Database(version = DB_VERSION, entities = [Movie::class, Genre::class])
abstract class AppDatabase : RoomDatabase() {
    //expose the dao
    abstract fun movieDao(): MovieDao

    companion object {
        fun create(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                DB_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}