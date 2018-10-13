package conselheiro.antonio.registerapp.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import conselheiro.antonio.registerapp.R
import conselheiro.antonio.registerapp.model.House
import kotlinx.android.synthetic.main.activity_house_item.view.*

class HouseListAdapter(
        private val houses : List<House>,
        private val context : Context) : Adapter<HouseListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val house = houses[position]
        holder.bindView(house)
    }

    override fun onCreateViewHolder( parent : ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_house_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() : Int{
        return houses.size
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bindView(house : House){

            val title = itemView.house_item_title
            val lord = itemView.house_item_lord

            title.text = house.name
            lord.text = house.currentLord
        }
    }

}