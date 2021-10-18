package com.example.kotlin_72190345.crud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.kotlin_72190345.R
import com.example.kotlin_72190345.model.DataItem
import com.example.kotlin_72190345.model.ResponseAddPetani
import com.example.kotlin_72190345.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdatePetaniActivity : AppCompatActivity() {
    lateinit var edId :EditText
    lateinit var edNama : EditText
    lateinit var edAlamat : EditText
    lateinit var edProvinsi : EditText
    lateinit var edKabupaten : EditText
    lateinit var edKecamatan : EditText
    lateinit var edKelurahan : EditText
    lateinit var edNamaIstri : EditText
    lateinit var edJumlahLahan : EditText
    lateinit var edFoto : EditText
    lateinit var btnSimpanPetani : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_petani)

        edId = findViewById(R.id.edId)
        edNama = findViewById(R.id.edNama)
        edAlamat = findViewById(R.id.edAlamat)
        edProvinsi = findViewById(R.id.edProvinsi)
        edKabupaten = findViewById(R.id.edKabupaten)
        edKecamatan = findViewById(R.id.edKecamatan)
        edKelurahan = findViewById(R.id.edKelurahan)
        edNamaIstri = findViewById(R.id.edNamaIstri)
        edJumlahLahan = findViewById(R.id.edJumlahLahan)
        edFoto = findViewById(R.id.edFoto)
        if(intent.extras != null){
            var bundle : Bundle ?= intent.extras
            var strId : String = bundle?.getString("idPetani").toString()
            var strNama : String = bundle?.getString("namaTmp").toString()
            var strAlamat : String = bundle?.getString("alamatTmp").toString()
            var strProvinsi : String = bundle?.getString("provinsiTmp").toString()
            var strKabupaten : String = bundle?.getString("kabupatenTmp").toString()
            var strKecamatan : String = bundle?.getString("kecamatanTmp").toString()
            var strKelurahan : String = bundle?.getString("kelurahanTmp").toString()
            var strNamaIstri : String = bundle?.getString("namaIstriTmp").toString()
            var strJumlahLahan : String = bundle?.getString("jumlahLahanTmp").toString()
            var strFoto : String = bundle?.getString("fotoTmp").toString()
            edId.setText(strId)
            edNama.setText(strNama)
            edAlamat.setText(strAlamat)
            edProvinsi.setText(strProvinsi)
            edKabupaten.setText(strKabupaten)
            edKecamatan.setText(strKecamatan)
            edKelurahan.setText(strKelurahan)
            edNamaIstri.setText(strNamaIstri)
            edJumlahLahan.setText(strJumlahLahan)
            edFoto.setText(strFoto)
        }
        btnSimpanPetani = findViewById(R.id.btnSimpanPetani)

        btnSimpanPetani.setOnClickListener(View.OnClickListener { view ->
            var ptn = DataItem()
            ptn.id = edId.text.toString()
            ptn.nama = edNama.text.toString()
            ptn.alamat = edAlamat.text.toString()
            ptn.provinsi = edProvinsi.text.toString()
            ptn.kabupaten = edKabupaten.text.toString()
            ptn.kecamatan = edKecamatan.text.toString()
            ptn.kelurahan = edKelurahan.text.toString()
            ptn.namaIstri = edNamaIstri.text.toString()
            ptn.jumlahLahan = edJumlahLahan.text.toString()
            ptn.foto = edFoto.text.toString()

            NetworkConfig().getService()
                .updatePetani(edId.text.toString().toInt(), ptn)
                .enqueue(object : Callback<ResponseAddPetani?> {
                    override fun onFailure(call: Call<ResponseAddPetani?>, t:
                    Throwable) {
                        Toast.makeText(this@UpdatePetaniActivity, t.localizedMessage,
                            Toast.LENGTH_SHORT).show()
                    }
                    override fun onResponse(
                        call: Call<ResponseAddPetani?>,
                        response: Response<ResponseAddPetani?>
                    ) {
                        Toast.makeText(this@UpdatePetaniActivity,"Berhasil Mengubah Data", Toast.LENGTH_LONG).show()
                    }
                })
        })
    }
}