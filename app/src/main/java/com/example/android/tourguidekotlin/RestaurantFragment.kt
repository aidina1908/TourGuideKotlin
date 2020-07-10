package com.example.android.tourguidekotlin


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView

/**
 * A simple [Fragment] subclass.
 */
class RestaurantFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView : View = inflater.inflate(R.layout.item_listview,container,false)

        val item = arrayListOf<Item>()
        item.add(Item(getString(R.string.burger_king_title),
            R.drawable.burgerking, getString(R.string.burger_king_location),
            Integer.parseInt(getString(R.string.burger_king_review)),R.string.mandalay_bay_overview.toString(),
            R.string.bellagio_phone.toString(), R.string.wynn_website.toString()))

        item.add(Item(getString(R.string.gordon_ramsey_title),
            R.drawable.gordonramsey, getString(R.string.gordon_ramsey_location),
            Integer.parseInt(getString(R.string.gordon_ramsey_review)),R.string.mandalay_bay_overview.toString(),
            R.string.bellagio_phone.toString(), R.string.wynn_website.toString()))

        item.add(Item(getString(R.string.mon_ami_title),
            R.drawable.monami, getString(R.string.mon_ami_location),
            Integer.parseInt(getString(R.string.mon_ami_review)),R.string.mandalay_bay_overview.toString(),
            R.string.bellagio_phone.toString(), R.string.wynn_website.toString()))

        item.add(Item(getString(R.string.minus_five_title),
            R.drawable.minusfive, getString(R.string.minus_five_location),
            Integer.parseInt(getString(R.string.minus_five_review)),R.string.mandalay_bay_overview.toString(),
            R.string.bellagio_phone.toString(), R.string.wynn_website.toString()))

        val adapter  = ItemAdapter(activity!!,item)

        val listView = rootView.findViewById<ListView>(R.id.list)

        listView.adapter = adapter

        listView.setOnItemClickListener {parent, view, position, id ->
            val currentItem = item.get(position)
            val itemDetailIntent = Intent(context, ItemDetails::class.java)
            itemDetailIntent.putExtra(getString(R.string.intent_extra_item_title),
                currentItem.itemTitle)
            startActivity(itemDetailIntent)
        }

        return rootView
    }
}