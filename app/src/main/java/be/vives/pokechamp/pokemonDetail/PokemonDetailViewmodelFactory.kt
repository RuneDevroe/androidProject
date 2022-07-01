package be.vives.pokechamp.pokemonDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import be.vives.pokechamp.User
import be.vives.pokechamp.main.MainViewModel
import be.vives.pokechamp.model.Results
import be.vives.pokechamp.reset.ResetUserPasswordViewModel
import java.lang.IllegalArgumentException

class PokemonDetailViewmodelFactory (private val results: Results) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T{
        if(modelClass.isAssignableFrom(PokemonDetailViewModel::class.java)){
            return PokemonDetailViewModel(results) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
