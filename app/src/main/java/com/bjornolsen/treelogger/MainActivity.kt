package com.bjornolsen.treelogger

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.bjornolsen.treelogger.data.Tree
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                startNewActivity()
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
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        btn_main_add.setOnClickListener {
            val num = edt_main_treenumber.text.toString().toInt()
            val height = edt_main_height.text.toString().toDouble()
            val width = edt_main_circumferance.text.toString().toDouble()
            val tree = Tree(0, num, height, width)
            //mDatabaseHelper.addData(tree)
        }
    }

    fun startNewActivity(){
        val newIntent = Intent(this,OverviewActivity::class.java)
        startActivity(newIntent)
    }
}
