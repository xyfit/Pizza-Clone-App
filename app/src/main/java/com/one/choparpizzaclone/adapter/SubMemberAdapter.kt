package com.one.choparpizzaclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.one.choparpizzaclone.R
import com.one.choparpizzaclone.databinding.MenuItemLyBinding
import com.one.choparpizzaclone.databinding.MenuSubItemLyBinding
import com.one.choparpizzaclone.model.MenuModel
import com.one.choparpizzaclone.model.MovieModel
import com.one.choparpizzaclone.model.Result
import com.squareup.picasso.Picasso

class SubMemberAdapter(val baseList: List<Result.SubMember>) :
    RecyclerView.Adapter<SubMemberAdapter.ItemHolder>() {

    inner class ItemHolder(val b: MenuSubItemLyBinding) : RecyclerView.ViewHolder(b.root) {

        fun bind(result: Result.SubMember) {
            b.titleText.text = result.title
            Picasso.get().load(result.image).error(R.drawable.ic_launcher_background).into(b.image)
            b.infoText.text = result.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            MenuSubItemLyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val itemData = baseList[position]
        holder.bind(itemData)
    }


    override fun getItemCount(): Int {
        return baseList.size
    }
}