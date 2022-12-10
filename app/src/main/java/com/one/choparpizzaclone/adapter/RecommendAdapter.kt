package com.one.choparpizzaclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.one.choparpizzaclone.databinding.RecommendItemBinding
import com.one.choparpizzaclone.model.BaseRecommendModel

class RecommendAdapter : RecyclerView.Adapter<RecommendAdapter.ItemHolder>() {

    private val subAdapter by lazy { RecommendHorizontalSubAdapter() }

    inner class ItemHolder(val b: RecommendItemBinding) : RecyclerView.ViewHolder(b.root) {
        fun bind(result: BaseRecommendModel) {
            //set recommend horizontal list title
            b.recommendItemTitle.text = result.title
            //set recommend recyclerview adapter
            b.recommendItemRec.run {
                layoutManager = LinearLayoutManager(b.root.context, LinearLayoutManager.HORIZONTAL, false)
                adapter = subAdapter
            }
            //RecommendHorizontalSubAdapter ichidagi newList
            subAdapter.newList(result.recommendList)
        }
    }

    var baseList: List<BaseRecommendModel> = emptyList()

    fun newList(list: List<BaseRecommendModel>) {
        baseList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            RecommendItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val itemData = baseList[position]
        holder.bind(itemData)
    }

    override fun getItemCount(): Int = baseList.size
}