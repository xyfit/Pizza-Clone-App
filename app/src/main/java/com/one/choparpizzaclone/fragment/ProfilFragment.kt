package com.one.choparpizzaclone.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.one.choparpizzaclone.R
import com.one.choparpizzaclone.databinding.FragmentDiscountBinding
import com.one.choparpizzaclone.databinding.FragmentProfilBinding
import com.one.choparpizzaclone.viewmodel.BaseViewModel

class ProfilFragment : Fragment() {

    private var _binding: FragmentProfilBinding? = null
    private val binding get() = _binding!!

    lateinit var baseViewModel: BaseViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        baseViewModel = ViewModelProvider(requireActivity())[BaseViewModel::class.java]

        listeningToLiveData()


    }

    private fun listeningToLiveData() {
        baseViewModel.matn.observe(viewLifecycleOwner, Observer {

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}