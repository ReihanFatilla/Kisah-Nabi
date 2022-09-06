package com.reift.kisahnabiapp.main

import com.reift.kisahnabiapp.core.utils.KisahAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.reift.kisahnabiapp.core.domain.model.Kisah
import com.reift.kisahnabiapp.core.presentation.KisahViewModelFactory
import com.reift.kisahnabiapp.databinding.ActivityMainBinding
import com.reift.kisahnabiapp.core.utils.OnItemClickCallback
import com.reift.kisahnabiapp.detail.DetailActivity

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = KisahViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]


        viewModel.listKisahNabi.observe(this){ showData(it) }


    }

    private fun showData(data: List<Kisah>?) {
        binding.recyclerMain.apply {
            val mAdapter = KisahAdapter()
            mAdapter.setData(data)
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = mAdapter
            mAdapter.setOnItemClickCallback(object : OnItemClickCallback {
                override fun onItemClicked(item: Kisah) {
                    startActivity(
                        Intent(this@MainActivity, DetailActivity::class.java)
                            .putExtra("EXTRA_DATA", item)
                    )
                }
            })
        }
    }
}