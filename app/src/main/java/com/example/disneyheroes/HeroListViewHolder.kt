package com.example.disneyheroes

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.disneyheroes.databinding.HeroItemBinding

class HeroListViewHolder(
    private val binding: HeroItemBinding,
    val onClick: (char: CharacterInfo) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    fun showCharacters(char: CharacterInfo) {
            binding.characterName.text = char.name
            Glide.with(binding.root.context).load(char.imageUrl).into(binding.characterImage)
            binding.item.setOnClickListener {
                onClick(char)
            }

    }
}
