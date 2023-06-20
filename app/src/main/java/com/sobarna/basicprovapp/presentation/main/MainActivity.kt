package com.sobarna.basicprovapp.presentation.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.sobarna.basicprovapp.data.Result
import com.sobarna.basicprovapp.databinding.ActivityMainBinding
import com.sobarna.basicprovapp.presentation.ViewModelFactory
import com.sobarna.basicprovapp.presentation.adapter.HeaderAdapter
import com.sobarna.basicprovapp.presentation.adapter.ItemAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var factory: ViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        factory = ViewModelFactory.getInstance()
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]
        setContentView(binding.root)

        initDataProv()
    }

    private fun initDataProv() {
        viewModel.getDataProv.observe(this) { result ->
            when (result) {
                is Result.Error -> {
                    showLoading(false)
                    Toast.makeText(applicationContext, result.error, Toast.LENGTH_SHORT).show()
                }
                Result.Loading -> showLoading(true)
                is Result.Success -> {
                    showLoading(false)
                    val headerAdapter = HeaderAdapter()
                    val itemAdapter = ItemAdapter(result.data)

                    binding.rvData.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = ConcatAdapter(headerAdapter, itemAdapter)
                    }
                }
            }
        }
    }
    private fun showLoading(state: Boolean) {
        with(binding){
            progressBar.isVisible = state
            rvData.isVisible = !state
        }
    }
}