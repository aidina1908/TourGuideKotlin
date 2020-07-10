package com.example.android.tourguidekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ItemDetails : AppCompatActivity() {

    val mItems : ArrayList<Item> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)

        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        val itemTitle = intent.getStringExtra(getString(R.string.intent_extra_item_title))
        setTitle(itemTitle)

        initItems(mItems)

        val currentItemIndex = getItemIndexByTitle(itemTitle)

        inflateLayout(currentItemIndex)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun inflateLayout(index : Int){
        val itemImage = findViewById<ImageView>(R.id.item_image)
        itemImage.setImageResource(mItems.get(index).itemImageResourseId)

        val itemTitle = findViewById<TextView>(R.id.item_title)
        itemTitle.setText(mItems.get(index).itemTitle)

        val itemOverview = findViewById<TextView>(R.id.item_overview)
        itemOverview.setText(mItems.get(index).itemOverview)

        val itemNumber = findViewById<TextView>(R.id.item_number)
        itemNumber.setText(mItems.get(index).itemNumber)

        val itemWebsite = findViewById<TextView>(R.id.item_website)
        itemWebsite.setText(mItems.get(index).itemWebSite)
    }

    private fun  getItemIndexByTitle(title : String): Int {
        try {
            for (i in 0..mItems.size){
                val currentItem = mItems[i]
                val currentTitle = currentItem.itemTitle
                if (title.equals(currentTitle)){
                    return i
                }
            }
        } catch  (error : Error){

        }
        return -1
    }

    private fun initItems(items : ArrayList<Item>){
        items.add(Item(getString(R.string.drais_title),R.drawable.drias,
            getString(R.string.drais_location),
            Integer.parseInt(getString(R.string.drais_review)),
            getString(R.string.drais_overview),
            getString(R.string.palazzo_phone),
            getString(R.string.wynn_website)))

        items.add(Item(getString(R.string.omnia_title),R.drawable.omnia,
            getString(R.string.omnia_location),Integer.parseInt(getString(R.string.drais_review)),
            getString(R.string.omnia_overview),
            getString(R.string.palazzo_phone),
            getString(R.string.wynn_website)))

        items.add(Item(getString(R.string.hakkasan_title),R.drawable.hakkasan,
            getString(R.string.hakkasan_location),Integer.parseInt(getString(R.string.drais_review)),
            getString(R.string.hakkasan_overview),
            getString(R.string.palazzo_phone),
            getString(R.string.wynn_website)))

        items.add(Item(getString(R.string.xs_title),R.drawable.xs,
            getString(R.string.xs_location),Integer.parseInt(getString(R.string.drais_review)),
            getString(R.string.xs_overview),
            getString(R.string.palazzo_phone),
            getString(R.string.wynn_website)))

        items.add(Item(getString(R.string.burger_king_title),R.drawable.burgerking,
            getString(R.string.burger_king_location),Integer.parseInt(getString(R.string.burger_king_review)),
            getString(R.string.burger_king_overview),
            getString(R.string.burger_king_phone),
            getString(R.string.burgerking_website)))

        items.add(Item(getString(R.string.gordon_ramsey_title),R.drawable.gordonramsey,
            getString(R.string.gordon_ramsey_location),Integer.parseInt(getString(R.string.gordon_ramsey_review)),
            getString(R.string.gordon_ramsey_overview),
            getString(R.string.gordon_ramsey_phone),
            getString(R.string.gordon_website)))

        items.add(Item(getString(R.string.mon_ami_title),R.drawable.monami,
            getString(R.string.mon_ami_location),Integer.parseInt(getString(R.string.mon_ami_review)),
            getString(R.string.mon_ami_overview),
            getString(R.string.mon_ami_phone),
            getString(R.string.monami_website)))

        items.add(Item(getString(R.string.minus_five_title),R.drawable.minusfive,
            getString(R.string.minus_five_location),Integer.parseInt(getString(R.string.minus_five_review)),
            getString(R.string.minus_five_overview),
            getString(R.string.minus_five_phone),
            getString(R.string.minusfive_website)))

        items.add(Item(getString(R.string.aria_title),R.drawable.aria,
            getString(R.string.aria_location),Integer.parseInt(getString(R.string.aria_review)),
            getString(R.string.aria_overview),
            getString(R.string.palazzo_phone),
            getString(R.string.wynn_website)))

        items.add(Item(getString(R.string.cosmopolitan_title),R.drawable.cosmopolitan,
            getString(R.string.cosmopolitan_location),Integer.parseInt(getString(R.string.cosmopolitan_review)),
            getString(R.string.cosmopolitan_overview),
            getString(R.string.palazzo_phone),
            getString(R.string.wynn_website)))

        items.add(Item(getString(R.string.encor_title),R.drawable.encore,
            getString(R.string.encor_location),Integer.parseInt(getString(R.string.encor_review)),
            getString(R.string.encor_overview),
            getString(R.string.palazzo_phone),
            getString(R.string.wynn_website)))

        items.add(Item(getString(R.string.mandalay_bay_title),R.drawable.mandalaybay,
            getString(R.string.mandalay_bay_location),Integer.parseInt(getString(R.string.mandalay_bay_review)),
            getString(R.string.mandalay_bay_overview),
            getString(R.string.palazzo_phone),
            getString(R.string.wynn_website)))

        items.add(Item(getString(R.string.bellagio_title),R.drawable.bellagio,
            getString(R.string.bellagio_location),Integer.parseInt(getString(R.string.bellagio_review)),
            getString(R.string.drais_overview),
            getString(R.string.bellagio_phone),
            getString(R.string.bellagio_website)))

        items.add(Item(getString(R.string.luxor_title),R.drawable.luxor,
            getString(R.string.luxor_location),Integer.parseInt(getString(R.string.luxor_review)),
            getString(R.string.drais_overview),
            getString(R.string.luxor_phone),
            getString(R.string.luxor_website)))

        items.add(Item(getString(R.string.palazzo_title),R.drawable.palazzo,
            getString(R.string.palazzo_location),Integer.parseInt(getString(R.string.palazzo_review)),
            getString(R.string.drais_overview),
            getString(R.string.palazzo_phone),
            getString(R.string.palazzo_website)))

        items.add(Item(getString(R.string.wynn_title),R.drawable.wynn,
            getString(R.string.wynn_location),Integer.parseInt(R.string.wynn_review.toString()),
            getString(R.string.drais_overview),
            getString(R.string.wynn_phone),
            getString(R.string.wynn_website)))

    }
}
