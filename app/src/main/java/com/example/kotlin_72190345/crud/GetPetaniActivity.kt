package com.example.kotlin_72190345.crud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_72190345.R
import com.example.kotlin_72190345.adapter.ResponsePetaniAdapter
import com.example.kotlin_72190345.model.DataItem
import com.example.kotlin_72190345.model.ResponsePetani
import com.example.kotlin_72190345.network.NetworkConfig
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetPetaniActivity : AppCompatActivity() {
    lateinit var rvGetPetani : RecyclerView
    lateinit var fabAddPetani : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_petani)
        rvGetPetani = findViewById(R.id.rvListPetani)
        fabAddPetani = findViewById(R.id.fabAddPetani)
        NetworkConfig().getService()
            .getPetaniAll()
            .enqueue(object : Callback<ResponsePetani?> {
                override fun onFailure(call: Call<ResponsePetani?>, t:
                Throwable) {
                    Toast.makeText(this@GetPetaniActivity, t.localizedMessage,
                        Toast.LENGTH_SHORT).show()
                }
                override fun onResponse(
                    call: Call<ResponsePetani?>,
                    response: Response<ResponsePetani?>
                ) {
                    rvGetPetani.apply{
                        layoutManager = LinearLayoutManager(this@GetPetaniActivity)
                        adapter = ResponsePetaniAdapter(response.body()?.data as List<DataItem>?)
                    }
                }
            })
        fabAddPetani.setOnClickListener(View.OnClickListener{ view ->
            var intent = Intent(this@GetPetaniActivity,AddPetaniActivity::class.java)
            startActivity(intent)
        })
    }
}