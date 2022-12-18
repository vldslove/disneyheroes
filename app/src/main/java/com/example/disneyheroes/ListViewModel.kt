package com.example.disneyheroes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel : ViewModel(){

    val listChar = MutableLiveData<ArrayList<CharacterInfo>>()

    val repository = CharactersRepository()

    fun getChars(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getAllCharacters()
            if (response.isSuccessful) {
                listChar.postValue(
                    (response.body()?.data ?: arrayListOf()) as ArrayList<CharacterInfo>?
                )
            } else {
                response.errorBody()
            }
        }
    }
}