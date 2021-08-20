package com.reakabc.fabcoders.Adapters

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.reakabc.fabcoders.DetailsActivity
import com.reakabc.fabcoders.Modals.Drink
import com.reakabc.fabcoders.R


class DrinkAdapter(private var drinks: List<Drink>, private val context: Context) :
    RecyclerView.Adapter<DrinkAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.list_item_drink, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return drinks.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val drink = drinks[position]

        Glide.with(context).load(drink.strDrinkThumb).into(holder.image)
        holder.title.text = drink.strDrink

        holder.layout.setOnClickListener(View.OnClickListener {

            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("title", drink.strDrink)
            intent.putExtra("image", drink.strDrinkThumb)
            intent.putExtra("instructions", drink.strInstructions)
            intent.putExtra("glass", drink.strGlass)

            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                context as Activity,
                holder.image,
                "drink_image"
            )
            context.startActivity(intent, options.toBundle())

        })

    }


    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {

        var title: TextView
        var image: ImageView
        var layout: CardView

        init {

            title = itemLayoutView.findViewById(R.id.tv_title)
            image = itemLayoutView.findViewById(R.id.iv_drink)
            layout = itemLayoutView.findViewById(R.id.layout)

        }

    }

}