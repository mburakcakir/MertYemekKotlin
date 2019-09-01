package com.mburcak.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// image slider library
import com.daimajia.slider.library.Animations.DescriptionAnimation
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.BaseSliderView
import com.daimajia.slider.library.SliderTypes.TextSliderView
import com.mburcak.R
import com.mburcak.di.Constants


class GalleryFragment : Fragment() {

    internal lateinit var galleryView: View
    private var mDemoSlider: SliderLayout? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        galleryView = inflater.inflate(R.layout.fragment_gallery_slider, container, false)
        mDemoSlider = galleryView.findViewById(R.id.slider)

        for (i in 0 until Constants.galleryImagesList.size) {
            addDemoSlider(i)
        }

        mDemoSlider!!.setPresetTransformer(SliderLayout.Transformer.Accordion)
        mDemoSlider!!.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom)
        mDemoSlider!!.setCustomAnimation(DescriptionAnimation())
        mDemoSlider!!.setDuration(2500)
        return galleryView
    }

    override fun onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider!!.stopAutoCycle()
        super.onStop()
    }

    internal fun addDemoSlider(i: Int) {
        val textSliderView = TextSliderView(context)
        // initialize a SliderLayout
        textSliderView
            .description(i.toString() + "")
            .image(Constants.galleryImagesList.get(i))
            .setScaleType(BaseSliderView.ScaleType.Fit)


        //add your extra information
        textSliderView.bundle(Bundle())
        textSliderView.bundle.putString("extra", i.toString() + "")

        mDemoSlider!!.addSlider(textSliderView)
    }

}
