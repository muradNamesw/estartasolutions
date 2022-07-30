package com.estarta.stationery.base

import android.app.Activity
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.estarta.stationery.R
//import com.spm.cadence.moduls.MainViewModel

//import com.spm.cadence.utils.sunmi_utils.SunmiPrintHelper
import com.telpo.tps550.api.TelpoException
import com.telpo.tps550.api.printer.BlackBlockNotFoundException
import com.telpo.tps550.api.printer.LowPowerException
import com.telpo.tps550.api.printer.NoPaperException
import com.telpo.tps550.api.printer.OverHeatException
import java.lang.reflect.InvocationTargetException
import java.text.SimpleDateFormat

abstract class BaseFragment<D : ViewDataBinding> : Fragment() {

    protected lateinit var dataBinding: D

    private val picturePath =
        Environment.getExternalStorageDirectory().absolutePath + "/test.bmp"
    lateinit var simpleDateFormatter: SimpleDateFormat

//    val mainViewModel: MainViewModel by sharedViewModel()
//      val transactionNewDetailViewModel: TransactionNewDetailViewModel by sharedViewModel()

    @get:LayoutRes
    protected abstract val layoutRes: Int


//    fun logoutExpired(message: String?) {
//
//        val dialogBuilder = AlertDialog.Builder(requireActivity())
//        dialogBuilder.setMessage(message)
//        dialogBuilder.setPositiveButton(R.string.yes,
//            DialogInterface.OnClickListener { dialog, whichButton ->
//
//                val pref = PreferenceStorage(activity!!)
//                val intent = Intent(activity!!, LoginOldActivity::class.java)
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
//                activity!!.startActivity(intent)
//                pref.setLoggedin(false)
//                pref.setUserName("")
//                pref.setPassword("")
////        this.clearAllBackStack()
//                activity!!.finish()
//            })
//        val b = dialogBuilder.create()
//        b.show()
//
//
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        mainViewModel.updateAllQuantity()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        dataBinding = DataBindingUtil.inflate(inflater, layoutRes, container, false)

        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myActivity = activity
        initUI(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
    }

    protected abstract fun initUI(savedInstanceState: Bundle?)


    fun <VH : RecyclerView.ViewHolder> setUpRcv(
        rcv: RecyclerView,
        adapter: RecyclerView.Adapter<VH>
    ) {
        rcv.setHasFixedSize(true)
        rcv.layoutManager = LinearLayoutManager(context)
        rcv.adapter = adapter
    }

    fun <VH : RecyclerView.ViewHolder> setUpRcv(
        rcv: RecyclerView, adapter:
        RecyclerView.Adapter<VH>,
        isHasFixedSize: Boolean,
        isNestedScrollingEnabled: Boolean
    ) {
        rcv.setHasFixedSize(isHasFixedSize)
        rcv.layoutManager = LinearLayoutManager(context)
        rcv.adapter = adapter
        rcv.isNestedScrollingEnabled = isNestedScrollingEnabled
    }

    fun <VH : RecyclerView.ViewHolder> setUpRcv(
        rcv: RecyclerView, adapter:
        RecyclerView.Adapter<VH>,
        isNestedScrollingEnabled: Boolean
    ) {
        rcv.setHasFixedSize(true)
        rcv.layoutManager = LinearLayoutManager(context)
        rcv.adapter = adapter
        rcv.isNestedScrollingEnabled = isNestedScrollingEnabled
    }

    fun addFragment(
        fragment: Fragment,
        id: Int,
        addToBackStack: Boolean
    ) {

        val activity = activity
        if (activity is BaseActivity<*>)
            activity.addFragment(fragment, id, addToBackStack)
    }

    fun replaceFragment(
        fragment: Fragment,
        id: Int,
        addToBackStack: Boolean
    ) {

        val activity = activity
        if (activity is BaseActivity<*>)
            activity.replaceFragment(fragment, id, addToBackStack)
    }


    fun hideKeyboard() {
        activity?.let {
            if (it is BaseActivity<*>) {
                it.hideKeyboard()
            }
        }
    }

    fun showDialog() {
        activity?.let {
            if (it is BaseActivity<*>) {
                it.showDialog()
            }
        }
    }

    fun hideDialog() {
        activity?.let {
            if (it is BaseActivity<*>) {
                it.hideDialog()
            }
        }
    }




    fun showMessagDialog(message: String): AlertDialog? {
        activity?.let {
            if (it is BaseActivity<*>) {
                return it.showMessagDialog(message)
            }
        }
        return null
    }

    fun showConfirmMessagDialog(message: String, yesAction: () -> Unit, noAction: () -> Unit) {
        showConfirmMessagDialog(message, yesAction, noAction)
    }

    fun showConfirmMessagDialog(
        message: String,
        yesText: Int = R.string.yes,
        noText: Int = R.string.no,
        yesAction: () -> Unit,
        noAction: () -> Unit
    ) {
        activity?.let {
            if (it is BaseActivity<*>) {
                it.showConfirmMessagDialog(message, yesText, noText, yesAction, noAction)
            }
        }
    }


    fun showMessage(message: String) {
//        CustomDialogObject.showErrorDialog(context!!, message) {
//
//        }.show()
    }

    companion object {
        public val NOPAPER = 3
        public val LOWBATTERY = 4
        public val OVERHEAT = 12
        var myActivity: Activity? = null

    }

    fun isTelpo(): Boolean {
        try {
            Class.forName("com.common.sdk.thermalprinter.ThermalPrinterServiceManager")
        } catch (var16: ClassNotFoundException) {
            var16.printStackTrace()
            return false
        }
        return true
    }

    fun getBitmapOptions(): BitmapFactory.Options? {
        val options = BitmapFactory.Options()
        options.inTargetDensity = 160
        options.inDensity = 160
        return options
    }

//    class MyHandler : Handler() {
//        override fun handleMessage(msg: Message) {
//            when (msg.what) {
//                NOPAPER -> {
//                    val dlg =
//                        android.app.AlertDialog.Builder(myActivity)
//                    dlg.setTitle(myActivity?.getString(R.string.noPaper))
//                    dlg.setMessage(myActivity?.getString(R.string.noPaperNotice))
//                    dlg.setCancelable(false)
//                    dlg.setPositiveButton(R.string.sure,
//                        DialogInterface.OnClickListener { dialogInterface, i -> })
//                    dlg.show()
//                }
//                LOWBATTERY -> {
//                    val alertDialog =
//                        android.app.AlertDialog.Builder(myActivity)
//                    alertDialog.setTitle(R.string.operation_result)
//                    alertDialog.setMessage(myActivity?.getString(R.string.LowBattery))
//                    alertDialog.setPositiveButton(
//                        myActivity?.getString(R.string.dialog_comfirm),
//                        DialogInterface.OnClickListener { dialogInterface, i -> })
//                    alertDialog.show()
//                }
//                OVERHEAT -> {
//                    val overHeatDialog =
//                        android.app.AlertDialog.Builder(myActivity)
//                    overHeatDialog.setTitle(R.string.operation_result)
//                    overHeatDialog.setMessage(myActivity?.getString(R.string.overTemp))
//                    overHeatDialog.setPositiveButton(
//                        myActivity?.getString(R.string.dialog_comfirm),
//                        DialogInterface.OnClickListener { dialogInterface, i -> })
//                    overHeatDialog.show()
//                }
//                else -> Toast.makeText(
//                    myActivity,
//                    myActivity?.getString(R.string.print_error),
//                    Toast.LENGTH_LONG
//                ).show()
//            }
//        }
//    }


    @Throws(TelpoException::class)
    public fun throwException(e: InvocationTargetException) {
        if (e.targetException.toString().contains("NoPaper")) {
            throw NoPaperException()
        } else if (e.targetException.toString().contains("OverHeat")) {
            throw OverHeatException()
        } else if (e.targetException.toString().contains("BlackBlock")) {
            throw BlackBlockNotFoundException()
        } else if (e.targetException.toString().contains("LowPower")) {
            throw LowPowerException()
        } else {
            throw TelpoException()
        }
    }


    class TableItem {
        var text: Array<String>
        var width: IntArray
        var align: IntArray

        init {
            text = arrayOf("test", "test")
            width = intArrayOf(1, 2)
            align = intArrayOf(0, 2)
        }
    }

    fun sunmiPrintText(
        text: String,
        size: Int = 24,
        isBold: Boolean = false,
        isUnderline: Boolean = false
    ) {
//        SunmiPrintHelper.getInstance()
//            .printText(("\n").plus(text), size.toFloat(), isBold, isUnderline)
    }



}