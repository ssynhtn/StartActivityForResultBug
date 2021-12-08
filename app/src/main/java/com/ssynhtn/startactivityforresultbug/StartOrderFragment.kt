package com.ssynhtn.startactivityforresultbug

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ssynhtn.startactivityforresultbug.databinding.FragStartOrderBinding

/**
 * @author aaron.huang
 * @date 2021/11/24
 */
class StartOrderFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragStartOrderBinding.inflate(inflater, container, false).also {
            it.btnStartForResult.text = "handle 9 & hello"
            it.btnStartForResult.setOnClickListener {
                startActivityForResult(HandleOrderActivity.createIntent(requireContext(), 9), REQ_INT)
                startActivityForResult(HandleOrderActivity.createIntent(requireContext(), "hello"), REQ_STRING)
            }
        }.root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && data != null) {
            when (requestCode) {
                REQ_INT -> {
                    val result = data.getIntExtra(HandleOrderActivity.EXTRA_INT, -1)
                    Log.d(TAG, "int result $result")
                    Toast.makeText(requireContext(), "int result $result", Toast.LENGTH_SHORT).show()
                }
                REQ_STRING -> {
                    val result = data.getStringExtra(HandleOrderActivity.EXTRA_STRING)
                    Log.d(TAG, "string result $result")
                    Toast.makeText(requireContext(), "string result $result", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    // do nothing
                }
            }
        }
    }

    companion object {
        const val TAG = "StartOrderFragment"
        const val REQ_INT = 100
        const val REQ_STRING = 500
    }
}