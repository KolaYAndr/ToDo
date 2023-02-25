package com.example.todo.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.todo.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface DAO {
    @Insert
    fun insertTask(task: Task)

    @Query("SELECT * FROM task")
    fun getAllTasks(): Flow<List<Task>>
}