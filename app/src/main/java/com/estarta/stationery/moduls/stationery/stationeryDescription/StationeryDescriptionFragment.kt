package com.estarta.stationery.moduls.stationery.stationeryDescription

import android.os.Bundle
import com.smarteist.autoimageslider.SliderView
import com.estarta.stationery.R
import com.estarta.stationery.base.BaseFragment
import com.estarta.stationery.component.SliderAdapter
import com.estarta.stationery.databinding.FragmentStationeryDescriptionBinding
import com.estarta.stationery.moduls.stationery.stationeryList.StationeryListModel
import com.estarta.stationery.utils.Constants
import kotlinx.android.synthetic.main.fragment_stationery_description.*




/**

the  screen to display the details of that listing

 */

class StationeryDescriptionFragment :  BaseFragment<FragmentStationeryDescriptionBinding>() {



    companion object {

        @JvmStatic
        fun newInstance( stationeryList: StationeryListModel?) = StationeryDescriptionFragment().apply {
            arguments = Bundle().apply {
                putStringArrayList(Constants.SLIDE_STATIONERY_DESCRIPTION_FRAGMENT, stationeryList!!.image_urls_thumbnails)
            }
        }
    }

    // on below line we are creating
    // a variable for our slider adapter.
    lateinit var sliderAdapter: SliderAdapter
    lateinit var imageUrlDescription: ArrayList<String>
    override val layoutRes: Int
        get() = R.layout.fragment_stationery_description

    override fun initUI(savedInstanceState: Bundle?) {
        System.err.print("")
        // on below line we are initializing our
        // slider adapter and adding our list to it.
        arguments?.getStringArrayList(Constants.SLIDE_STATIONERY_DESCRIPTION_FRAGMENT)?.let {
            imageUrlDescription = it
        }
        sliderAdapter = SliderAdapter( imageUrlDescription)

        // on below line we are setting auto cycle direction
        // for our slider view from left to right.
        slider_item_stationery_description_fragment.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR

        // on below line we are setting adapter for our slider.
        slider_item_stationery_description_fragment.setSliderAdapter(sliderAdapter)

        // on below line we are setting scroll time
        // in seconds for our slider view.
        slider_item_stationery_description_fragment.scrollTimeInSec = imageUrlDescription.size

        // on below line we are setting auto cycle
        // to true to auto slide our items.
        slider_item_stationery_description_fragment.isAutoCycle = true

        // on below line we are calling start
        // auto cycle to start our cycle.
        slider_item_stationery_description_fragment.startAutoCycle()
    }



}