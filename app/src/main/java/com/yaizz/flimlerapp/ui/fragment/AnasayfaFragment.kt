package com.yaizz.flimlerapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.yaizz.flimlerapp.R
import com.yaizz.flimlerapp.data.entitiy.Filmler
import com.yaizz.flimlerapp.databinding.FragmentAnasayfaBinding
import com.yaizz.flimlerapp.ui.adapter.FlimlerAdapter
import com.yaizz.flimlerapp.ui.viewmodel.AnasayfaViewModel


class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var  viewModel: AnasayfaViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa ,container, false)

        binding.anasayfaToolbarBaslik = "Filmler"

        viewModel.flimlerListesi.observe(viewLifecycleOwner){
            val flimlerAdapter = FlimlerAdapter(requireContext(),it)
            binding.flimlerAdapter = flimlerAdapter
        }


        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel :AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }

}