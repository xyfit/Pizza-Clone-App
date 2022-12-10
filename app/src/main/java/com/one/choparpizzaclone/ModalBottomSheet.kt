package com.one.choparpizzaclone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.one.choparpizzaclone.databinding.BottomSheetLyBinding
import com.one.choparpizzaclone.model.Result

class ModalBottomSheet(val itemData: Result.SubMember): BottomSheetDialogFragment() {

    private var _binding: BottomSheetLyBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
//    ): View? = inflater.inflate(R.layout.bottom_sheet_ly, container, false)
    ): View {
        _binding = BottomSheetLyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemData.also {
        binding.imageView2.setImageResource(it.image)
        binding.textView2.text = it.title
        binding.textView3.text = it.description

        }
    }
    companion object {
        const val TAG = "ModalBottomSheet"
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}