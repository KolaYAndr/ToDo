package com.example.todo

import com.example.todo.database.Task

interface FragmentDelivery {
    fun receive(marker: Int)
    fun receiveTask(task: Task)
}