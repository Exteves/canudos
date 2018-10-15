package conselheiro.antonio.registerapp.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import conselheiro.antonio.registerapp.R
import conselheiro.antonio.registerapp.SessionManager

class Home : AppCompatActivity() {

    lateinit var session: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        session = SessionManager(applicationContext)

        session.checkLogin()

        var user : HashMap<String, String> = session.getUserDetails()

        var email : String = user.get(SessionManager.KEY_EMAIL)!!

        var token : String = user.get(SessionManager.KEY_TOKEN)!!
    }
}
