package conselheiro.antonio.registerapp.retrofit

import conselheiro.antonio.registerapp.model.LoginService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer (val url : String){
    private val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun loginService () : LoginService = retrofit.create(LoginService::class.java)
}