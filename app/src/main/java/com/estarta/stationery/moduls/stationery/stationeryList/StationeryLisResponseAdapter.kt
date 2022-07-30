package com.estarta.stationery.moduls.stationery.stationeryList

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.smarteist.autoimageslider.SliderView
import com.estarta.stationery.R
import com.estarta.stationery.component.SliderAdapter
import com.estarta.stationery.databinding.ItemStationeryListFragmentBinding
import com.estarta.stationery.moduls.stationery.stationeryDescription.StationeryDescriptionFragment





class StationeryLisResponseAdapter(
    var viewModel: StationeryListViewModel,
    var stationeryListFragment: StationeryListFragment
) : RecyclerView.Adapter<StationeryLisViewHolder>()
{
    private lateinit var binding: ItemStationeryListFragmentBinding

    /**
    // on below line we are create
    // a function for our  create data binding
    //
     */

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StationeryLisViewHolder {
        binding = ItemStationeryListFragmentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return StationeryLisViewHolder(binding)
    }

    /**
    // on below line we are add
    // a function for our  add  item
    //
     */

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: StationeryLisViewHolder, position: Int) {
        val stationery = viewModel.stationeryList!![position]
        holder.bind(
            stationery,
            stationeryListFragment
        )
    }


    /**
    // on below line we are return
    // a function for our  return  size list
    //
     */

    override fun getItemCount(): Int = viewModel.stationeryList!!.size
}

class StationeryLisViewHolder(
    private val binding: ItemStationeryListFragmentBinding
) : RecyclerView.ViewHolder(binding.root)
{



    // on below line we are creating
    // a variable for our slider adapter.
    lateinit var sliderAdapter: SliderAdapter


    /**
    // on below line we are view
    // a function for our view item and action
    //
     */

    @RequiresApi(Build.VERSION_CODES.O)
    fun bind(
        stationeryModel: StationeryListModel?,
        stationeryListFragment: StationeryListFragment,
    ) {
        binding.stationeryListModel = stationeryModel

        binding.listener = ClickHandlerStationeryLisResponseAdapter(stationeryListFragment,stationeryModel)


        // on below line we are initializing our
        // slider adapter and adding our list to it.
        sliderAdapter = SliderAdapter( stationeryModel!!.image_urls)

        // on below line we are setting auto cycle direction
        // for our slider view from left to right.
        binding.sliderItemStationeryListFragment.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR

        // on below line we are setting adapter for our slider.
        binding.sliderItemStationeryListFragment.setSliderAdapter(sliderAdapter)

        // on below line we are setting scroll time
        // in seconds for our slider view.
        binding.sliderItemStationeryListFragment.scrollTimeInSec = stationeryModel!!.image_urls.size

        // on below line we are setting auto cycle
        // to true to auto slide our items.
        binding.sliderItemStationeryListFragment.isAutoCycle = true

        // on below line we are calling start
        // auto cycle to start our cycle.
        binding.sliderItemStationeryListFragment.startAutoCycle()


        }


}



/**
// on below line we are action
// a function for our action component (btn_details_item_stationery_list_fragment)
// result : view fragment description
//
 */

class ClickHandlerStationeryLisResponseAdapter(
    var stationeryListFragment: StationeryListFragment,
    var stationeryModel: StationeryListModel?
) {

    /**

    open a new screen to display the details of that listing

     */
    fun onTextViewClick(view: View) {
        stationeryListFragment.addFragment(
            StationeryDescriptionFragment.newInstance(stationeryModel), R.id.fragment_container_stationery, true
        )
//        Navigation.findNavController(view).navigate(R.id.action_stationeryListFragment_to_stationeryDescriptionFragment);

    }
}