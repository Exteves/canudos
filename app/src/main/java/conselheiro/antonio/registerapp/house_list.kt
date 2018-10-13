package conselheiro.antonio.registerapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import conselheiro.antonio.registerapp.model.House
import kotlinx.android.synthetic.main.activity_house_list.*


class house_list : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_house_list)

        val recyclerView = house_list_recyclerview
        recyclerView.adapter = HouseListAdapter(houses(), this)
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
    }

    private fun houses() : List<House> {
        return listOf(
                House("House Stark", "Sansa Stark"),
                House("House Targaryen", "Khaleese")
        )
    }
}
