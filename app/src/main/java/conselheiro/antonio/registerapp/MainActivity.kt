package conselheiro.antonio.registerapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import conselheiro.antonio.registerapp.model.User
import conselheiro.antonio.registerapp.retrofit.RetrofitInitializer
import conselheiro.antonio.registerapp.ui.activity.Home
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RetrofitInitializer().loginService().login()

        val call = RetrofitInitializer().loginService().login()
        call.enqueue(object : Callback<List<User>>{
            override fun onResponse(call: Call<List<User>?>?, response: Response<List<User>?>?) {

                response?.body()?.let{
                    val tokenUser : List<User> = it
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.e("onFailure error", t?.message)
            }
        })


        getIn.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
    }
}
