package com.example.submission6.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.submission6.R
import com.example.submission6.model.getdata.DataItem

class Adapter_Main(val data : List<DataItem?>?, val onClick : onClickListener) : RecyclerView.Adapter<Adapter_Main.ViewHolder>() {

    class ViewHolder (val view : View): RecyclerView.ViewHolder(view) {
        val nama = view.findViewById<TextView>(R.id.tv_nama)
        val nohp = view.findViewById<TextView>(R.id.tv_nohp)
        val alamat = view.findViewById<TextView>(R.id.tv_alamat)
        val btnHapus = view.findViewById<ImageView>(R.id.iv_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_main, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data?.get(position)

        holder.nama.text = item?.nama
        holder.nohp.text = item?.nohp
        holder.alamat.text = item?.alamat

        holder.view.setOnClickListener{
            onClick.detail(item!!)
        }

        holder.btnHapus.setOnClickListener {
            onClick.hapus(item!!)
        }

    }

    interface onClickListener{
        fun detail  (item : DataItem)
        fun hapus   (item : DataItem)
    }

}