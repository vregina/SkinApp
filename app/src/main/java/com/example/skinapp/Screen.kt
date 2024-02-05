package com.example.skinapp

sealed class Screen(val route: String) {
    object RecoverPasswordScreen: Screen("recover_password_screen")
    object RecoverPasswordCodeScreen: Screen("recover_password_code_screen")

    fun withArgs(vararg args: String) : String {
        return buildString {
            append(route)
            args.forEach {arg ->
                append("/$arg")
            }
        }
    }
}