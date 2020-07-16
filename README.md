# SliderComponent


## Objective
Simple library that allow us to set up a view pager using animation


## Examples
[code]
val fragmentList =
            listOf(ScreenOneSlidePageFragment(), ScreenTwoSlidePageFragment())
        val pagerAdapter = ScreenSlidePagerAdapter(supportFragmentManager, fragmentList)
        slider_view.adapter = pagerAdapter
        slider_view.applyTransformation(SLIDER_DEPTH_TRANSFORMATION)
[/code]

### How to use
Just clone the project and create a new module with the library.
