package com.example.tugas_pam_3.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tugas_pam_3.UserViewModel
import com.example.tugas_pam_3.pages.LoginPage
import com.example.tugas_pam_3.pages.RegisterPage
import com.example.tugas_pam_3.pages.ProfilePage
import com.example.tugas_pam_3.pages.AvatarPage

object Routes {
    const val LOGIN = "login"
    const val REGISTER = "register"
    const val PROFILE = "profile"
    const val AVATAR = "avatar"
}

@Composable
fun NavGraph(startDestination: String = Routes.LOGIN) {
    val navController = rememberNavController()
    val userViewModel: UserViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Routes.LOGIN) {
            LoginPage(
                onNavigateToRegister = { navController.navigate(Routes.REGISTER) },
                onNavigateToProfile = { navController.navigate(Routes.PROFILE) },
                validateLogin = { username, password ->
                    userViewModel.validateLogin(username, password)
                }
            )
        }

        composable(Routes.REGISTER) {
            RegisterPage(
                onNavigateBack = { navController.popBackStack() },
                onSaveUserData = { data -> userViewModel.saveUserData(data) }
            )
        }

        composable(Routes.PROFILE) {
            ProfilePage(
                userData = userViewModel.userData,
                onNavigateToAvatar = { navController.navigate(Routes.AVATAR) },
                onLogout = {
                    navController.navigate(Routes.LOGIN) {
                        popUpTo(Routes.LOGIN) { inclusive = true }
                    }
                }
            )
        }

        composable(Routes.AVATAR) {
            AvatarPage(onNavigateBack = { navController.popBackStack() })
        }
    }
}