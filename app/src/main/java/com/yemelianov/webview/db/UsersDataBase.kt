package com.yemelianov.webview.db

import android.provider.BaseColumns

object UsersDataBase : BaseColumns {



        const val TABLE_NAME = "Users"
        const val COLUMN_NAME_USERNAME = "username"
        const val COLUMN_NAME_PHONE = "phone"
        const val COLUMN_NAME_EMAIL = "email"

        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "UsersDB.db"

        const val CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
                    "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                    "$COLUMN_NAME_USERNAME TEXT," +
                    "$COLUMN_NAME_PHONE TEXT," +
                    "$COLUMN_NAME_EMAIL TEXT)"

        const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"

}