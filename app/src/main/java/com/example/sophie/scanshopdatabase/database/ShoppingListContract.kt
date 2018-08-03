package com.example.sophie.scanshopdatabase.database

import android.provider.BaseColumns

class ShoppingListContract() {

    //database
    val DATABASE_VERSION = 1
    val DATABASE_NAME = "shopping_list_database.db"

    //all shopping lists
    val SHOPPING_LISTS_TABLE_NAME: String = "shopping_lists"

    val COL_SHOPPING_LIST_ID: String = "shop_list_id"
    val COL_SHOPPING_LIST_TITLE: String = "shop_list_title"
    val COL_SHOPPING_LIST_DATE: String = "shop_list_date"

    //Single shopping list
    val SINGLE_SHOPPING_LIST_TABLE_NAME_BASE: String = "shopping_list_"

    val COL_ITEM_ID: String = "item_id"
    val COL_ITEM_NAME: String = "sl_item"
    val COL_ITEM_QUANTITY: String = "item_quantity"
    val COL_ITEM_BOUGHT: String = "bought"
    val COL_ITEM_EAN: String = "ean"
    val COL_ITEM_BRAND: String = "brand"

}