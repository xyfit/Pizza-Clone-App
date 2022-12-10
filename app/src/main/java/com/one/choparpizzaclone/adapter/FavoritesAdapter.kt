package com.one.choparpizzaclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.one.choparpizzaclone.R
import com.one.choparpizzaclone.databinding.AddedOrdersItemLyBinding
import com.one.choparpizzaclone.model.MenuModel

class FavoritesAdapter: RecyclerView.Adapter<FavoritesAdapter.ItemHolder>(){
    inner class ItemHolder(val b: AddedOrdersItemLyBinding): RecyclerView.ViewHolder(b.root)

    var baseList: List<MenuModel> = emptyList()

    fun newList(list: List<MenuModel>){
        baseList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(AddedOrdersItemLyBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val itemData = baseList[position]
        with(itemData){
        holder.b.fvImg.setImageResource(img?: R.drawable.ic_launcher_foreground)
            holder.b.fvName.text = title
            holder.b.fvPrice.text = price
        }
    }

    override fun getItemCount(): Int  = baseList.size
}