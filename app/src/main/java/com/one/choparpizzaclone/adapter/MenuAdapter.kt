package com.one.choparpizzaclone.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.one.choparpizzaclone.R
import com.one.choparpizzaclone.databinding.MenuItemLyBinding
import com.one.choparpizzaclone.model.MenuModel
import com.one.choparpizzaclone.model.MovieModel
import com.one.choparpizzaclone.model.Result
import com.squareup.picasso.Picasso

class MenuAdapter(val baseList: List<Result>) : RecyclerView.Adapter<MenuAdapter.ItemHolder>() {

    inner class ItemHolder(val b: MenuItemLyBinding) : RecyclerView.ViewHolder(b.root) {
        fun bind(result: Result) {
            b.subRecTitle.text = result.title
            val subMemberAdapter = SubMemberAdapter(result.members)
            b.subRecView.run {
                layoutManager = LinearLayoutManager(b.root.context, LinearLayoutManager.VERTICAL, false)//VERTICAL
                adapter = subMemberAdapter
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            MenuItemLyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val itemData = baseList[position]

        holder.bind(itemData)

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "$position", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return baseList.size
    }
}