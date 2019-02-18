package com.numberslight.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.numberslight.R
import com.numberslight.listener.ItemClickListener
import com.numberslight.model.ItemModel

/**
 * Created by Silviu Pal on 18/02/2019.
 */
class RvAdapter(val listener: ItemClickListener) : RecyclerView.Adapter<ViewHolder>() {
    private var list: ArrayList<ItemModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position], listener)
    }

    fun setList(list: List<ItemModel>) {
        this.list.clear()
        this.list.addAll(list)
    }
}