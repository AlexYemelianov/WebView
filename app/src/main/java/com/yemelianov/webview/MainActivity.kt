package com.yemelianov.webview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.yemelianov.webview.db.DBManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val dbManager = DBManager(this)
    private var dataList: ArrayList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbManager.openDB()
        dataList = dbManager.readDBData()
        val dataForAdapter = dataList?.toArray()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dataForAdapter as Array<out Any>)
        phoneText.threshold = 3
        phoneText.setAdapter(adapter)
        phoneText.setOnFocusChangeListener { _, b -> if (b) phoneText.showDropDown() }

    }

    fun saveDataOnClick(view: View) {
        if (nameText.text.isNotEmpty() && phoneText.text.isNotEmpty() && emailText.text.isNotEmpty()) {
            intent = Intent(this, WebView::class.java)
            finish()
            startActivity(intent)

            dbManager.writeDB(nameText.text.toString(), phoneText.text.toString(),
                    emailText.text.toString())

            Toast.makeText(this, "$dataList", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Fill all the lines!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        dbManager.closeDB()
    }
}