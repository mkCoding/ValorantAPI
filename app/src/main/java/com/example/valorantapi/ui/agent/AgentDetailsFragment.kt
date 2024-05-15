package com.example.valorantapi.ui.agent

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.valorantapi.R
import com.example.valorantapi.databinding.FragmentAgentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AgentDetailsFragment : Fragment() {

    private lateinit var binding: FragmentAgentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAgentDetailsBinding.inflate(inflater, container, false)
        val displayIcon = arguments?.getString("displayIcon")
        val description = arguments?.getString("description")
        val role = arguments?.getString("role")
        Log.d("AgentDetailsFragment", "Agent Image URL: $displayIcon")


        binding.apply {
            Glide.with(root.context)
                .load(displayIcon)
                .placeholder(R.drawable.ic_android_black_24dp)
                .into(ivAgent)
            tvRole.text = role
            tvDescription.text = description

            ivBackButton.setOnClickListener {
                view?.findNavController()?.popBackStack() //navigates back to previous fragment

            }
        }

        return binding.root


    }

}