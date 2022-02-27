package com.example.rickandmorty.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.repository.RickyMortyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel
@Inject constructor(
    private val repository: RickyMortyRepository) : ViewModel() {
}