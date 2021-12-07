package com.example.basicnavigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basicnavigation.databinding.FragmentDestinationBinding
import com.example.basicnavigation.database.User


class DestinationFragment : Fragment() {



    fun generateData(): List<User>{
        var users = mutableListOf<User>()
        for (x in 1..10){
            users.add(User(x,"user${x}"))
        }
        return users
    }


    private  lateinit var binding: FragmentDestinationBinding
    private val destinationViewModel: DestinationViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDestinationBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        destinationViewModel.getUsers()
        destinationViewModel.savedUsers.observe(viewLifecycleOwner,{ usersList ->

           if(!usersList.isNullOrEmpty()){
            for (saveduser in usersList){
                Log.d("obtainedusers","from fragment user: $saveduser.username")

            }}else
           {
               Log.d("obtainedusers","from fragment is null or empty")
           }
        })
        val receiveUsername = arguments?.getString("username_arg")
        binding.tvReceivedArg.setText(receiveUsername)
        binding.rvUserEntries.layoutManager = LinearLayoutManager(view?.context)
        val adapter = DestinationAdapter(generateData())
        binding.rvUserEntries.adapter = adapter

    }




}