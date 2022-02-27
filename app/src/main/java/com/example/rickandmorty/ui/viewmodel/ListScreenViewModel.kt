package com.example.rickandmorty.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.Character
import com.example.rickandmorty.data.repository.RickyMortyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListScreenViewModel
@Inject constructor(private val repository: RickyMortyRepository) : ViewModel() {

    private val _characters = MutableLiveData<List<Character>>()

    fun getCharacters(): LiveData<List<Character>>{
        viewModelScope.launch(Dispatchers.IO) {
            val characters = repository.getCharacters()
            _characters.postValue(characters)
        }
        return _characters
    }



}