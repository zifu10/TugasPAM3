package com.example.tugas_pam_3

import androidx.lifecycle.ViewModel

data class UserData(
    val firstName: String = "",
    val lastName: String = "",
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val phoneNumber: String = "",
    val address: String = "",
    val birthDate: String = ""
)

class UserViewModel : ViewModel() {
    var userData: UserData = UserData()
        private set

    // Simpan data dari RegisterPage
    fun saveUserData(data: UserData) {
        userData = data
    }

    // Validasi login berdasarkan username & password
    fun validateLogin(inputUsername: String, inputPassword: String): Boolean {
        return inputUsername == userData.username && inputPassword == userData.password
    }
}