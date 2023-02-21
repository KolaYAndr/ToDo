package com.example.todo

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_login.loginEditText
import kotlinx.android.synthetic.main.fragment_login.passwordEditText
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment(R.layout.fragment_register) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginEditText.addTextChangedListener {
            buttonTextWatcher
        }

        passwordEditText.addTextChangedListener {
            buttonTextWatcher
        }

        nameEditText.addTextChangedListener {
            buttonTextWatcher
        }

        registerButton.setOnClickListener { (activity as FragmentDelivery).receive(-1) }
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
            registerButton.isEnabled =
                passwordEditText.text.isNotBlank() && loginEditText.text.isNotBlank() && nameEditText.text.isNotBlank()
        }
    }
}