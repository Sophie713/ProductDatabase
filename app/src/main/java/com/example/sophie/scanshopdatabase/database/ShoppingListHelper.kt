package com.example.sophie.scanshopdatabase.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.support.annotation.NonNull

class ShoppingListHelper : SQLiteOpenHelper {

    private var tableName: String
    private var SQL_CREATE_ENTRIES: String
    private var SQL_DELETE_ENTRIES: String

    constructor(context: Context, @NonNull tableName: String) : super(context, ShoppingListContract().DATABASE_NAME, null, ShoppingListContract().DATABASE_VERSION) {
        this.tableName = tableName
        SQL_CREATE_ENTRIES = buildTable(tableName)
        SQL_DELETE_ENTRIES = deleteTable(tableName)
    }

    override fun onCreate(db: SQLiteDatabase?) {
        try {
            db?.execSQL(SQL_CREATE_ENTRIES)
        } catch (e: Exception) {
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        try {
            db?.execSQL(SQL_DELETE_ENTRIES)
            onCreate(db)
        } catch (e: Exception) {
        }
    }

    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    private fun buildTable(tableName: String): String {
        if (tableName == ShoppingListContract().SHOPPING_LISTS_TABLE_NAME) {
            return "CREATE TABLE " + ShoppingListContract().SHOPPING_LISTS_TABLE_NAME + " (" +
                    ShoppingListContract().COL_SHOPPING_LIST_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    ShoppingListContract().COL_SHOPPING_LIST_TITLE + " TEXT NOT NULL UNIQUE, " +
                    ShoppingListContract().COL_SHOPPING_LIST_DATE + " TEXT NOT NULL);"

        } else {
            return "CREATE TABLE " + tableName + " (" +
                    ShoppingListContract().COL_ITEM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    ShoppingListContract().COL_ITEM_NAME + " TEXT UNIQUE, " +
                    ShoppingListContract().COL_ITEM_QUANTITY + " INTEGER DEFAULT 1, " +
                    ShoppingListContract().COL_ITEM_BOUGHT + " INTEGER DEFAULT 0 , " +
                    ShoppingListContract().COL_ITEM_EAN + " TEXT, " +
                    ShoppingListContract().COL_ITEM_BRAND + " TEXT);"
        }
    }

    private fun deleteTable(tableName: String): String {
        return "DROP TABLE " + tableName

    }
}