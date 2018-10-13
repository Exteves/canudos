package conselheiro.antonio.registerapp

import conselheiro.antonio.registerapp.model.User
import retrofit2.Call
import retrofit2.http.POST

interface LoginService {
    @POST("login")
    fun login() : Call<List<User>>
}