package com.juanca.ec3_campodonico.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.juanca.ec3_campodonico.R
import com.juanca.ec3_campodonico.databinding.FragmentMichiDetailBinding


class MichiDetailFragment : Fragment() {
    private lateinit var bindig:FragmentMichiDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        bindig= FragmentMichiDetailBinding.inflate(inflater,container,false)
        return bindig.root
    }


}