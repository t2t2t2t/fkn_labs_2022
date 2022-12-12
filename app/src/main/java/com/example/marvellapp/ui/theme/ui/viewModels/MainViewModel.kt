package com.example.marvel_app_android.ui.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel_app_android.api.onError
import com.example.marvel_app_android.api.onException
import com.example.marvel_app_android.api.onSuccess
import com.example.marvel_app_android.data.Hero
import com.example.marvel_app_android.data.HeroState
import com.example.marvel_app_android.repository.DatabaseSource
import com.example.marvel_app_android.repository.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val networkRepository: NetworkRepository,
    private val dataRepository: DatabaseSource
) :
    ViewModel() {
    private val _heroes =
        MutableStateFlow<HeroState<List<Hero>>>(HeroState<List<Hero>>(emptyList(), true))
    val heroes: StateFlow<HeroState<List<Hero>>> = _heroes.asStateFlow()

    init {
        getAllHeroes()
    }

    private fun getAllHeroes() {
        viewModelScope.launch() {
            val response = networkRepository.getAllHeroes()
            response.onSuccess { heroesList ->
                val result = heroesList.data.heroes.map { it.toHero() }
                dataRepository.insertHeroes(result)
                _heroes.update { HeroState(result, false) }
            }
                .onError { code, message ->
                    val deferred = async { dataRepository.getHeroes() }
                    val result = deferred.await()
                    _heroes.update { HeroState(result, false, "Ошибка $message $code") }
                }
                .onException { error ->
                    val deferred = async { dataRepository.getHeroes() }
                    val result = deferred.await()
                    _heroes.update { HeroState(result, false, "Ошибка $error ") }

                }
        }
    }

    private val _hero = MutableStateFlow<HeroState<Hero>>(HeroState(Hero(0, "", "", ""), false))
    val hero: StateFlow<HeroState<Hero>> = _hero.asStateFlow()

    fun getHero(id: Int) {
        viewModelScope.launch() {
            val response = networkRepository.getHero(id)
            response.onSuccess {
                val result = it.data.heroes.first().toHero()
                _hero.update { HeroState(result, true) }
            }
                .onException { e ->
                    _hero.update { HeroState(dataRepository.getHeroCached(id), true, e.message) }
                }
                .onError { code, message ->
                    _hero.update {
                        HeroState(dataRepository.getHeroCached(id), true, "Error $code : $message")
                    }
                }
        }
    }



    val colors = listOf(
        Color(0xFF602325),
        Color.Red,
        Color(0xFF0B0E17),
        Color(0xFF510412),
        Color(0xFF3D464E),
        Color.LightGray,
        Color(0xFF2A3436)

    )

    var backgroundColor by  mutableStateOf(Color.Yellow)

    var snapedItem by mutableStateOf(0)

    fun setColor( col : Int){
        backgroundColor = colors[col]
    }

}
