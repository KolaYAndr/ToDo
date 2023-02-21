package com.example.todo

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_greeting.*

class GreetingFragment : Fragment(R.layout.fragment_greeting) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logInButton.setOnClickListener {
            (activity as FragmentDelivery).receive(0)
        }
        registerButton.setOnClickListener {
            (activity as FragmentDelivery).receive(1)
        }
    }

}