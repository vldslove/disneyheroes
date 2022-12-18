package com.example.disneyheroes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterDescriptionViewModel : ViewModel() {

    val repository = CharactersRepository()

    val listChar = MutableLiveData<ArrayList<CharacterInfo>>()

    fun getCharacter(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getCharacter()
            if (response.isSuccessful){
                listChar.postValue((response.body()?.data  as ArrayList<CharacterInfo>))
            } else {
                response.errorBody()
            }
        }
    }
}