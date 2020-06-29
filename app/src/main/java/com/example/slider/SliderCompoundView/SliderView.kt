package com.example.slider.SliderCompoundView

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.slider.R
import com.example.slider.SliderCompoundView.SliderView.TRANSFORMATIONS.*
import com.example.slider.SliderCompoundView.transformations.SliderDepthPageTransformer
import com.example.slider.SliderCompoundView.transformations.SliderZoomOutPageTransformer

class SliderView : FrameLayout, ViewPager.OnPageChangeListener {

    enum class TRANSFORMATIONS { SLIDER_ZOOM_TRANSFORMATION, SLIDER_DEPTH_TRANSFORMATION }

    //attrs
    var title: String
        get() = titleTextView.text.toString()
        set(value) {
            if (this::titleTextView.isInitialized)
                titleTextView.text = value
        }

    var description: String
        get() = descriptionTextView.text.toString()
        set(value) {
            if (this::descriptionTextView.isInitialized)
                descriptionTextView.text = value
        }

    var backgroundInfo: String
        get() = backgroundTextView.text.toString()
        set(value) {
            if (this::backgroundTextView.isInitialized)
                backgroundTextView.text = value
        }

    //Views
    private lateinit var mViewPager: ViewPager
    private lateinit var titleTextView: TextView
    private lateinit var descriptionTextView: TextView
    private lateinit var backgroundTextView: TextView
    private lateinit var pageNumberTextView: TextView



    //PageAdapter


    var adapter: PagerAdapter? = null
        set(value) {
            mViewPager.addOnPageChangeListener(this)
            mViewPager.adapter = value

        }

    constructor(context: Context) : super(context) {
        initMainGroupViews(context)
        initViews()
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        initMainGroupViews(context)
        initAttributes(context, attributeSet)
        initViews()
        setUpViews()
    }

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    ) {
        initMainGroupViews(context)
        initAttributes(context, attributeSet)
        initViews()
        setUpViews()
    }


    private fun initMainGroupViews(context: Context) {
        val layoutInflater: LayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        layoutInflater.inflate(R.layout.view_pager_slider, this, true)
    }

    private fun initAttributes(context: Context, attributeSet: AttributeSet) {
        val tArray = context.obtainStyledAttributes(attributeSet, R.styleable.SliderCompoundView)
        title = tArray.getString(R.styleable.SliderCompoundView_title) ?: ""
        description = tArray.getString(R.styleable.SliderCompoundView_description) ?: ""
        backgroundInfo = tArray.getString(R.styleable.SliderCompoundView_bacground_text) ?: ""
    }

    private fun initViews() {
        titleTextView = findViewById(R.id.title_textview)
        descriptionTextView = findViewById(R.id.description_textview)
        backgroundTextView = findViewById(R.id.background_text_textview)
        mViewPager = findViewById(R.id.viewPager)
        pageNumberTextView = findViewById(R.id.pageNumber)
        onPageSelected(0)

    }

    private fun setUpViews() {
        titleTextView.text = title
        descriptionTextView.text = description
        backgroundTextView.text = backgroundInfo
    }

    fun applyTransformation(transformation: TRANSFORMATIONS) {
        //todo example we could have our own transformations....
        when (transformation) {
            SLIDER_ZOOM_TRANSFORMATION -> mViewPager.setPageTransformer(
                true,
                SliderZoomOutPageTransformer()
            )
            SLIDER_DEPTH_TRANSFORMATION -> mViewPager.setPageTransformer(
                true,
                SliderDepthPageTransformer()
            )
        }

    }


    override fun onDetachedFromWindow(){
        super.onDetachedFromWindow()
        //avoid memory leaks...
        mViewPager.removeOnPageChangeListener(this)

    }
    fun setTitleColor(restId: Int) {
        titleTextView.setTextColor(restId)
    }


    fun setDescriptionColor(restId: Int) {
        descriptionTextView.setTextColor(restId)
    }

    fun setBackgroundInfoColor(restId: Int) {
        backgroundTextView.setTextColor(restId)
    }

    fun setPageNumberColorText(restId: Int){
        pageNumberTextView.setTextColor(restId)
    }

    fun setPageNumberBackgroundColor(restId: Int){
        pageNumberTextView.setBackgroundColor(restId)
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {
          pageNumberTextView.text = (position+1).toString()
    }


}