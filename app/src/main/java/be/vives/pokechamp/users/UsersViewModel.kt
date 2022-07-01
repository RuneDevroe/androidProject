package be.vives.pokechamp.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import be.vives.pokechamp.MockupUserDB
import be.vives.pokechamp.User

class UsersViewModel : ViewModel() {
    private var _users : MutableLiveData<List<User>> = MutableLiveData()
    val users : LiveData<List<User>>
    get() {
        return _users
    }

    private var _user : MutableLiveData<User> = MutableLiveData()
    val user : LiveData<User>
    get() {
            return _user
    }

    init {
        _users.value = MockupUserDB().getUsers()
        println("------------------------")
        println(_users.value)
        println("------------------------")
    }

    fun clickUser(user: User){
        _user.value = user
    }
}