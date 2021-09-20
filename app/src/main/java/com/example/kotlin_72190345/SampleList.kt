package com.example.kotlin_72190345

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import java.util.*

class SampleList : AppCompatActivity() {
    lateinit var btnShowList : Button
    lateinit var btnCustomList : Button
    lateinit var btnSampleRV : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_list)

        btnShowList = findViewById(R.id.btnShowList)
        btnCustomList = findViewById(R.id.btnCustomList)
        btnSampleRV = findViewById(R.id.btnSampleRV)

        btnShowList.setOnClickListener(View.OnClickListener { view ->
            var intent = Intent(this@SampleList, SampleListView::class.java )
            startActivity(intent)
        })

        btnCustomList.setOnClickListener(View.OnClickListener { view ->
            var intent = Intent(this@SampleList, DaftarLahanPetaniListView::class.java )
            startActivity(intent)
        })

        btnSampleRV.setOnClickListener(View.OnClickListener { view ->
            var intent = Intent(this@SampleList, SampleRecyclerView::class.java )
            startActivity(intent)
        })
    }
}