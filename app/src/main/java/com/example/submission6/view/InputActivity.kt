package com.example.submission6.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.submission6.R
import com.example.submission6.model.action.ResponseAction
import com.example.submission6.model.getdata.DataItem
import com.example.submission6.network.NetworkConfig
import com.example.submission6.viewModel.ViewModelMain
import kotlinx.android.synthetic.main.activity_input.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InputActivity : AppCompatActivity() {

    lateinit var viewModel: ViewModelMain

    private fun attachObserve(){
        viewModel.responseAction.observe(this, Observer { successAction(it) })
        viewModel.toast.observe(this, Observer { showToast(it) })
        viewModel.errorAction.observe(this, Observer{ errorAction(it)})
    }

    private fun showToast(it: String?) {
        Toast.makeText(applicationContext, it.toString(), Toast.LENGTH_SHORT).show()
    }

    private fun errorAction(it: Throwable?) {
        Toast.makeText(applicationContext, it?.localizedMessage, Toast.LENGTH_SHORT).show()
        finish()
    }

    private fun successAction(it: ResponseAction?) {
        Toast.makeText(applicationContext, "Berhasil", Toast.LENGTH_SHORT).show()
        finish()
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)



        btn_batal.setOnClickListener {
            finish()
        }


        viewModel = ViewModelProviders.of(this).get(ViewModelMain::class.java)
        attachObserve()

        val getDataIntent = intent.getParcelableExtra<DataItem>("data")
        if (getDataIntent != null) {
            et_nama.setText(getDataIntent.nama)
            et_nohp.setText(getDataIntent.nohp)
            et_alamat.setText(getDataIntent.alamat)

            btn_simpan.setText("Update")
        }

        when (btn_simpan.text) {
            "Update" -> btn_simpan.setOnClickListener {
                viewModel.updateListData(getDataIntent?.id.toString(), et_nama.text.toString(), et_nohp.text.toString(), et_alamat.text.toString())
            }
            else -> {
                btn_simpan.setOnClickListener {
                    viewModel.insertListDataa(et_nama.text.toString(),et_nohp.text.toString(),et_alamat.text.toString())
                }
            }
        }
    }


}



