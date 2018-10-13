package conselheiro.antonio.registerapp

import retrofit2.http.POST

interface loginService {
    @POST("login")
    fun login()
}