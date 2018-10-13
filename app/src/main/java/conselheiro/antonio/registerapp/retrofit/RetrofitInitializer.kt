package conselheiro.antonio.registerapp.retrofit

import conselheiro.antonio.registerapp.model.LoginService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {
    private val retrofit = Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun loginService () : LoginService = retrofit.create(LoginService::class.java)
}