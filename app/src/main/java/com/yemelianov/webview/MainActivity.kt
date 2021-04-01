package com.yemelianov.webview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.yemelianov.webview.db.DBManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val dbManager = DBManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun saveDataOnClick(view: View) {
        if(nameText.text.isNotEmpty()&&phoneText.text.isNotEmpty()&&emailText.text.isNotEmpty()) {
            intent = Intent(this, WebView::class.java)
            finish()
            startActivity(intent)
            dbManager.openDB()
            dbManager.writeDB(nameText.text.toString(), phoneText.text.toString(),
                    emailText.text.toString())
            val dataList = dbManager.readDBData()
            Toast.makeText(this, "$dataList", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Fill all the lines!", Toast.LENGTH_SHORT).show()
        }
    }
}