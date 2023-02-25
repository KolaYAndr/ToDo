package com.example.todo.connectivity

import com.example.todo.database.Task

interface ReceiveTask {
    fun receiveTask(task: Task)
}