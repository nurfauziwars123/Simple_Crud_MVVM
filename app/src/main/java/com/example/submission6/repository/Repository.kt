package com.example.submission6.repository


import com.example.submission6.model.action.ResponseAction
import com.example.submission6.model.getdata.ResponseData
import com.example.submission6.network.NetworkConfig
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class Repository {

    fun getData(responseHandler : (ResponseData) -> Unit, errorHandler : (Throwable) -> Unit){
        NetworkConfig.service().getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseHandler(it)
            },{
                errorHandler(it)
            })
    }

    fun insertData(nama : String, nohp : String, alamat : String, responseHandler: (ResponseAction) -> Unit, errorHandler: (Throwable) -> Unit){
        NetworkConfig.service().insertData(nama ?:"", nohp ?:"", alamat ?:"")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseHandler(it)
            },{
                errorHandler(it)
            })
    }

    fun updateData(id : String, nama : String, nohp : String, alamat : String, responseHandler: (ResponseAction) -> Unit, errorHandler: (Throwable) -> Unit){
        NetworkConfig.service().updateData(id ?:"", nama ?:"", nohp ?:"", alamat ?:"")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseHandler(it)
            },{
                errorHandler(it)
            })
    }

    fun deleteData(id : String, responseHandler: (ResponseAction) -> Unit, errorHandler: (Throwable) -> Unit){
        NetworkConfig.service().deleteData(id ?:"")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseHandler(it)
            },{
                errorHandler(it)
            })
    }
}