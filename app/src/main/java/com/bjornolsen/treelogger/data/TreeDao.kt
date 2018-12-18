package com.bjornolsen.treelogger.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.bjornolsen.treelogger.data.Tree

@Dao
interface TreeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(tree: Tree)

    @Update
    fun update(tree: Tree)

    @Delete
    fun delete(tree: Tree)

    @Query("SELECT * FROM tree_table WHERE Number == :number")
    fun getTreesByNumber(number: Int): LiveData<List<Tree>>

    @Query("SELECT * FROM tree_table")
    fun getTrees(): LiveData<List<Tree>>
}