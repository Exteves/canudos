package conselheiro.antonio.registerapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import conselheiro.antonio.registerapp.model.LoginResponse
import conselheiro.antonio.registerapp.model.User
import conselheiro.antonio.registerapp.ui.activity.Home
import kotlinx.android.synthetic.main.activity_home.view.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        getIn.setOnClickListener{
            val usrname  = username.text
            val pwd = password.text

            val user = User(usrname.toString(), pwd.toString())

            LoginWebClient().login(user, object : LoginResponse<String> {
                override fun success(token: String) {
                    val intent = Intent(this@MainActivity, Home::class.java)
                    intent.putExtra("token", token)
                    startActivity(intent)
                }
            })
        }
    }
}
