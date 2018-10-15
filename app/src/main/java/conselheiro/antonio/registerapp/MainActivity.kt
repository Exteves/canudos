package conselheiro.antonio.registerapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import conselheiro.antonio.registerapp.model.LoginResponse
import conselheiro.antonio.registerapp.model.User
import conselheiro.antonio.registerapp.ui.activity.Home
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var tokenLoginValue : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val session = SessionManager(applicationContext)

        if (session.isLoggedIn()){
            var i: Intent = Intent(applicationContext, Home::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(i)
            finish()
        }

        getIn.setOnClickListener{
            val usrname  = username.text
            val pwd = password.text

            val user = User(usrname.toString(), pwd.toString())

            LoginWebClient().login(user, object : LoginResponse<User> {
                override fun success(user: User) {
                    session.createLoginSession(user.email, user.token)
                    Toast.makeText(this@MainActivity, user.email, Toast.LENGTH_LONG).show()
                }
            })
        }
    }
}
