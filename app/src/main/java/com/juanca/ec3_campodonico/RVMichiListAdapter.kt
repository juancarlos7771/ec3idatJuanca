package com.juanca.ec3_campodonico

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.juanca.ec3_campodonico.databinding.ItemMichiBinding
import com.juanca.ec3_campodonico.model.Michi

class RVMichiListAdapter(var michis: List<Michi>): RecyclerView.Adapter<MichiVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MichiVH {
        val binding = ItemMichiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MichiVH(binding)
    }

    override fun getItemCount(): Int = michis.size

    override fun onBindViewHolder(holder: MichiVH, position: Int) {
        holder.bind(michis[position])
    }


}

class MichiVH(private val binding: ItemMichiBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(michi: Michi) {
        Glide.with(binding.root.context)
            .load(michi.image) // Carga la imagen desde la URL proporcionada por la API
            .into(binding.imageView)
        binding.txtNameStore.text = michi.name
        binding.txtDetail.text = michi.gameSeries
        binding.txtExpiredOn.text = michi.type
    }
}