package com.reakabc.fabcoders

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.ProgressBar
import android.widget.SearchView
import android.widget.TextView

import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.reakabc.fabcoders.Adapters.DrinkAdapter
import com.reakabc.fabcoders.Modals.Drink
import com.reakabc.fabcoders.Presenters.MainPresenter
import com.reakabc.fabcoders.View.InterfaceMain

class MainActivity : AppCompatActivity(), InterfaceMain {

    lateinit var recyclerView: RecyclerView
    lateinit var progressBar: ProgressBar
    lateinit var searchView: SearchView
    lateinit var notFoundText: TextView

    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialize views
        recyclerView = findViewById(R.id.recycler_view_drinks)
        progressBar = findViewById(R.id.progress_circular)
        searchView = findViewById(R.id.search_bar)
        notFoundText = findViewById(R.id.not_found_text)

        presenter = MainPresenter(this)
        presenter.onSearch("")

        initializeSearchView()

    }

    override fun onResume() {
        super.onResume()
        searchView.clearFocus()
    }

    private fun initializeSearchView(){

        searchView.imeOptions = EditorInfo.IME_ACTION_DONE
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                presenter.onSearch(query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                presenter.onSearch(newText)
                return false
            }
        })

    }

    override fun onSearchResult(drinks: List<Drink>) {

        recyclerView.layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter= DrinkAdapter(drinks, this)
        recyclerView.isVisible = true
        progressBar.isVisible = false
        notFoundText.isVisible = false

    }

    override fun onFailure() {
        recyclerView.isVisible = false
        progressBar.isVisible = false
        notFoundText.isVisible = true
    }
}