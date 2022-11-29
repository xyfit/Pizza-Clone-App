package com.one.choparpizzaclone.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.ahmadhamwi.tabsync.TabbedListMediator
import com.google.android.material.tabs.TabLayout
import com.one.choparpizzaclone.R
import com.one.choparpizzaclone.adapter.MenuAdapter
import com.one.choparpizzaclone.databinding.FragmentMenuBinding
import com.one.choparpizzaclone.model.MovieModel
import com.one.choparpizzaclone.model.Result
import com.one.choparpizzaclone.viewmodel.BaseViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MenuFragment : Fragment(), Callback<MovieModel<List<Result>>> {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    lateinit var baseViewModel: BaseViewModel

    lateinit var recyclerView: RecyclerView
    lateinit var tabLayout: TabLayout

    private var menuList = mutableListOf<Result>()
    private val menuSubList = mutableListOf<Result.SubMember>()
    private var tabTitleList = listOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        baseViewModel = ViewModelProvider(requireActivity())[BaseViewModel::class.java]

        initViews()
        initLists()
        initTabLayout()
        initRecycler()
        initMediator()
    }

    private fun initMediator() {
        TabbedListMediator(
            recyclerView,
            tabLayout,
            tabTitleList.indices.toList(),
            true
        ).attach()
    }

    private fun initLists() {
        for (i in 1..6) {
            menuSubList.add(
                Result.SubMember(R.drawable.ic_launcher_background, "name $i", "description $i")
            )
        }
        for (i in 0..4) {
            menuList.add(Result("Menu title $i", menuSubList))
        }
        tabTitleList = menuList.map { it.title }

    }

    private fun initViews() {
        recyclerView = binding.homeRecycler
        tabLayout = binding.tabLayout
    }

    private fun initTabLayout() {
        tabTitleList.forEachIndexed { index, name ->
            //add tab title text
            tabLayout.addTab(tabLayout.newTab().setText(name))
            //create custom tab title
            val textView = LayoutInflater.from(requireContext()).inflate(R.layout.tab_title, null) as TextView
            tabLayout.getTabAt(index)?.customView = textView
        }
    }

    private fun initRecycler() {
//        recyclerView.layoutManager = LinearLayoutManager(requireContext())// because LinearLayoutManager is inited in xml
        recyclerView.adapter = MenuAdapter(menuList)
    }


    override fun onResponse(
        call: Call<MovieModel<List<Result>>>,
        response: Response<MovieModel<List<Result>>>
    ) {
        if (response.isSuccessful) {
//            binding.homeRecycler.adapter = MenuAdapter(response.body()?.results ?: emptyList())
        }
    }

    override fun onFailure(call: Call<MovieModel<List<Result>>>, t: Throwable) {
        Toast.makeText(requireContext(), "${t.localizedMessage}", Toast.LENGTH_SHORT).show()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}