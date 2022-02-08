package com.example.mvpfood.updatedelete

import com.example.mvpfood.api.ApiConfig
import com.example.mvpfood.base.BasePresenter
import com.example.mvpfood.main.MainActivity
import com.example.mvpfood.model.ResponseGetFood
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateDeletePresenter (var updateDeleteView : UpdateDeleteActivity) : BasePresenter<UpdateDeleteConstruct.View>, UpdateDeleteConstruct.Presenter{
    override fun onAttach(view: MainActivity) {
        TODO("Not yet implemented")
    }

    override fun onDetach() {
        updateDeleteView
    }

    override fun onAttach(view: UpdateDeleteConstruct) {
        updateDeleteView
    }

    override fun updateFood(
        idMakanan: String,
        namaMakanan: String,
        hargaMakanan: String,
        gambarMakanan: String
    ) {
        ApiConfig.service.updateFood(idMakanan, namaMakanan, hargaMakanan, gambarMakanan).enqueue(object : Callback<ResponseGetFood>{
            override fun onResponse(
                call: Call<ResponseGetFood>,
                response: Response<ResponseGetFood>
            ) {
                if (response. isSuccessful || response.code() == 200){
                    val msg = response.body()?.pesan
                    val sukses = response.body()?.sukses
                    if (sukses != false){
                        val dataFood = response.body()?.data
                        updateDeleteView?.showMessageUpdate(msg.toString())
                        updateDeleteView?.onSuccessUpdate()
                    }else{
                        updateDeleteView?.showMessageUpdate(msg.toString())
                    }
                }
            }

            override fun onFailure(call: Call<ResponseGetFood>, t: Throwable) {
                updateDeleteView?.showError(t.localizedMessage.toString())
            }
        })
    }

    override fun deleteFood(idMakanan: String) {
        TODO("Not yet implemented")
    }
}