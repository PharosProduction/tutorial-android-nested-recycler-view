package com.pharosproduction.androidnestedrecycler

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import com.pharosproduction.androidnestedrecycler.adapter.ParentAdapter

class MainActivityViewModel : ViewModel(), LifecycleObserver {

    // Variables

    private val repository = Repository
    var adapter = ParentAdapter()

    // Lifecycle

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        adapter.setOnClickListener(object : RvOnClickListener {
            override fun onItmClick(parentPosition: Int, nestedPosition: Int?) {
                Log.d("POSITION", "parent position - $parentPosition, nested position -  $nestedPosition")
            }

        })
        adapter.setData(dataList = repository.mok)
    }
}