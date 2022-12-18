package com.example.disneyheroes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.disneyheroes.databinding.HeroItemBinding

class HeroListAdapter(private val onClick: (char: CharacterInfo) -> Unit) : RecyclerView.Adapter<HeroListViewHolder>() {

    private var list = arrayListOf<CharacterInfo>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroListViewHolder {
        return HeroListViewHolder(
            HeroItemBinding.inflate(LayoutInflater.from(parent.context), parent, false), onClick
        )
    }

    override fun onBindViewHolder(holder: HeroListViewHolder, position: Int) {
        holder.showCharacters(list[position])
        holder.itemView.setOnClickListener{
            onClick(list[position])
        }
    }

    override fun getItemCount() = list.size

    fun setList(list: ArrayList<CharacterInfo>){
        this.list = list
        notifyDataSetChanged()
    }


}