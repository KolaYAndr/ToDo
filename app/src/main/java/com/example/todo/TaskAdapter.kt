package com.example.todo

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter : RecyclerView.Adapter<TaskAdapter.TaskHolder>() {
    private var tasks: List<Task> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {
        return TaskHolder(parent.inflate(R.layout.item_task))
    }

    override fun onBindViewHolder(holder: TaskHolder, position: Int) {
        val task = tasks[position]
        holder.bind(task)
    }

    fun addTask(newTask: Task){
        tasks = listOf(newTask) + tasks
        notifyItemInserted(0)
    }

    override fun getItemCount(): Int = tasks.size

    class TaskHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val taskTextView = view.findViewById<TextView>(R.id.taskNameTextView)

        fun bind(task: Task){
            taskTextView.text = task.taskText
        }
    }
}