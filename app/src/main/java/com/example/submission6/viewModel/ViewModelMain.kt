package com.example.submission6.viewModel

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.submission6.model.action.ResponseAction
import com.example.submission6.model.getdata.ResponseData
import com.example.submission6.repository.Repository

class ViewModelMain : ViewModel(){

    val repository = Repository()

    var responseData = MutableLiveData<ResponseData>()
    var isError = MutableLiveData<Throwable>()
    var responseAction = MutableLiveData<ResponseAction>()
    var errorAction = MutableLiveData<Throwable>()
    var toast = MutableLiveData<String>()

    fun getListData(){

        repository.getData({
            responseData.value = it
        },{
            isError.value = it
        })
    }



    fun insertListDataa(nama : String, nohp : String, alamat : String){
        repository.insertData(nama ?:"", nohp ?:"", alamat ?:"",{
            if (nama.isEmpty() || nohp.isEmpty() || alamat.isEmpty()){
                toast.value = "Silagkan isi Semua Data"
            }else {
                responseAction.value = it
            }
        },{
            errorAction.value = it
        })
    }

    fun updateListData(id : String, nama : String, nohp: String, alamat: String){
        repository.updateData(id ?:"", nama ?:"", nohp ?:"", alamat ?:"",{
           if (nama.isEmpty() || nohp.isEmpty() || alamat.isEmpty()){
               toast.value = "Silahkan Isi Semua Data"
           }else {
               responseAction.value = it
           }
        },{
            errorAction.value = it
        })
    }

    fun deleteListData(id : String) {
        repository.deleteData(id,{
            responseAction.value = it
        },{
            errorAction.value = it
        })
    }


}