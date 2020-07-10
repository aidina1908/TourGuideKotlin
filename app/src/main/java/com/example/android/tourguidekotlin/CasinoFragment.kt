package com.example.android.tourguidekotlin


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import kotlinx.android.synthetic.main.fragment_casino.*
import kotlinx.android.synthetic.main.item_listview.*

/**
 * A simple [Fragment] subclass.
 */
class CasinoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView : View = inflater.inflate(R.layout.item_listview,container,false)

        val item = arrayListOf<Item>()
        item.add(Item(getString(R.string.aria_title),
            R.drawable.aria, getString(R.string.aria_location),
            Integer.parseInt(getString(R.string.aria_review)),
            R.string.aria_overview.toString(), R.string.bellagio_phone.toString(), R.string.wynn_website.toString()))

        item.add(Item(getString(R.string.cosmopolitan_title),
            R.drawable.cosmopolitan, getString(R.string.cosmopolitan_location),
            Integer.parseInt(getString(R.string.aria_review)), R.string.cosmopolitan_overview.toString(),
            R.string.bellagio_phone.toString(), R.string.wynn_website.toString()
        ))

        item.add(Item(getString(R.string.encor_title),
            R.drawable.encore, getString(R.string.encor_location),
            Integer.parseInt(getString(R.string.encor_review)), R.string.encor_overview.toString(),
            R.string.bellagio_phone.toString(), R.string.wynn_website.toString()
        ))

        item.add(Item(getString(R.string.mandalay_bay_title),
            R.drawable.mandalaybay, getString(R.string.mandalay_bay_location),
            Integer.parseInt(getString(R.string.mandalay_bay_review)), R.string.mandalay_bay_overview.toString(),
            R.string.bellagio_phone.toString(), R.string.wynn_website.toString()
        ))

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
