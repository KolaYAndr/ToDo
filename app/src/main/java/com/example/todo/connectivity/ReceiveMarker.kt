package com.example.todo.connectivity

import com.example.todo.database.Task

interface ReceiveMarker {
    fun receive(marker: Int)
}