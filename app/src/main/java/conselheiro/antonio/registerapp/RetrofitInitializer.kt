package conselheiro.antonio.registerapp

import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {
    init{
        val retrofit = Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}