package com.pharosproduction.androidnestedrecycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.pharosproduction.androidnestedrecycler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Variables

    private lateinit var mModel: MainActivityViewModel

    // Life

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            model = mModel
            setLifecycleOwner(this@MainActivity)
            lifecycle.addObserver(mModel)
        }
    }
}
