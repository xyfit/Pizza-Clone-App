package com.one.choparpizzaclone.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.one.choparpizzaclone.databinding.TabTitleBinding
import com.one.choparpizzaclone.model.MenuTitleModel

class TitlesAdapter(val basList: List<MenuTitleModel>, val itemCallbackTitleAdapter: ItemCallbackTitleAdapter): RecyclerView.Adapter<TitlesAdapter.ItemHolder>() {
    inner class ItemHolder(val b: TabTitleBinding): RecyclerView.ViewHolder(b.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(TabTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val itemTitle = basList[position]
        holder.b.text1.run {
            this.text = itemTitle.title
            this.backgroundTintList  = ColorStateList.valueOf(Color.WHITE)
            this.setTextColor(Color.BLACK)
        }



        holder.itemView.setOnClickListener {
            itemTitle.clickPosition = !itemTitle.clickPosition
            whenOnClickChangeTitlesColor(holder.b.text1, itemTitle.clickPosition)
            itemCallbackTitleAdapter.itemClickListener(position, holder.itemView)
        }
    }

    override fun getItemCount(): Int  = basList.size

    private fun whenOnClickChangeTitlesColor(textView: TextView, position: Boolean){
        textView.run {
            if (position){
                this.backgroundTintList  = ColorStateList.valueOf(Color.YELLOW)
                this.setTextColor(Color.BLACK)
            }else{
                this.backgroundTintList  = ColorStateList.valueOf(Color.WHITE)
                this.setTextColor(Color.BLACK)
            }
        }
    }
}
interface ItemCallbackTitleAdapter{
    fun itemClickListener(position: Int, view: View)
}