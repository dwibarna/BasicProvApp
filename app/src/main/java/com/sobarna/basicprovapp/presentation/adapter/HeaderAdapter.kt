package com.sobarna.basicprovapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sobarna.basicprovapp.databinding.ContentItemHeaderBinding

class HeaderAdapter : RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        return HeaderViewHolder(
            ContentItemHeaderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) { }

    override fun getItemCount(): Int = 1

    inner class HeaderViewHolder(binding: ContentItemHeaderBinding) : RecyclerView.ViewHolder(binding.root)
}

