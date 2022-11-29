package com.one.choparpizzaclone.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.one.choparpizzaclone.R
import com.one.choparpizzaclone.adapter.MySliderAdapter
import com.one.choparpizzaclone.api.NetworkManager
import com.one.choparpizzaclone.databinding.FragmentDiscountBinding
import com.one.choparpizzaclone.databinding.FragmentMenuBinding
import com.one.choparpizzaclone.model.MovieModel
import com.one.choparpizzaclone.model.Result
import com.one.choparpizzaclone.viewmodel.BaseViewModel
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import com.smarteist.autoimageslider.SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DiscountFragment : Fragment() {
    private var _binding: FragmentDiscountBinding? = null
    private val binding get() = _binding!!

    lateinit var baseViewModel: BaseViewModel
    lateinit var sliderView: SliderView
    private var imageList = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDiscountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        baseViewModel = ViewModelProvider(requireActivity())[BaseViewModel::class.java]

        initViews()
        initLists()
        listeningToLiveData()
        loadApi()
        loadSliderView()

    }

    private fun loadSliderView() {
        sliderView.apply {
            setSliderAdapter(MySliderAdapter(imageList))//set adapter
            setIndicatorAnimation(IndicatorAnimationType.WORM)// indicator animatsiya turi
            setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
            scrollTimeInSec = 1//set scroll delay in seconds
            autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_RIGHT
            startAutoCycle()
        }
    }

    private fun loadApi() {
        NetworkManager.apiClient().getFilmData(key = "k_jo0bfe4d", film_name = "Avengers").enqueue(object : Callback<MovieModel<List<Result>>>{
            override fun onResponse(
                call: Call<MovieModel<List<Result>>>,
                response: Response<MovieModel<List<Result>>>
            ) {
                if(response.isSuccessful){
//                  imageList = response.body()!!.results.take(6).map { it.image }
                    sliderView.setSliderAdapter(MySliderAdapter(imageList))//set adapter
                }
            }
            override fun onFailure(call: Call<MovieModel<List<Result>>>, t: Throwable) {}
        })
    }

    private fun listeningToLiveData() {
        baseViewModel.matn.observe( viewLifecycleOwner, Observer {

        })
    }

    private fun initLists() {
        imageList.add(R.drawable.ic_launcher_background)
        imageList.add(R.drawable.ic_account)
        imageList.add(R.drawable.splash_bac)
        imageList.add(R.drawable.ic_pizza)
    }

    private fun initViews() {
        sliderView = binding.sliderView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}