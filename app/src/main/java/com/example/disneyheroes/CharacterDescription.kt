package com.example.disneyheroes

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.disneyheroes.databinding.FragmentDescriptionBinding

class CharacterDescription : Fragment() {
    private val viewModel : CharacterDescriptionViewModel by viewModels()
    private lateinit var binding: FragmentDescriptionBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, ListFragment())
                .commit()
        }
        viewModel.listChar.observe(viewLifecycleOwner) { list ->
            for (i in 0 until list.size){
                if (list[i]._id.equals(id)) {
                    setDescriptionOfHero(list, i)
                } else {
                    setDescriptionOfHero(list, 0)
                }
            }
        }
        viewModel.getCharacter()
    }

    @SuppressLint("SetTextI18n")
    fun setDescriptionOfHero(list: ArrayList<CharacterInfo>, position: Int) {
        binding.descriptionCharacterName.text = "Hero name: " + list[position].name
        Glide.with(binding.root.context).load(list[position].imageUrl).into(binding.descriptionCharacterImage)
        binding.descriptionCharacterAllies.text = "Allies: " + list[position].allies.toString()
        binding.descriptionCharacterEnemies.text = "Enemies: " + list[position].enemies.toString()
        binding.descriptionCharacterFilms.text = "Films: " + list[position].films
        binding.descriptionCharacterShortFilms.text = "Short Films: " + list[position].shortFilms.toString()
        binding.descriptionCharacterTvShows.text = "TV Shows: " + list[position].tvShows.toString()
        binding.descriptionCharacterVideoGames.text = "Video Games: " + list[position].videoGames.toString()
        binding.descriptionCharacterURL.text = "URL: " + list[position].url

    }
}