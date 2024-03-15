package com.yaizz.flimlerapp.ui.fragment

import android.database.DatabaseUtils
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.yaizz.flimlerapp.R
import com.yaizz.flimlerapp.databinding.FragmentDetayBinding


class DetayFragment : Fragment() {
    private lateinit var binding: FragmentDetayBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detay ,container, false)

        val bundle : DetayFragmentArgs by navArgs()

        val filmNesnesi = bundle.film
        binding.flimNesnesi = filmNesnesi


        binding.ivFlim.setImageResource(
            resources.getIdentifier(filmNesnesi.resim,"drawable",requireContext().packageName))



        return binding.root
    }

}