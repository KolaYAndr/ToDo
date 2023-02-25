package com.example.todo.database

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room

@Database(entities = [Task::class], version = 1)
abstract class MainDb : RoomDatabase() {
    abstract fun getDAO() : DAO

    companion object{
        fun getDb(context: Context) : MainDb {
            return Room.databaseBuilder(
                context.applicationContext,
                MainDb::class.java, "tasks.db"
            ).build()
        }
    }
}