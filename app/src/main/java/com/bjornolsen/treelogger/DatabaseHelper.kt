package com.bjornolsen.treelogger

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.bjornolsen.treelogger.data.Tree
import com.yggdrasill.bjornolsen.discountcard.DbConstants

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DbConstants.TABLE_TREE, null, 1) {

    val TAG = "DatabaseHelper"

    /**
     * Return all data from db
     * @return Cursor with data
     */
    val data: Cursor
        get() {
            val db = this.writableDatabase
            val query = "SELECT * FROM ${DbConstants.TABLE_TREE}"
            Log.d(TAG, "data: Querying db for data")
            return db.rawQuery(query, null)
        }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(DbConstants.CREATE_TABLE_TREE)
        Log.d(TAG, "onCreate: Database initialized")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS ${DbConstants.TABLE_TREE}")
        onCreate(db)
        Log.d(TAG, "onUpdate: Dropped ver.$oldVersion and initialized ver.$newVersion")
    }

    /**
     * Add a tree to the db
     * @param item : Tree
     */
	fun addData(item: Tree): Boolean {
        //Map tree item to db tags
        val content = ContentValues()
        content.put(DbConstants.TT_COL1, item.Number)
        content.put(DbConstants.TT_COL2, item.Height)
        content.put(DbConstants.TT_COL3, item.Width)

        //Insert content into database
		val result = writableDatabase.insert(DbConstants.TABLE_TREE, null, content)
        Log.d(TAG, "addData: Adding $item to ${DbConstants.TABLE_TREE}")
		
		//if data inserted incorrectly will return -1
		return if (result.toInt() == -1) {
			Log.d(TAG, "addData: Error in adding $item to ${DbConstants.TABLE_TREE}")
			false
		} else true
	}
}
