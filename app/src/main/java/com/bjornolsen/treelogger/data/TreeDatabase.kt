package com.bjornolsen.treelogger.data

import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@android.arch.persistence.room.Database(entities = [Tree::class], version = 1)
abstract class TreeDatabase : RoomDatabase() {
    abstract fun treeDao(): TreeDao

    companion object {
        var INSTANCE: TreeDatabase? = null

        fun getDataBase(context: Context): TreeDatabase? {
            if (INSTANCE == null){
                synchronized(TreeDatabase::class){
                    INSTANCE = Room.databaseBuilder(context, TreeDatabase::class.java, "treeDb").build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }
}