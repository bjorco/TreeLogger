package com.bjornolsen.treelogger.data

import android.arch.lifecycle.LiveData
import android.support.annotation.WorkerThread

class TreeRepository(private val treeDao: TreeDao) {
    val LiveDataTrees : LiveData<List<Tree>> = treeDao.getTrees()

    @WorkerThread
    suspend fun insert(tree : Tree){
        treeDao.insert(tree)
    }
}