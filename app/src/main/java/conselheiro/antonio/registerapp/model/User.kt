package conselheiro.antonio.registerapp.model

class User(
        val email : String,
        val password : String
    ){
        lateinit var token : String
    }