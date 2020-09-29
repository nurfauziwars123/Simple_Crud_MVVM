package com.example.submission6.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.submission6.R
import com.example.submission6.adapter.Adapter_Main
import com.example.submission6.model.action.ResponseAction
import com.example.submission6.model.getdata.DataItem
import com.example.submission6.model.getdata.ResponseData
import com.example.submission6.viewModel.ViewModelMain
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel : ViewModelMain

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_fab.setOnClickListener {
            val intent = Intent(this, InputActivity::class.java)
            startActivity(intent)
        }

        viewModel = ViewModelProviders.of(this).get(ViewModelMain::class.java)
        viewModel.getListData()

        attachObserve()
    }

    private fun attachObserve() {
        viewModel.responseData.observe(this, Observer {showData(it)})
        viewModel.isError.observe(this, Observer { showError(it) })
    }


    private fun showError(it: Throwable?) {
        Toast.makeText(this, it?.localizedMessage, Toast.LENGTH_SHORT).show()
    }

     private fun showData(it: ResponseData) {

                    val adapter = Adapter_Main(it.data, object : Adapter_Main.onClickListener{
                        override fun detail(item: DataItem) {
                            val intent = Intent(this@MainActivity, InputActivity::class.java)
                            intent.putExtra("data", item)
                            startActivity(intent)
                        }

                        override fun hapus(item: DataItem) {
                        AlertDialog.Builder(this@MainActivity) .apply {
                            setTitle("Hapus Data")
                            setMessage("yakin hapus data?")
                            setPositiveButton("Hapus"){dialogInterface, i ->
                                viewModel.deleteListData(item?.id.toString())
                                Toast.makeText(applicationContext, "Berhasil hapus data", Toast.LENGTH_SHORT).show()
                                dialogInterface.dismiss()
                                viewModel.getListData()
                            }
                            setNegativeButton("Batal"){dialogInterface, i ->
                                dialogInterface.dismiss()
                            }
                        }.show()
                        }

                    })
                    rv_main.adapter = adapter
                }

    override fun onResume() {
        super.onResume()
        viewModel.getListData()
    }

}






