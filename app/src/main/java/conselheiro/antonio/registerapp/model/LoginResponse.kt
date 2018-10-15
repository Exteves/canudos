package conselheiro.antonio.registerapp.model

interface LoginResponse<T> {
    fun success(token : User)
}