package be.vives.pokechamp.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import be.vives.pokechamp.MockupUserDB
import be.vives.pokechamp.User

class MainViewModel : ViewModel() {
    private var _user: MutableLiveData<User> = MutableLiveData()
    val user: LiveData<User>
    get() {
        return _user
    }
    private var _navigateToPokedex: MutableLiveData<Boolean> = MutableLiveData()
    val navigateToPokedex: LiveData<Boolean>
    get() {
        return _navigateToPokedex
    }

    fun pokedexClicked(){
        _navigateToPokedex.value = true
    }

    fun navigateToPokedexFinished(){
        _navigateToPokedex.value = false
    }

    private var _navigateToLogin: MutableLiveData<Boolean> = MutableLiveData()
    val navigateToLogin: LiveData<Boolean>
        get() {
            return _navigateToLogin
        }

    fun loginClicked(){
        _navigateToLogin.value = true
    }

    private var _navigateToUsers: MutableLiveData<Boolean> = MutableLiveData()
    val navigateToUsers: LiveData<Boolean>
    get() {
        return _navigateToUsers
    }

    fun usersClicked(){
        _navigateToUsers.value = true
    }
    fun navigateToUsersFinished(){
        _navigateToUsers.value = false
    }

    init {
        _user.value = MockupUserDB().getUser()
        _navigateToPokedex.value = false
        _navigateToLogin.value = false
        _navigateToUsers.value = false
    }
}