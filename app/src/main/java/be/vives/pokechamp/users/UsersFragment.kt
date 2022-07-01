package be.vives.pokechamp.users

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import be.vives.pokechamp.R
import be.vives.pokechamp.User
import be.vives.pokechamp.databinding.UsersFragmentBinding
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.android.synthetic.main.users_fragment.*

class UsersFragment : Fragment() {

    private lateinit var viewModel: UsersViewModel
    private lateinit var binding: UsersFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(UsersViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.users_fragment, container, false )

       //binding = listUsers.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))


        val adapter = UserAdapter(UserClickListener {
        viewModel.clickUser(it)
        })

        viewModel.users.observe(viewLifecycleOwner, Observer {
            it?.let{
                adapter.submitList(it)

            }
        })

        binding.listUser.adapter = adapter
        val manager = LinearLayoutManager(activity)
        binding.listUser.layoutManager = manager
        return binding.root
    }

}