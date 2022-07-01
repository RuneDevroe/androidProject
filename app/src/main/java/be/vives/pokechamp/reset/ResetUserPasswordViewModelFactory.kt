package be.vives.pokechamp.reset

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import be.vives.pokechamp.User
import java.lang.IllegalArgumentException

class ResetUserPasswordViewModelFactory(private val user: User) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T{
        if(modelClass.isAssignableFrom(ResetUserPasswordViewModel::class.java)){
            return ResetUserPasswordViewModel(user) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}