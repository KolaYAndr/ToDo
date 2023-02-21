package com.example.todo

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.todo.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {


    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
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

        binding.loginButton.setOnClickListener { (activity as FragmentDelivery).receive(-1) }
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
            binding.loginButton.isEnabled =
                binding.passwordEditText.text.isNotEmpty() && binding.loginEditText.text.isNotEmpty()
        }
    }
}