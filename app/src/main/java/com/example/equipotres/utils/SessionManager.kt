// En C:/.../equipoTres/app/src/main/java/com/example/equipotres/utils/SessionManager.kt
package com.example.equipotres.utils

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("MyAppSession", Context.MODE_PRIVATE)
    private val editor = prefs.edit()

    companion object {
        const val IS_LOGGED_IN = "isLoggedIn"
    }

    fun login() {
        editor.putBoolean(IS_LOGGED_IN, true)
        editor.apply()
    }

    fun logout() {
        editor.putBoolean(IS_LOGGED_IN, false)
        editor.apply()
    }

    fun isLoggedIn(): Boolean {
        return prefs.getBoolean(IS_LOGGED_IN, false)
    }
}
