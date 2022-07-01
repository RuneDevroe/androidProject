package be.vives.pokechamp.pokedex

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import be.vives.pokechamp.ListPokemonAdapter
import be.vives.pokechamp.PokemonClickListener
import be.vives.pokechamp.R
import be.vives.pokechamp.databinding.PokedexFragmentBinding
import be.vives.pokechamp.model.Results

class PokedexFragment : Fragment() {


    private lateinit var viewModel: PokedexViewModel
    private lateinit var binding: PokedexFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.pokedex_fragment, container, false)
        viewModel = ViewModelProvider(this).get(PokedexViewModel::class.java)
        binding.viewmodel = viewModel


        val adapter = ListPokemonAdapter(PokemonClickListener {
            viewModel.clickPokemon(it)
        })

        binding.listPokemon.adapter = adapter

        val manager = LinearLayoutManager(activity)
        binding.listPokemon.layoutManager = manager


        viewModel.pokeBase.observe(viewLifecycleOwner, Observer {
            it?.let {

            }
        })
        viewModel.poke.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        viewModel.pokemonDetail.observe(viewLifecycleOwner, Observer { result ->
            result?.let {
                requireView().findNavController().navigate(PokedexFragmentDirections.actionPokedexFragmentToPokemonDetailFragment(result))
                viewModel.onPokemonDetailNavigated()
            }
        })

        return binding.root

    }

}