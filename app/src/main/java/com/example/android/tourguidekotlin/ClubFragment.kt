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
class ClubFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView : View = inflater.inflate(R.layout.item_listview,container,false)

        val item = arrayListOf<Item>()
        item.add(Item(getString(R.string.drais_title),
            R.drawable.drias, getString(R.string.drais_location),
            Integer.parseInt(getString(R.string.drais_review)),R.string.drais_overview.toString(),
            R.string.bellagio_phone.toString(), R.string.wynn_website.toString()))

        item.add(Item(getString(R.string.hakkasan_title),
            R.drawable.hakkasan, getString(R.string.hakkasan_location),
            Integer.parseInt(getString(R.string.hakkasan_review)),R.string.hakkasan_overview.toString(),
            R.string.bellagio_phone.toString(), R.string.wynn_website.toString()))

        item.add(Item(getString(R.string.omnia_title),
            R.drawable.omnia, getString(R.string.omnia_location),
            Integer.parseInt(getString(R.string.omnia_review)),R.string.omnia_overview.toString(),
            R.string.bellagio_phone.toString(), R.string.wynn_website.toString()))

        item.add(Item(getString(R.string.xs_title),
            R.drawable.xs, getString(R.string.xs_location),
            Integer.parseInt(getString(R.string.xs_review)),R.string.xs_overview.toString(),
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
