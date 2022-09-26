package com.reift.kisahnabiapp.main

import com.reift.core.utils.KisahAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.reift.core.domain.Resource
import com.reift.core.domain.model.Kisah
import com.reift.kisahnabiapp.databinding.ActivityMainBinding
import com.reift.core.utils.OnItemClickCallback
import com.reift.kisahnabiapp.detail.DetailActivity
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.listKisahNabi.observe(this){ showData(it) }


    }

    private fun showData(data: Resource<List<Kisah>>) {
        binding.recyclerMain.apply {
            val mAdapter = KisahAdapter()
            mAdapter.setData(data.data)
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