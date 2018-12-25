package codenevisha.com.cleanarchitecture.ui

import android.os.Bundle
import codenevisha.com.cleanarchitecture.R
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
