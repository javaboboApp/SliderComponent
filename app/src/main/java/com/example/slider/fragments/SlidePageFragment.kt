package com.example.slider.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment

abstract class SlidePageFragment :Fragment() {

    private val TAG_ANIMATED = "TAG_ANIMATED"
    private var hasBeenAnimated = false

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        savedInstanceState?.let { bundle ->
            hasBeenAnimated = bundle.getBoolean(TAG_ANIMATED)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(TAG_ANIMATED, hasBeenAnimated)
    }

    override fun onResume() {


        if (!hasBeenAnimated) {
            hasBeenAnimated = true
            startAnimation()
        }
        super.onResume()

    }

    abstract fun startAnimation()
}