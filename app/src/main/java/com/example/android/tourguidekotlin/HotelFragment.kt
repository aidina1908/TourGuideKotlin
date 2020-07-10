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
class HotelFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView : View = inflater.inflate(R.layout.item_listview,container,false)

        val item = arrayListOf<Item>()
        item.add(Item(getString(R.string.bellagio_title),
            R.drawable.bellagio, getString(R.string.bellagio_location),
            Integer.parseInt(getString(R.string.bellagio_review)),R.string.xs_overview.toString(),
            R.string.bellagio_phone.toString(), R.string.bellagio_website.toString()))

        item.add(Item(getString(R.string.luxor_title),
            R.drawable.luxor, getString(R.string.luxor_location),
            Integer.parseInt(getString(R.string.luxor_review)),R.string.mandalay_bay_overview.toString(),
            R.string.bellagio_phone.toString(), R.string.wynn_website.toString()))

        item.add(Item(getString(R.string.palazzo_title),
            R.drawable.palazzo, getString(R.string.palazzo_location),
            Integer.parseInt(getString(R.string.palazzo_review)),R.string.mandalay_bay_overview.toString(),
            R.string.bellagio_phone.toString(), R.string.wynn_website.toString()))

        item.add(Item(getString(R.string.wynn_title),
            R.drawable.wynn, getString(R.string.wynn_location),
            Integer.parseInt(getString(R.string.wynn_review)),R.string.mandalay_bay_overview.toString(),
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