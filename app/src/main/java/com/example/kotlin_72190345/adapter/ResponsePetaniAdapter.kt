package com.example.kotlin_72190345.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_72190345.R
import com.example.kotlin_72190345.crud.GetPetaniActivity
import com.example.kotlin_72190345.crud.UpdatePetaniActivity
import com.example.kotlin_72190345.model.DataItem
import com.example.kotlin_72190345.model.ResponseAddPetani
import com.example.kotlin_72190345.model.ResponsePetani
import com.example.kotlin_72190345.model.ResponseUsersItem
import com.example.kotlin_72190345.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResponsePetaniAdapter (val petani: List<DataItem>?):
    RecyclerView.Adapter<ResponsePetaniAdapter.ResponsePetaniHolder>() {
    lateinit var mContext : Context
    lateinit var adapter: ResponsePetaniAdapter
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): ResponsePetaniAdapter.ResponsePetaniHolder { return ResponsePetaniHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.rv_item_petani, parent, false))
    }
    override fun onBindViewHolder(holder: ResponsePetaniAdapter.ResponsePetaniHolder, position: Int) {
        holder.bindPetani(petani?.get(position))
        var popupMenu = PopupMenu(holder.itemView.context, holder.itemView)
        popupMenu.menu.add(Menu.NONE, 0, 0, "Edit")
        popupMenu.menu.add(Menu.NONE, 1, 1, "Delete")
        popupMenu.setOnMenuItemClickListener { menuItem ->
            val id = menuItem.itemId
            mContext = holder.itemView.context
            if (id == 0) {
                val bundle = Bundle()
                var idTmp = petani?.get(position)?.id.toString()
                var namaTmp = petani?.get(position)?.nama.toString()
                var alamatTmp = petani?.get(position)?.alamat.toString()
                var provinsiTmp = petani?.get(position)?.provinsi.toString()
                var kabupatenTmp = petani?.get(position)?.kabupaten.toString()
                var kecamatanTmp = petani?.get(position)?.kecamatan.toString()
                var kelurahanTmp = petani?.get(position)?.kelurahan.toString()
                var namaIstriTmp = petani?.get(position)?.namaIstri.toString()
                var jumlahLahanTmp = petani?.get(position)?.jumlahLahan.toString()
                var fotoTmp = petani?.get(position)?.foto.toString()
                bundle.putString("idPetani", idTmp)
                bundle.putString("namaTmp",namaTmp)
                bundle.putString("alamatTmp",alamatTmp)
                bundle.putString("provinsiTmp",provinsiTmp)
                bundle.putString("kabupatenTmp",kabupatenTmp)
                bundle.putString("kecamatanTmp",kecamatanTmp)
                bundle.putString("kelurahanTmp",kelurahanTmp)
                bundle.putString("namaIstriTmp",namaIstriTmp)
                bundle.putString("jumlahLahanTmp",jumlahLahanTmp)
                bundle.putString("fotoTmp",fotoTmp)
                var intent = Intent(mContext, UpdatePetaniActivity::class.java)
                intent.putExtras(bundle)
                mContext.startActivity(intent)
            } else if (id == 1) {
                var idTmp = petani?.get(position)?.id.toString()
                NetworkConfig().getService()
                    .deletePetani(idTmp.toInt())
                    .enqueue(object : Callback<ResponseAddPetani?> {
                        override fun onFailure(call: Call<ResponseAddPetani?>, t: Throwable) {
                            Toast.makeText(
                                holder.itemView.context,
                                t.localizedMessage,
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                        override fun onResponse(
                            call: Call<ResponseAddPetani?>,
                            response: Response<ResponseAddPetani?>
                        ) {
                            Toast.makeText(
                                holder.itemView.context,
                                "Berhasil hapus data",
                                Toast.LENGTH_SHORT
                            ).show()
                            (mContext as GetPetaniActivity).finish()
                            var intent = Intent(mContext, GetPetaniActivity::class.java)
                            mContext.startActivity(intent)
                        }
                    })
            }
            false
        }
        holder.itemView.setOnClickListener( { view ->
            popupMenu.show()
        })
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
        fun bindPetani(petani: DataItem?) {
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
