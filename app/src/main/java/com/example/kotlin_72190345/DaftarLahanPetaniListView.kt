package com.example.kotlin_72190345

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class DaftarLahanPetaniListView : AppCompatActivity() {
    var julukan = arrayOf(
        "abdulrohma", "abuwiyono", "adiprajitn", "adipranot2"
    )
    var nama = arrayOf(
        "Abdul Rohman", "Abuwiyono / Sukri", "Adi Prajitno", "Adi Pranoto"
    )
    var total = arrayOf(
        "1", "1", "3", "3"
    )
    var jumlah = arrayOf(
        "0", "1", "0", "2"
    )
    var lahan = arrayOf(
        "1", "0", "3", "1"
    )

    lateinit var lvList : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_lahan_petani_list_view)

        lvList = findViewById(R.id.listView)

        lvList.adapter = CustomListView(this,julukan,nama,total,jumlah,lahan)



    }
}