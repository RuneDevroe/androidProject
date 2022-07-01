package be.vives.pokechamp.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import be.vives.pokechamp.R
import be.vives.pokechamp.User
import be.vives.pokechamp.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fact = LoginViewModelFactory()
        viewModel = ViewModelProvider(this, fact).get(LoginViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false )
        binding.myModel = viewModel
        viewModel.navigateToResetPassword.observe(viewLifecycleOwner, Observer {
            if (it){
                navigateToResetPassword()
            }
        })
        viewModel.error.observe(viewLifecycleOwner, Observer {
            if (it){
                showError()
            }
        })
        viewModel.loginText.observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty()){
               Toast.makeText(context,it,Toast.LENGTH_LONG).show()

            }
        })

        binding.setLifecycleOwner(this)
        return binding.root
    }

    fun navigateToResetPassword(){
        val user: User = viewModel.user.value!!
        requireView().findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToResetUserPasswordFragment(user))
        viewModel.navigateToResetPasswordFinished()
    }

    fun showError(){
        val error = viewModel.errorText.value
        Toast.makeText(context, error, Toast.LENGTH_LONG).show()
        viewModel.errorMessageHandled()
    }
}