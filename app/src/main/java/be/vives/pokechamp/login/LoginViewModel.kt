package be.vives.pokechamp.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import be.vives.pokechamp.MockupUserDB
import be.vives.pokechamp.User

class LoginViewModel : ViewModel() {
    private var _user: MutableLiveData<User> = MutableLiveData()
    val user: LiveData<User>
        get() {
            return _user
        }

    var username = MutableLiveData<String>()
    var password = MutableLiveData<String>()
    var error = MutableLiveData<Boolean>()
    var errorText = MutableLiveData<String>()
    var loginText = MutableLiveData<String>()

    init {
        username.value = ""
        password.value = ""
        error.value = false
        errorText.value = ""
        loginText.value = ""
    }

    fun buttonLoginClicked(){
        if (username.value.equals(user.value!!.username)){
            if (password.value.equals(user.value!!.password)){
                loginText.value = "ingelogd"
            }
            else{
                password.value = ""
                loginText.value = "wachtwoord is verkeerd"
                error.value = true
            }
        }
        else{
            username.value = ""
            password.value = ""
            loginText.value = "gebruikersnaam bestaat niet"
            error.value = true
        }
    }

    fun errorMessageHandled(){
        error.value = false
        errorText.value = ""
    }


    private var _navigateToResetPassword: MutableLiveData<Boolean> = MutableLiveData()
    val navigateToResetPassword: LiveData<Boolean>
    get() {
        return _navigateToResetPassword
    }
    fun resetPasswordClicked(){
        _navigateToResetPassword.value = true
    }
    fun navigateToResetPasswordFinished(){
        _navigateToResetPassword.value = false
    }

    init {
        _navigateToResetPassword.value = false
        _user.value = MockupUserDB().getUser()
    }
}