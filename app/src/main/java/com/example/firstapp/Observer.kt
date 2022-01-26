package com.example.firstapp

import android.os.Parcel
import android.os.Parcelable
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import com.google.android.material.snackbar.Snackbar

class Observer() : LifecycleObserver {

    constructor(parcel: Parcel) : this() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun myFun(source: LifecycleOwner, event: Lifecycle.Event)
    {

    }
}