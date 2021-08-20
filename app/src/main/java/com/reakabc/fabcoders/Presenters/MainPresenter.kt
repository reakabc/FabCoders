package com.reakabc.fabcoders.Presenters

import com.reakabc.fabcoders.Modals.Response
import com.reakabc.fabcoders.Networking.ApiClient
import com.reakabc.fabcoders.View.InterfaceMain
import retrofit2.Call
import retrofit2.Callback

class MainPresenter(val interfaceMain: InterfaceMain) : InterfaceMainPresenter{

    override fun onSearch(text: String) {

        val call: Call<Response> = ApiClient.getClient.getDrinks(text)
        call.enqueue(object : Callback<Response> {

            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {

                if(response.body()?.drinks != null){
                    interfaceMain.onSearchResult(response.body()!!.drinks)
                } else {
                    interfaceMain.onFailure()
                }

            }

            override fun onFailure(call: Call<Response>?, t: Throwable?) {

                interfaceMain.onFailure()

            }

        })

    }

}