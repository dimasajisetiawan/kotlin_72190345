package com.example.kotlin_72190345

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CustomListView(var context : Activity, var julukan : Array<String>, var nama : Array<String>, var total : Array<String>
, var jumlah : Array<String>, var lahan : Array<String>) : BaseAdapter() {

    lateinit var tv_nama : TextView
    lateinit var tv_julukan : TextView
    lateinit var tv_jumlah : TextView
    lateinit var  tv_total : TextView
    lateinit var tv_lahan : TextView


    override fun getCount(): Int = nama.size

    override fun getItem(position: Int): Any = 0;

    override fun getItemId(position: Int): Long = 0;


    override fun getView(position : Int, view: View?, parent : ViewGroup?): View {
        var inflater = context.layoutInflater
        var rowView = inflater.inflate(R.layout.custom_list, null, true)

        tv_julukan = rowView.findViewById(R.id.tv_julukan)
        tv_nama = rowView.findViewById(R.id.tv_nama)
        tv_jumlah = rowView.findViewById(R.id.tv_jumlah)
        tv_total = rowView.findViewById(R.id.tv_total)
        tv_lahan = rowView.findViewById(R.id.tv_lahan)

        tv_julukan.text = julukan[position]
        tv_nama.text = "Nama: ${nama[position]}"
        tv_lahan.text = "Lahan yang bisa ditambahkan: ${lahan[position]}"
        tv_total.text = "Total Jumlah Lahan: ${total[position]}"
        tv_jumlah.text = "Jumlah Lahan yang sudah teridentifikasi: ${jumlah[position]}"

        return rowView



    }


}