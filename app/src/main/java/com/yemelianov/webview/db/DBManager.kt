package com.yemelianov.webview.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class DBManager(context: Context) {

    val dbHelper = DBHelper(context)
    var db: SQLiteDatabase? = null

    fun openDB() {
        db = dbHelper.writableDatabase
    }

    fun writeDB(username: String, phone: String, email: String) {
        val values = ContentValues().apply {
            put(UsersDataBase.COLUMN_NAME_USERNAME, username)
            put(UsersDataBase.COLUMN_NAME_PHONE, phone)
            put(UsersDataBase.COLUMN_NAME_EMAIL, email)
        }
        db?.insert(UsersDataBase.TABLE_NAME, null, values)
    }

    fun readDBData() : ArrayList<String>{
        val dbList = ArrayList<String>()
        var cursor = db?.query(UsersDataBase.TABLE_NAME, null, null,
            null, null, null, null)
            while (cursor?.moveToNext()!!) {
                val dbData = cursor.getString(cursor.getColumnIndexOrThrow(UsersDataBase.COLUMN_NAME_USERNAME))
                dbList.add(dbData.toString())
            }
        cursor.close()
        return dbList
    }
    fun closeDB(){
        dbHelper.close()
    }

}