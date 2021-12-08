package com.ssynhtn.startactivityforresultbug

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ssynhtn.startactivityforresultbug.databinding.ActivityStartOrderBinding

class StartOrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityStartOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(R.id.container, StartOrderFragment()).commit()
        }
    }
}