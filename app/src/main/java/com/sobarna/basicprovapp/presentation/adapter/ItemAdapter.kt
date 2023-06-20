package com.sobarna.basicprovapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sobarna.basicprovapp.databinding.ContentItemDataBinding
import com.sobarna.basicprovapp.model.Provinsi

class ItemAdapter(private val items: List<Provinsi>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ContentItemDataBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ItemViewHolder(private val binding: ContentItemDataBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Provinsi) {
            with(binding) {
                tvId.text = item.id
                tvIdProp.text = item.idProp
                tvNik.text = item.nik
                tvName.text = item.nama
                tvIdProv.text = item.idProv
                tvNameProp.text = item.namaProp
                tvPopulation.text = item.jumlahPenduduk
            }
        }
    }
}