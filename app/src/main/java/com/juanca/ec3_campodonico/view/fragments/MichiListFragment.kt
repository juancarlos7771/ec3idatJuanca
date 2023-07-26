package com.juanca.ec3_campodonico.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.juanca.ec3_campodonico.RVMichiListAdapter
import com.juanca.ec3_campodonico.databinding.FragmentMichiListBinding


class MichiListFragment : Fragment() {
    private lateinit var binding: FragmentMichiListBinding
    private lateinit var viewModel: MichiListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(MichiListViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMichiListBinding.inflate(inflater,container,false)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RVMichiListAdapter(listOf())
        binding.rvMichi.adapter = adapter
        binding.rvMichi.layoutManager = GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)
        viewModel.cuponList.observe(requireActivity()){
            adapter.michis = it
            adapter.notifyDataSetChanged()
        }
        //viewModel.getCuponList()
        viewModel.getCuponsFromService()
    }


}


