package com.example.disneyheroes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.disneyheroes.databinding.FragmentAppstartBinding

class AppStartFragment : Fragment() {
    private lateinit var binding: FragmentAppstartBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =FragmentAppstartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.getStarted.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, ListFragment())
                .addToBackStack("")
                .commit()
        }
    }
}