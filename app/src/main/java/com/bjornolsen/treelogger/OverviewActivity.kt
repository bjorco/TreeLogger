package com.bjornolsen.treelogger

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_overview.*
import com.bjornolsen.treelogger.data.Tree


class OverviewActivity : AppCompatActivity() {
    private var database: TreeDatabase? = null
    private var treeDao: TreeDao? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overview)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        database = TreeDatabase.getDataBase(this)
        treeDao = database?.treeDao()


        with(treeDao){
            this?.insert(Tree(0, 120, 20.0, 20.0))
            this?.insert(Tree(0, 121, 20.0, 20.0))
            this?.insert(Tree(0, 122, 20.0, 20.0))
            this?.insert(Tree(0, 123, 20.0, 20.0))
        }


        populateList()
    }

    fun populateList(){
        val listTrees = treeDao?.getTrees()
        list_trees.adapter = TreeAdapter(this, listTrees)
        list_trees.layoutManager = LinearLayoutManager(this)
    }
}