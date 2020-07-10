package com.example.android.tourguidekotlin

import android.content.Intent
import android.net.Uri
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import kotlinx.android.synthetic.main.list_item.view.*

class ItemAdapter(context: FragmentActivity?, item:ArrayList<Item>) : ArrayAdapter<Item>(context!!,0,item) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listItemView = convertView
        if (listItemView == null){
            listItemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        }

        val currentItem = getItem(position)

           val title = listItemView!!.findViewById<TextView>(R.id.title)
           title.setText(currentItem!!.itemTitle)

            val image = listItemView!!.findViewById<ImageView>(R.id.image)
            Glide.with(listItemView).load(currentItem!!.itemImageResourseId).into(image)

            val location = listItemView!!.findViewById<TextView>(R.id.location)
            val locationString = SpannableString(currentItem!!.itemLocation)
            locationString.setSpan(UnderlineSpan(),0,locationString.length,0)
            location.setText(locationString)
            location.setOnClickListener {
                val mapIntent = Intent(Intent.ACTION_VIEW)
                mapIntent.setData(Uri.parse("geo:0,0?q="+currentItem.itemLocation))
                if(mapIntent.resolveActivity(context.packageManager)!=null) {
                    context.startActivity(mapIntent)
                }
        }

         showReview(listItemView,currentItem.itemImageResourseId)

        return listItemView
    }

    private fun showReview(listView: View, star : Int){
        val imageviewStar1 = listView.findViewById<ImageView>(R.id.review_star1)
        val imageviewStar2 = listView.findViewById<ImageView>(R.id.review_star2)
        val imageviewStar3 = listView.findViewById<ImageView>(R.id.review_star3)
        val imageviewStar4 = listView.findViewById<ImageView>(R.id.review_star4)
        val imageviewStar5 = listView.findViewById<ImageView>(R.id.review_star4)

    }

}