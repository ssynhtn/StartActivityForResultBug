package com.ssynhtn.startactivityforresultbug

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ssynhtn.startactivityforresultbug.databinding.ActivityHandlerOrderBinding

class HandleOrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityHandlerOrderBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        when (intent.action) {
            ACTION_HANDLE_INT -> {
                val input = intent.getIntExtra(EXTRA_INT, -1)
                val result = input * input
                binding.btnBack.text = "$input * $input => $result"
                binding.btnBack.setOnClickListener {
                    setResult(RESULT_OK, Intent().putExtra(EXTRA_INT, result))
                    finish()
                }

            }
            ACTION_HANDLE_STRING -> {
                val input = intent.getStringExtra(EXTRA_STRING) ?: ""
                val result = input.uppercase()
                binding.btnBack.text = "${input}.uppercase() => $result"
                binding.btnBack.setOnClickListener {
                    setResult(RESULT_OK, Intent().putExtra(EXTRA_STRING, result))
                    finish()
                }

            }
            else -> {
                binding.btnBack.setOnClickListener {
                    finish()
                }
            }
        }

    }

    companion object {
        const val ACTION_HANDLE_INT = "ACTION_GET_INT"
        const val ACTION_HANDLE_STRING = "ACTION_GET_STRING"

        const val EXTRA_INT = "int"
        const val EXTRA_STRING = "string"


        fun createIntent(context: Context, input: Int): Intent {
            return Intent(context, HandleOrderActivity::class.java).apply {
                action = ACTION_HANDLE_INT
                putExtra(EXTRA_INT, input)
            }
        }

        fun createIntent(context: Context, input: String): Intent {
            return Intent(context, HandleOrderActivity::class.java).apply {
                action = ACTION_HANDLE_STRING
                putExtra(EXTRA_STRING, input)
            }
        }
    }
}