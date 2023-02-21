package com.example.todo

import android.os.Bundle
import android.view.KeyEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), FragmentDelivery {
    private var isLoggedIn = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
            -1 -> isLoggedIn = true
            0 -> showFragment(LoginFragment())
            1 -> showFragment(RegisterFragment())
            else -> Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }
    }
}