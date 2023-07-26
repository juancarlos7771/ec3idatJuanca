package com.juanca.ec3_campodonico.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.juanca.ec3_campodonico.MichiVH
import com.juanca.ec3_campodonico.databinding.FragmentMichiFavoriteBinding
import com.juanca.ec3_campodonico.model.Michi


class MichiFavoriteFragment : Fragment() {
    private lateinit var binding: FragmentMichiFavoriteBinding
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
        binding = FragmentMichiFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observar el LiveData cuponList para obtener el Michi específico de la API
        viewModel.cuponList.observe(viewLifecycleOwner) { michiList ->
            // Verificar si la lista no está vacía y mostrar el primer Michi
            if (michiList.isNotEmpty()) {
                val selectedMichi = michiList.first()
                showMichiData(selectedMichi)
            }
        }

        // Realizar la llamada a la API para obtener los datos
        viewModel.getCuponsFromServiceFa()
    }

    private fun showMichiData(michi: Michi) {
        // Mostrar los datos del Michi en la vista
        binding.imageView.loadImage(michi.image)
        binding.txtNameStore.text = michi.name
        binding.txtDetail.text = michi.gameSeries
        binding.txtExpiredOn.text = michi.type
    }

    // Extension function para cargar la imagen desde una URL usando Glide
    private fun ImageView.loadImage(url: String) {
        Glide.with(this)
            .load(url)
            .into(this)
    }
}
