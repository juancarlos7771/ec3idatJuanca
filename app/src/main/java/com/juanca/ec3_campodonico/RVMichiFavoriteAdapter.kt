package com.juanca.ec3_campodonico

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.juanca.ec3_campodonico.databinding.FragmentMichiFavoriteBinding
import com.juanca.ec3_campodonico.databinding.ItemMichiBinding
import com.juanca.ec3_campodonico.model.Michi


class MichiVHF(private val binding: FragmentMichiFavoriteBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(michi: Michi) {
        Glide.with(binding.root.context)
            .load(michi.image) // Carga la imagen desde la URL proporcionada por la API
            .into(binding.imageView)
        binding.txtNameStore.text = michi.name
        binding.txtDetail.text = michi.gameSeries
        binding.txtExpiredOn.text = michi.type
    }
}