package com.bjornolsen.treelogger

import android.arch.lifecycle.LiveData
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bjornolsen.treelogger.data.Tree

class TreeAdapter(context: Context, private val mTrees: ArrayList<Tree>) : RecyclerView.Adapter<TreeAdapter.ViewHolder>() {
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        // each data item is just a string in this case
        val mTxtNumber: TextView = v.findViewById(R.id.txt_rti_treenumber)
        val mTxtHeight: TextView = v.findViewById(R.id.txt_rti_height)
        val mTxtWidth: TextView = v.findViewById(R.id.txt_rti_width)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TreeAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_tree_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: TreeAdapter.ViewHolder, position: Int) {
        holder.mTxtNumber.text = mTrees[position].Number.toString()
        holder.mTxtHeight.text = mTrees[position].Height.toString()
        holder.mTxtWidth.text = mTrees[position].Width.toString()
    }

    override fun getItemCount(): Int {
        return mTrees.size
    }
}
