package com.example.kotlin_72190345.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_72190345.R
import com.example.kotlin_72190345.model.DataItem
import com.example.kotlin_72190345.model.ResponsePetani
import com.example.kotlin_72190345.model.ResponseUsersItem

class ResponsePetaniAdapter (val petani: List<DataItem>?):
    RecyclerView.Adapter<ResponsePetaniAdapter.ResponsePetaniHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): ResponsePetaniAdapter.ResponsePetaniHolder { return ResponsePetaniHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.rv_item_petani, parent, false))
    }
    override fun onBindViewHolder(holder: ResponsePetaniAdapter.ResponsePetaniHolder,
                                  position: Int) {
        holder.bindUsers(petani?.get(position))
    }
    override fun getItemCount(): Int {
        return petani?.size ?: 0
    }
    class ResponsePetaniHolder(view: View) : RecyclerView.ViewHolder(view) {
        lateinit var txtNama: TextView
        lateinit var txtAlamat: TextView
        lateinit var txtProvinsi: TextView
        lateinit var txtKab: TextView
        lateinit var  txtKec : TextView
        lateinit var txtKel : TextView
        lateinit var txtIstri : TextView
        lateinit var  txtJulHan : TextView
        lateinit var txtFoto : TextView
        fun bindUsers(petani: DataItem?) {
            itemView.apply {
                txtNama = findViewById(R.id.nama_petani)
                txtAlamat = findViewById(R.id.alamat_petani)
                txtProvinsi = findViewById(R.id.provinsi_petani)
                txtKab = findViewById(R.id.kab_petani)
                txtKec = findViewById(R.id.kec_petani)
                txtKel = findViewById(R.id.kel_petani)
                txtIstri = findViewById(R.id.nama_istri)
                txtJulHan = findViewById(R.id.jumlah_lahan)
                txtFoto = findViewById(R.id.foto)
                txtNama.text = petani?.nama
                txtAlamat.text = petani?.alamat
                txtProvinsi.text = petani?.provinsi
                txtKab.text = petani?.kabupaten
                txtKec.text = petani?.kecamatan
                txtKel.text = petani?.kelurahan
                txtIstri.text = petani?.namaIstri
                txtJulHan.text = petani?.jumlahLahan
                txtFoto.text = petani?.foto
            }
        }
    }
}
