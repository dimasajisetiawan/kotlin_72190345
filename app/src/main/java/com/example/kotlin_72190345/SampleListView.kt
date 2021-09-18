package com.example.kotlin_72190345

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.view.ViewParent
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import com.google.android.material.snackbar.Snackbar
import java.text.FieldPosition

class SampleListView : AppCompatActivity() {
    var items = arrayOf(
        "lorem", "ipsum", "dolor", "sit", "amet",
        "consectetuer", "adipiscing", "elit", "morbi", "vel",
        "ligula", "vitae", "arcu", "aliquet", "mollis",
        "etiam", "vel", "erat", "placerat", "ante",
        "porttitor", "sodales", "pellentesque", "augue", "purus"
    )

    lateinit var lvSample : ListView
    lateinit var spSimpleList : Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_list_view)

        lvSample = findViewById(R.id.lvSample)
        lvSample.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items,)
        lvSample.setOnItemClickListener { parent, view, i, l
            -> Snackbar.make(view, "Anda memilih: ${items[i]}",
        Snackbar.LENGTH_LONG).show()
        }
        spSimpleList = findViewById(R.id.spSimpleListView)
        spSimpleList.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        spSimpleList.onItemSelectedListener = object :
        AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View,
            position: Int, id: Long) {
                Snackbar.make(lvSample, "Anda Memilih : ${items[position]}",
                Snackbar.LENGTH_LONG).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
        registerForContextMenu(lvSample)


    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        var info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        when(item.itemId){
            R.id.menu_add -> {
                Snackbar.make(
                    lvSample, "Anda memilih: Add item ke - ${info.id} ",
                    Snackbar.LENGTH_LONG
                ).show()
            }
            R.id.menu_edit -> {
                Snackbar.make(
                    lvSample, "Anda memilih: Edit ke - ${info.id}",
                    Snackbar.LENGTH_LONG
                ).show()
            }
            R.id.menu_delete -> {
                Snackbar.make(
                    lvSample, "Anda memilih: Delete ke - ${info.id}",
                    Snackbar.LENGTH_LONG
                ).show()
            }

        }
        return super.onContextItemSelected(item)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_sample_list_view, menu)
    }
}