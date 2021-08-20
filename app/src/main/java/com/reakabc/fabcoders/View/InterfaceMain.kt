package com.reakabc.fabcoders.View

import com.reakabc.fabcoders.Modals.Drink

interface InterfaceMain {

    fun onSearchResult(drinks: List<Drink>)

    fun onFailure()

}