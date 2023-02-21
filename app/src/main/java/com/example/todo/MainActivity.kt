package com.example.todo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.todo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), FragmentDelivery {
    private var isLoggedIn = false
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (!isLoggedIn) {
            showFragment(GreetingFragment())
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commitNow()
    }


    override fun receive(marker: Int) {
        when (marker) {
            -1 -> {
                isLoggedIn = true
                showFragment(TasksFragment())
            }
            0 -> showFragment(LoginFragment())
            1 -> showFragment(RegisterFragment())
            else -> Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }
    }
}