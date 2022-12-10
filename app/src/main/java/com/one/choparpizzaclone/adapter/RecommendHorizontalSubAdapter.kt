package com.one.choparpizzaclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.one.choparpizzaclone.R
import com.one.choparpizzaclone.databinding.RecommendSubItemBinding
import com.one.choparpizzaclone.model.MenuModel

class RecommendHorizontalSubAdapter: RecyclerView.Adapter<RecommendHorizontalSubAdapter.ItemHolder>(){
    inner class ItemHolder(val b: RecommendSubItemBinding): RecyclerView.ViewHolder(b.root)
    var baseList: List<MenuModel> = emptyList()

    fun newList(list: List<MenuModel>){
        baseList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(RecommendSubItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        val itemData = baseList[position]
        with(itemData){
            holder.b.recommendImg.setImageResource(img?: R.drawable.ic_launcher_background)
            holder.b.recommendNam.text = title
            holder.b.recommendPriceBtn.text = price
        }
    }

    override fun getItemCount(): Int  = baseList.size
}