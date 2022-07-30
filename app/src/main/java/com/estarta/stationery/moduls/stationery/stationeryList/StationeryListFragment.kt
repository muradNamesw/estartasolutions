package com.estarta.stationery.moduls.stationery.stationeryList


import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.estarta.stationery.R
import com.estarta.stationery.base.BaseFragment
import com.estarta.stationery.data.source.remote.Status.*
import com.estarta.stationery.databinding.FragmentStationeryListBinding
import kotlinx.android.synthetic.main.fragment_stationery_list.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class StationeryListFragment : BaseFragment<FragmentStationeryListBinding>() {


/**
// on below line we are creating
// a variable for our StationeryList ViewModel.

 */
    private val viewModel: StationeryListViewModel by sharedViewModel()


    override val layoutRes: Int
        get() =  R.layout.fragment_stationery_list

    override fun initUI(savedInstanceState: Bundle?) {
        getStationeryListModel()
    }

    /**
    // on below line we are return
    // a function return item api
     */
    private fun getStationeryListModel() {
        viewModel.getStationeryListViewModel()
        viewModel.resultStationery.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                LOADING -> {
//                    viewModel.loading(true)
                    showDialog()

                }
                SUCCESS -> {
                    hideDialog()
                    if (viewModel.validateNullOrEmpty(it)) {
                        viewModel.stationeryList = it.data!!.results
                        updateRecycleStationary()
                        dataBinding.stationeryViewModel = viewModel
                    }
                }
                ERROR -> {
                    hideDialog()
                    showMessagDialog(it.message.toString())
//                    System.err.println()
                }
                EMPTY -> TODO()
            }
        })
    }

//
    /**
    // on below line we are create and add
    // a function create recycle view and  add item (Stationery)
     */
    private fun updateRecycleStationary() {
        val newsAdapter = StationeryLisResponseAdapter(
           viewModel,
            this@StationeryListFragment
        )

        recycler_view_stationery_list.adapter = newsAdapter
        recycler_view_stationery_list.layoutManager = LinearLayoutManager(requireContext())
        recycler_view_stationery_list.setHasFixedSize(true)
    }

}