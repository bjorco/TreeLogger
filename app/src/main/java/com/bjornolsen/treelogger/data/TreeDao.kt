package com.bjornolsen.treelogger.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

@Dao
interface TreeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(tree: Tree)

    @Update
    fun update(tree: Tree)

    @Delete
    fun delete(tree: Tree)

    @Query("SELECT * FROM tree_table WHERE Number == :number")
    fun getTreesByNumber(number: Int): LiveData<Tree>

    @Query("SELECT * FROM tree_table")
    fun getTrees(): LiveData<List<Tree>>
}