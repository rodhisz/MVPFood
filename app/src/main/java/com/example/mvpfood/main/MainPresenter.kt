package com.example.mvpfood.main

import com.example.mvpfood.api.ApiConfig
import com.example.mvpfood.base.BasePresenter
import com.example.mvpfood.model.ResponseGetFood
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(var mainView : MainActivity) : BasePresenter<MainConstruct.view>, MainConstruct.Presenter {
    override fun onAttach(view: MainActivity) {
        mainView = view
    }

    override fun onDetach() {
        mainView
    }

    override fun getAllFood(){
        ApiConfig.service.getFood().enqueue(object : Callback<ResponseGetFood> {
            override fun onResponse(
                call: Call<ResponseGetFood>,
                response: Response<ResponseGetFood>
            ) {
                if (response. isSuccessful || response.code() == 200){
                    val msg = response.body()?.pesan
                    val sukses = response.body()?.sukses
                    if (sukses != false){
                        val dataFood = response.body()?.data
                        mainView?.showDataFood(dataFood)
                    }else{
                        mainView?.showMessage(msg.toString())
                    }
                }
            }

            override fun onFailure(call: Call<ResponseGetFood>, t: Throwable) {
                mainView?.showError(t.message.toString())
            }

        })
    }

}