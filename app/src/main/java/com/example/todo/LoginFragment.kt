package com.example.todo

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginEditText.addTextChangedListener {
            buttonTextWatcher
        }

        passwordEditText.addTextChangedListener {
            buttonTextWatcher
        }

        loginButton.setOnClickListener { (activity as FragmentDelivery).receive(-1) }
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
            loginButton.isEnabled =
                passwordEditText.text.isNotEmpty() && loginEditText.text.isNotEmpty()
        }
    }
}