package com.one.choparpizzaclone.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.one.choparpizzaclone.R
import com.one.choparpizzaclone.adapter.FavoritesAdapter
import com.one.choparpizzaclone.adapter.RecommendAdapter
import com.one.choparpizzaclone.databinding.FragmentDiscountBinding
import com.one.choparpizzaclone.databinding.FragmentFavoritesBinding
import com.one.choparpizzaclone.model.BaseRecommendModel
import com.one.choparpizzaclone.model.MenuModel
import com.one.choparpizzaclone.viewmodel.BaseViewModel

class FavoritesFragment : Fragment() {
    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!

    private val favoritesAdapter by lazy { FavoritesAdapter() }
    private val recommendAdapter by lazy { RecommendAdapter() }

    private lateinit var baseViewModel: BaseViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        baseViewModel = ViewModelProvider(requireActivity())[BaseViewModel::class.java]

        initRecycler()
        initLiveData()
        initDemoRecyclerList()//test lists
    }

    private fun initDemoRecyclerList() {
        //create demo menu list
        val menuList = mutableListOf<MenuModel>()
        for (j in 1..4) {
            menuList.add(MenuModel(R.drawable.ic_account, "name $j\nWWW", "more info $j"))
        }
        baseViewModel.responseList.value = menuList

        //create demo recommend list
        val recommendList = mutableListOf<BaseRecommendModel>()
        for (i in 1..2){
            recommendList.add(BaseRecommendModel("title $i",menuList ))
        }
        //set adapter list
        favoritesAdapter.newList(menuList)
        recommendAdapter.newList(recommendList)
    }

    private fun initRecycler() {
        binding.favoriteListRec.run {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = favoritesAdapter
        }
        binding.recommendRec.run {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = recommendAdapter
        }
    }

    private fun initLiveData() {

        baseViewModel.responseList.observe(viewLifecycleOwner, Observer {
//            favoritesAdapter.newList(it)
//            recommendAdapter.newList(list)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}