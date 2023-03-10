package com.example.todo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.todo.connectivity.ReceiveMarker
import com.example.todo.R
import com.example.todo.connectivity.ReceiveTask
import com.example.todo.database.Task
import com.example.todo.databinding.FragmentTaskCreationBinding

class TaskCreationFragment : Fragment(R.layout.fragment_task_creation) {
    private var _binding: FragmentTaskCreationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTaskCreationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveButton.setOnClickListener {
            val taskText = binding.taskCreationText.text
            val task = Task(null, taskText.toString())
            (activity as ReceiveTask).receiveTask(task)
        }

        binding.cancelButton.setOnClickListener {
            (activity as ReceiveMarker).receive(-1)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}