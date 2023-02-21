package com.example.todo

import java.time.LocalDateTime

data class Task(var taskText: String, var deadline: LocalDateTime, var isDone: Boolean)
