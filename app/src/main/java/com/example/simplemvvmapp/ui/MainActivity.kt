package com.example.simplemvvmapp.ui

import android.os.Bundle
import androidx.fragment.app.commit
import com.example.simplemvvmapp.R
import com.example.simplemvvmapp.ui.home.HomeFragment
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.commit {
            replace(R.id.fragment_container, HomeFragment.newInstance())
        }
    }
}