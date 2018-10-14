package conselheiro.antonio.registerapp

import android.util.Log
import conselheiro.antonio.registerapp.model.LoginResponse
import conselheiro.antonio.registerapp.model.User
import conselheiro.antonio.registerapp.retrofit.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginWebClient {

    fun login(user: User, callbackResponse: LoginResponse<String>){
        val call = RetrofitInitializer().loginService().login(user)
        call.enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.e("Deu ruim.", t?.message)
            }

            override fun onResponse(call: Call<User?>?, response: Response<User?>?) {
                response?.body()?.let {
                    val user = it
                    callbackResponse.success(user.toString())
                }
            }
        })
    }

}