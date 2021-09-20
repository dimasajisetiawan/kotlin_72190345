package com.example.kotlin_72190345

import adapter.PetaniAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import model.Petani

class SampleRecyclerView : AppCompatActivity() {



    lateinit var rvLatihan : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_recycler_view)

        rvLatihan = findViewById(R.id.rvLatihan)
        rvLatihan.adapter = PetaniAdapter(generateDummyList(5))
        rvLatihan.setHasFixedSize(true)
        rvLatihan.layoutManager = LinearLayoutManager(this)

    }

    private fun generateDummyList(size : Int) : List<Petani> {
        var list = ArrayList<Petani>()
        var user : String

        for (i in 1 until size){
            if(i===1){
                 user = "AW"
            }else{
                user = "AW${i}"
            }
            var item = Petani(user,"Argo Wibowo","100","50","50")
            list +=item
        }
        return list
    }
}