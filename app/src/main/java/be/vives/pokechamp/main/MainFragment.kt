package be.vives.pokechamp.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import be.vives.pokechamp.R
import be.vives.pokechamp.databinding.MainFragmentBinding

class MainFragment : Fragment() {


    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        val fact = MainViewModelFactory()
        viewModel = ViewModelProvider(this, fact).get(MainViewModel::class.java)
        viewModel.navigateToPokedex.observe(viewLifecycleOwner, Observer {
            if (it){
               navigateToPokedex()
            }
        })
        binding.myModel = viewModel

        viewModel.navigateToLogin.observe(viewLifecycleOwner, Observer {
            if (it){
                navigateToLogin()
            }
        })

        viewModel.navigateToUsers.observe(viewLifecycleOwner, Observer {
            if (it){
                navigateToUsers()
            }
        })
        return binding.root
    }

    fun navigateToPokedex(){
        requireView().findNavController().navigate(MainFragmentDirections.actionMainFragmentToPokedexFragment())
        viewModel.navigateToPokedexFinished()
    }

    fun navigateToLogin(){
        requireView().findNavController().navigate(MainFragmentDirections.actionMainFragmentToLoginActivity())
    }

    fun navigateToUsers(){
        requireView().findNavController().navigate(MainFragmentDirections.actionMainFragmentToUsersFragment())
        viewModel.navigateToUsersFinished()
    }

}