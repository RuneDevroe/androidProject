package be.vives.pokechamp.pokemonDetail

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import be.vives.pokechamp.model.Pokemon
import be.vives.pokechamp.model.Results
import be.vives.pokechamp.network.PokeApi
import kotlinx.coroutines.launch
import java.net.URL

class PokemonDetailViewModel(var results: Results) : ViewModel() {

    private var _name = MutableLiveData<String>()
    val name : LiveData<String>
    get() {
        println(_name)
        println("------------------------")
        return _name
    }

    private var _url =  MutableLiveData<String>()
    val url : LiveData<String>
        get() {
            return _url
        }

    private var _pokeDetailPictureURL = MutableLiveData<String>()
    val pokeDetailPictureURL : LiveData<String>
        get() {
            return _pokeDetailPictureURL
        }

    private var _pokeDetail = MutableLiveData<Pokemon>()
    val pokeDetail: LiveData<Pokemon>
        get() {
            println("pokedetail--------------------")
            println(_pokeDetail.value)
            return _pokeDetail
        }


    init {
        println("init")
        println(results)
        _url.value = results.url
        _name.value = results.name
        viewModelScope.launch {
            try {
                println("try")
                _pokeDetailPictureURL.value = PokeApi.retrofitService.getPokemonInfo(results.name).sprites.front_default
                println("pokeDetailPictureUrl: ")
                println(_pokeDetailPictureURL.value)
                _pokeDetail.value = PokeApi.retrofitService.getPokemonInfo(results.name)
                println(_pokeDetail.value)
                println("done try")
            } catch (e: Exception) {
                println(e)
            }
        }
    }


}