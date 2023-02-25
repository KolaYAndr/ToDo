package com.example.todo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.todo.FragmentDelivery
import com.example.todo.R
import com.example.todo.databinding.FragmentGreetingBinding

class GreetingFragment : Fragment(R.layout.fragment_greeting) {
    private var _binding: FragmentGreetingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGreetingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.logInButton.setOnClickListener {
            (activity as FragmentDelivery).receive(0)
        }
        binding.registerButton.setOnClickListener {
            (activity as FragmentDelivery).receive(1)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}