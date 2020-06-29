package com.example.slider.fragments

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.example.slider.R
import kotlinx.android.synthetic.main.fragment_screen_one_slide_page.*

class ScreenOneSlidePageFragment : SlidePageFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_screen_one_slide_page, container, false)

    override fun startAnimation() {
        val fade_in_animation = AnimationUtils.loadAnimation(context, R.anim.fade_in)
        current_page.startAnimation(fade_in_animation)
        current_page.text = getString(R.string.first_text_slide)
    }




}
