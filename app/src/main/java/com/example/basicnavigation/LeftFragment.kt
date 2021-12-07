package com.example.basicnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.example.basicnavigation.databinding.FragmentLeftBinding


class LeftFragment : Fragment() {


    private lateinit var binding: FragmentLeftBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLeftBinding.inflate(inflater,container,false)
        binding.btnSendName.setOnClickListener{
        val destination = LeftFragmentDirections.actionLeftFragmentToDestinationFragment(binding.etName.text.toString())
        NavHostFragment.findNavController(this).navigate(destination)
    }


        return binding.root
    }


}