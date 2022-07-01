package be.vives.pokechamp.pokedex

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import be.vives.pokechamp.MockupUserDB
import be.vives.pokechamp.model.PokeBase
import be.vives.pokechamp.model.Pokemon
import be.vives.pokechamp.model.Results
import be.vives.pokechamp.network.PokeApi
import kotlinx.coroutines.launch

class PokedexViewModel : ViewModel() {

    private var _pokeBase = MutableLiveData<PokeBase>()
    val pokeBase: LiveData<PokeBase>
    get() {
        return _pokeBase
    }

    private var _pokemonDetail = MutableLiveData<Results>()
    val pokemonDetail: LiveData<Results>
    get() {
        return _pokemonDetail
    }


    private var _poke : MutableLiveData<List<Results>> = MutableLiveData()
    val poke: LiveData<List<Results>>
    get() {
        return _poke
    }

    fun clickPokemon(result: Results){
        _pokemonDetail.value = result
    }

    fun onPokemonDetailNavigated(){
        _pokemonDetail.value = null
    }

    init {
        viewModelScope.launch {
            try {
                _pokeBase.value = PokeApi.retrofitService.getName()
                _poke.value = PokeApi.retrofitService.getName().results
                //_info.value = PokeApi.retrofitService.getPokemonInfo()
                println("--------------")
                println(_pokeBase.value)
                println("--------------")
                println(_poke.value)
                println("--------------")
                //println(_info.value)

            } catch (e: Exception) {
                println(e)
            }
        }

        }



}
