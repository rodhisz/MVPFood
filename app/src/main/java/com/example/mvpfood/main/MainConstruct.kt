package com.example.mvpfood.main

import com.example.mvpfood.base.BaseView
import com.example.mvpfood.model.DataItem
import com.example.mvpfood.model.ResponseGetFood

interface MainConstruct {
    interface view : BaseView{
        fun showDataFood(dataFood: List<DataItem?>?)
        fun showError(msg: String)
        fun showMessage(msg: String)
        fun onSuccessInsert()
    }

    interface Presenter{
        fun getAllFood()
    }
}