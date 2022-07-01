package be.vives.pokechamp.reset

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import be.vives.pokechamp.User

class ResetUserPasswordViewModel(var __user: User) : ViewModel() {
    private var _user: MutableLiveData<User> = MutableLiveData()
    val user: LiveData<User>
        get() {
            return _user
        }

    var currentPassword =  MutableLiveData<String>()
    var newPassword =  MutableLiveData<String>()
    var repeatCurrentPassword =  MutableLiveData<String>()
    var error = MutableLiveData<Boolean>()
    var errorText = MutableLiveData<String>()
    var passwordResetText = MutableLiveData<String>()

    init {
        _user.value = __user
        currentPassword.value = ""
        newPassword.value = ""
        repeatCurrentPassword.value = ""
        error.value = false
        errorText.value = ""

    }

    fun buttonResetPasswordClicked() {
        if (currentPassword.value.equals(user.value!!.password)){
            if (newPassword.value.equals(repeatCurrentPassword.value)){
                _user.value!!.password = newPassword.value!!
                currentPassword.value = ""
                newPassword.value = ""
                repeatCurrentPassword.value = ""
                passwordResetText.value = "Nieuw paswoord is ingesteld"
            }
            else{
                errorText.value = "Nieuw en herhaling nieuw paswoord zijn niet aan elkaar gelijk"
                repeatCurrentPassword.value = ""
                error.value = true
            }
        } else{
            errorText.value ="Huidig paswoord is niet correct"
            currentPassword.value = ""
            error.value = true
        }
    }
    fun errorMessageHandled(){
        error.value = false
        errorText.value = ""
    }
}