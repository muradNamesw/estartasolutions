package com.estarta.stationery.moduls

import androidx.lifecycle.MutableLiveData
import com.estarta.stationery.base.BaseViewModel
//import com.spm.cadence.data.source.remote.Resource
//import com.spm.cadence.moduls.AddItem.AddItemResponse
//import com.spm.cadence.moduls.AddItem.EditItemResponse
//import com.spm.cadence.moduls.AddItem.UploadAttachmentsResponse
//import com.spm.cadence.moduls.search_item.MainData
//import com.spm.cadence.moduls.searchforresult.SearchModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.util.*

class MainViewModel(val repo: MainRepo) : BaseViewModel(), CoroutineScope {
    protected val job = Job()
    override val coroutineContext = Dispatchers.IO + job

    private var _enableButton = MutableLiveData<Boolean>()
    val enableButton
        get() = _enableButton

//
//    fun addItem(type: String, data: String): LiveData<Resource<AddItemResponse>> {
//        return repo.addItem(type, data)
//    }
//
//    fun updatItem(type: String,recordId : String, data: String): LiveData<Resource<EditItemResponse>> {
//        return repo.updateItem(type,recordId, data)
//    }
//
//    fun addItemDb(
//        type: String,
//        businessName: String,
//        classificationId: String,
//        locationId: String,
//        address: String,
//        partnerId: String,
//        ownerPhoneNumber: String,
//        area: String,
//        ownerNationalId: String
//    ): LiveData<Resource<AddItemResponse>> {
//        return repo.addItemToDb(
//            type,
//            businessName,
//            classificationId,
//            locationId,
//            address,
//            partnerId,
//            ownerPhoneNumber,
//            area,
//            ownerNationalId
//        )
//    }
//
//    fun uploadAttachment(
//        type: String,
//        id: String,
//        file: ByteArray,
//        label: String
//    ): LiveData<Resource<UploadAttachmentsResponse>> {
//        return repo.uploadAttachmets(
//            type,
//            getIntFromStr(id),
//            getPartFromFile(file),
//            getRequestBodyFromLabel(label)
//        )
//    }
//
//
//    fun getAllItems(type: String, domain: String? = null): LiveData<Resource<List<MainData>>> {
//        return repo.getAllItems(type, domain)
//    }
//
//    fun getAllItems(type: String, domain: String? = null, data: String? = null): LiveData<Resource<List<MainData>>> {
//        return repo.getAllItems(type, domain,data)
//    }
//
//    fun getAllItemsDb(
//        criteria: String,
//        name_reference: String,
//        evaluated: String,
//        type: String,
//        location: String,
//        partner: String,
//        partner_number: String,
//        createdBy: String,
//        collectedBy: String,
//        dateFrom: String,
//        dateTo: String
//    ): List<SearchModel> {
//
//        return repo.getAllItemsDb(
//            criteria,
//            name_reference,
//            evaluated,
//            getSimpleStr(type),
//            getSimpleStr(location),
//            getSimpleStr(partner),
//            partner_number,
//            createdBy,
//            collectedBy,
//            dateFrom,
//            dateTo
//        )
//
//    }

    private fun getSimpleStr(location: String): String {
        return try {
            location.split(".")[0]
        } catch (e: Exception) {
            location
        }
    }

    fun getRequestBodyFromLabel(label: String): RequestBody {
        return RequestBody.create(MediaType.parse("text/plain"), label)
    }


    fun getPartFromFile(file: ByteArray): MultipartBody.Part {

        val requestFile: RequestBody = RequestBody.create(MediaType.parse("image/*"), file)
        return MultipartBody.Part.createFormData(
            "attachment",
            Calendar.getInstance().timeInMillis.toString(),
            requestFile
        )
    }

    fun updateAllQuantity() {
//        if (repo.canUpdateQuantity()) {
//            repo.updateQuantity()
//        }
    }

    fun clearAllDBItems() {
//        repo.clearAllDBItems()
    }

    fun enableButton() {
        _enableButton.postValue(true)
    }


}