package com.example.slider

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.slider.SliderCompoundView.SliderView.TRANSFORMATIONS.SLIDER_DEPTH_TRANSFORMATION
import com.example.slider.SliderCompoundView.SliderView.TRANSFORMATIONS.SLIDER_ZOOM_TRANSFORMATION
import com.example.slider.fragments.ScreenOneSlidePageFragment
import com.example.slider.fragments.ScreenTwoSlidePageFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        slider_view.setTitleColor(Color.WHITE)
        slider_view.setDescriptionColor(Color.RED)
        slider_view.setPageNumberBackgroundColor(Color.BLACK)
        slider_view.setPageNumberColorText(Color.WHITE)

        slider_view.title = getString(R.string.welcome_slider_title)
        slider_view.description = getString(R.string.description_slider)
        slider_view.backgroundInfo = getString(R.string.background_slider)



        val fragmentList =
            listOf(ScreenOneSlidePageFragment(), ScreenTwoSlidePageFragment())
        val pagerAdapter = ScreenSlidePagerAdapter(supportFragmentManager, fragmentList)
        slider_view.adapter = pagerAdapter
        slider_view.applyTransformation(SLIDER_DEPTH_TRANSFORMATION)
    }
}

/**
 * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
 * sequence.
 */
private class ScreenSlidePagerAdapter(fm: FragmentManager, val fragments: List<Fragment>) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int = fragments.size

    override fun getItem(position: Int): Fragment = fragments[position]


}
