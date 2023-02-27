package com.example.experimentation.HomeFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.experimentation.R
import com.example.experimentation.databinding.FragmentHomeBinding
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {
    private val viewModel:HomeViewModel by viewModel()
    val itemAdapter = ItemAdapter<SimpleItem>()
    val fastAdapter = FastAdapter.with(itemAdapter)
    private val viewBinding:FragmentHomeBinding by viewBinding()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView(){
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.people.filterNotNull().collect {
                itemAdapter.set(it.map { SimpleItem(id = it.id, name = it.name, age = it.age.toString(), image = it.image){toa(it)} })
            }
        }


        with(viewBinding.recycler) {
            layoutManager = LinearLayoutManager(
                context
            )
            adapter = fastAdapter
        }
    }
    fun toa(simpleItem: SimpleItem) {
        Toast.makeText(context,"fhshfsd", Toast.LENGTH_SHORT).show()
        println("${simpleItem.age}")
    }



}