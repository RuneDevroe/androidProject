package be.vives.pokechamp.reset

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import be.vives.pokechamp.R
import be.vives.pokechamp.databinding.ResetUserPasswordFragmentBinding

class ResetUserPasswordFragment : Fragment() {


    private lateinit var viewModel: ResetUserPasswordViewModel
    private lateinit var binding: ResetUserPasswordFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.reset_user_password_fragment, container, false )
        val args : ResetUserPasswordFragmentArgs = ResetUserPasswordFragmentArgs.fromBundle(requireArguments())
        val fact = ResetUserPasswordViewModelFactory(args.user)
        viewModel = ViewModelProvider(this, fact).get(ResetUserPasswordViewModel::class.java)
        binding.myModel = viewModel

        viewModel.error.observe(viewLifecycleOwner, Observer {
            if(it){
                showError()
            }
        })
        viewModel.passwordResetText.observe(viewLifecycleOwner, Observer {
            if(it.isNotEmpty() ){
                Toast.makeText(context,it,Toast.LENGTH_LONG).show()
                parentFragmentManager.popBackStack()
            }
        })
        binding.setLifecycleOwner(this)
        return binding.root

    }

    fun showError(){
        val error = viewModel.errorText.value
        Toast.makeText(context, error, Toast.LENGTH_LONG).show()
        viewModel.errorMessageHandled()
    }

}