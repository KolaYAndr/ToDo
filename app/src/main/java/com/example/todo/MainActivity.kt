package com.example.todo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.asLiveData
import com.example.todo.connectivity.ReceiveMarker
import com.example.todo.connectivity.ReceiveTask
import com.example.todo.database.MainDb
import com.example.todo.database.Task
import com.example.todo.databinding.ActivityMainBinding
import com.example.todo.fragments.*

class MainActivity : AppCompatActivity(), ReceiveMarker, ReceiveTask {
    private val taskAdapter = TaskAdapter()
    private lateinit var db: MainDb
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.hide()

        db = MainDb.getDb(this@MainActivity)
        getTasksAndSet()

        showFragment(GreetingFragment())
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }


    override fun receive(marker: Int) {
        when (marker) {
            -1 -> showFragment(TasksFragment(taskAdapter))
            0 -> showFragment(LoginFragment())
            1 -> showFragment(RegisterFragment())
            2 -> showFragment(TaskCreationFragment())
            else -> Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }
    }

    override fun receiveTask(task: Task) {
        Thread { db.getDAO().insertTask(task) }.start() //поменять через корутину
        taskAdapter.addTask(task)
        showFragment(TasksFragment(taskAdapter))
    }

    private fun getTasksAndSet(){
        db.getDAO().getAllTasks().asLiveData().observe(this) {
            taskAdapter.setTasks(it)
        }
    }
}