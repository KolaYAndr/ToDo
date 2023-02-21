package com.example.todo

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.todo.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginEditText.addTextChangedListener {
            buttonTextWatcher
        }

        binding.passwordEditText.addTextChangedListener {
            buttonTextWatcher
        }

        binding.nameEditText.addTextChangedListener {
            buttonTextWatcher
        }

        binding.registerButton.setOnClickListener { (activity as FragmentDelivery).receive(-1) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private val buttonTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(
            s: CharSequence?,
            start: Int,
            count: Int,
            after: Int
        ) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        override fun afterTextChanged(s: Editable?) {
            binding.registerButton.isEnabled =
                binding.passwordEditText.text.isNotBlank() && binding.loginEditText.text.isNotBlank() && binding.nameEditText.text.isNotBlank()
        }
    }
}