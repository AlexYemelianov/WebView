package com.yemelianov.webview.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, UsersDataBase.DATABASE_NAME,
    null, UsersDataBase.DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(UsersDataBase.CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL(UsersDataBase.SQL_DELETE_TABLE)
        onCreate(db)
    }
}