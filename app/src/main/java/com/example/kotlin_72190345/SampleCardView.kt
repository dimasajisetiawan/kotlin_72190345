package com.example.kotlin_72190345

import adapter.PetaniCVAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import model.Petani

class SampleCardView : AppCompatActivity() {
    lateinit var rvLatihanCard : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_card_view)

        rvLatihanCard = findViewById(R.id.rvCardView)
        rvLatihanCard.setHasFixedSize(true)
        rvLatihanCard.layoutManager = LinearLayoutManager(this)
        rvLatihanCard.adapter = PetaniCVAdapter(dataDummy(6))
    }

    private fun dataDummy(size : Int) : List<Petani> {
        var list = ArrayList<Petani>()
        var user : String

        for(i in 1 until size){
            if(i===1){
                user = "DAS"
            }else{
                user = "DAS${i}"
            }
            var item = Petani(user,"Dimas Aji Setiawan","100","50","50")
            list += item
        }
        return list
    }
}