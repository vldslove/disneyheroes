package com.example.disneyheroes

import android.os.Bundle
import android.view.Gravity.apply
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.GravityCompat.apply
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.disneyheroes.databinding.FragmentListBinding

class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private val viewModel: ListViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.allHeroes.setOnClickListener {

        }
        binding.recyclerView.run {
            adapter = HeroListAdapter(
                onClick = {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.container, CharacterDescription())
                        .commit()
                }
            )
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
        viewModel.listChar.observe(viewLifecycleOwner) {
            (binding.recyclerView.adapter as? HeroListAdapter)?.setList(it)
        }
        viewModel.getChars()

    }

}