package com.numberslight.main

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.numberslight.listener.ItemClickListener
import com.numberslight.model.ItemModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_view.view.*

/**
 * Created by Silviu Pal on 18/02/2019.
 */
class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val numberView = itemView.number as TextView
    private val imageView = itemView.image as ImageView

    fun bind(item: ItemModel, listener: ItemClickListener) {
        numberView.text = item.name
        Picasso.get().load(item.image)
            .placeholder(android.R.drawable.ic_dialog_info)
            .into(imageView)

        itemView.setOnClickListener {
            listener.onItemClick(item)
        }
    }
}