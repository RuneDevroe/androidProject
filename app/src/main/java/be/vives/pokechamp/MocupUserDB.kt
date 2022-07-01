package be.vives.pokechamp

import be.vives.pokechamp.model.Results

class MockupUserDB {

    fun getUser(): User{
        return User("rune","rune devroe","password")
    }

    fun getUsers(): List<User> {
        val users = arrayOf(User("username3","name3","password"),User("usernameTest","nameTest","password"),User("username1","name1","password"),User("username2","name2","password"))
        return users.toList()
    }

}