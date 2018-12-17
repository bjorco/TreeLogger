package com.bjornolsen.treelogger.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "tree_table")
data class Tree(
    @PrimaryKey(autoGenerate = true)
    val Id: Int,
    val Number: Int,
    var Height: Double,
    var Width: Double) {
    var mass : Double = 0.0
        get(){
            return this.Height * this.Width
        }

    val csv : String
        get() {
            return "$Number;$Height;$Width;$mass"
        }
}