package com.example.valorantapi.ui.weapon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.valorantapi.data.api.ApiResponse
import com.example.valorantapi.databinding.FragmentWeaponsBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class WeaponsFragment : Fragment() {

    lateinit var binding: FragmentWeaponsBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeaponsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val weaponViewModel = ViewModelProvider(this)[WeaponsViewModel::class.java]

        weaponViewModel.weaponList.observe(viewLifecycleOwner) { response ->
            when (response) {
                is ApiResponse.SuccessState -> {
                    binding.progressBar.visibility = View.GONE
                    binding.rvWeapons.visibility = View.VISIBLE
                    binding.tvError.visibility = View.GONE
                    binding.rvWeapons.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = WeaponsAdapter(response.data.data)
                    }
                }
                is ApiResponse.ErrorState -> {
                    binding.progressBar.visibility = View.GONE
                    binding.rvWeapons.visibility = View.GONE
                    binding.tvError.visibility = View.VISIBLE
                }
                else -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.rvWeapons.visibility = View.GONE
                    binding.tvError.visibility = View.GONE
                }
            }
        }

        return root

    }




}

