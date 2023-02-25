package com.example.todo

interface FragmentDelivery {
    fun receive(marker: Int)
    fun receiveTask(task: Task)
}