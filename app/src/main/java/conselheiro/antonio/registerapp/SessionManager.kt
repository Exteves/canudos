package conselheiro.antonio.registerapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences

class SessionManager {
    lateinit var pref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    lateinit var con : Context
    var PRIVATE_MODE: Int = 0

    constructor(con : Context){
        this.con = con
        pref = con.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref.edit()
    }

    companion object {
        val PREF_NAME: String = "LoginData"
        val IS_LOGIN: String = "isLoggedIn"
        val KEY_EMAIL: String = "email"
        val KEY_TOKEN: String = "token"
    }

    fun createLoginSession(email : String, token: String){
        editor.putBoolean(IS_LOGIN, true)
        editor.putString(KEY_EMAIL, email)
        editor.putString(KEY_TOKEN, token)
        editor.commit()
    }

    fun getUserDetails(): HashMap<String, String> {
        var user: Map<String, String> = HashMap<String, String>()
        (user as HashMap).put(KEY_EMAIL, pref.getString(KEY_EMAIL, null))
        (user as HashMap).put(KEY_TOKEN, pref.getString(KEY_TOKEN, null))

        return user
    }

    fun LogoutUser(){
        editor.clear()
        editor.commit()

        var i: Intent = Intent(con, MainActivity::class.java)
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        con.startActivity(i)
    }

    fun isLoggedIn(): Boolean{
        return pref.getBoolean(IS_LOGIN, false)
    }

    fun checkLogin(){
        if (!isLoggedIn()){
            var i: Intent = Intent(con, MainActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            con.startActivity(i)
        }
    }
}