package com.example.cafe.vm


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cafe.dao.Dao
import com.example.cafe.entity.Country
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(private val dao: Dao) : ViewModel() {
    private val _countries = MutableStateFlow<List<Country>>(emptyList())
    val countries: StateFlow<List<Country>> = _countries

    init {
        fetchCountries()
    }

    private fun fetchCountries() {
        viewModelScope.launch {
            val countriesList = dao.findAll<Country>()
            _countries.value = countriesList
        }
    }
}