package com.example.todo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo.connectivity.ReceiveMarker
import com.example.todo.R
import com.example.todo.TaskAdapter
import com.example.todo.databinding.FragmentTasksBinding

class TasksFragment(private val taskAdapter: TaskAdapter) : Fragment(R.layout.fragment_tasks) {
    private var _binding: FragmentTasksBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTasksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.recyclerView){
            adapter = taskAdapter
            layoutManager = LinearLayoutManager(requireActivity())
            setHasFixedSize(true)
        }

        binding.addFAB.setOnClickListener {
            (activity as ReceiveMarker).receive(2)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}