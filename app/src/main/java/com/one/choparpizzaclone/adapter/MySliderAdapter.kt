package com.one.choparpizzaclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.one.choparpizzaclone.R
import com.one.choparpizzaclone.databinding.SliderItemLyBinding
import com.smarteist.autoimageslider.SliderViewAdapter
import com.squareup.picasso.Picasso

class MySliderAdapter(private val baseList: List<Int>) : SliderViewAdapter<MySliderAdapter.ItemHolder>() {
    inner class ItemHolder(val b: SliderItemLyBinding) : SliderViewAdapter.ViewHolder(b.root)

    override fun getCount(): Int {
        return baseList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup): ItemHolder {
        return ItemHolder(SliderItemLyBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(viewHolder: ItemHolder, position: Int) {
        val itemImage = baseList[position]
//        viewHolder.b.sliderImg.setImageResource(itemImage)
        Picasso.get().load(itemImage).error(R.drawable.ic_launcher_background).into(viewHolder.b.sliderImg);
    }
}