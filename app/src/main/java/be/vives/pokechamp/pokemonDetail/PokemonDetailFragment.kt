package be.vives.pokechamp.pokemonDetail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import be.vives.pokechamp.R
import be.vives.pokechamp.databinding.PokemonDetailFragmentBinding

class PokemonDetailFragment : Fragment() {

    private lateinit var viewModel: PokemonDetailViewModel
    private lateinit var modelFactory: PokemonDetailViewmodelFactory
    private lateinit var binding: PokemonDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.pokemon_detail_fragment, container, false )

        var result = PokemonDetailFragmentArgs.fromBundle(arguments!!)
        modelFactory = PokemonDetailViewmodelFactory(result.result)
        viewModel = ViewModelProviders.of(this, modelFactory).get(PokemonDetailViewModel::class.java)
        binding.data = viewModel


        viewModel.pokeDetail.observe(viewLifecycleOwner, Observer {
            it?.let {
                println("test pokedetail")
            }
        })

        return binding.root
    }

}