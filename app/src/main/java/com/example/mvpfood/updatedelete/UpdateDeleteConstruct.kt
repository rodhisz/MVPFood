package com.example.mvpfood.updatedelete

import com.example.mvpfood.base.BaseView

interface UpdateDeleteConstruct {

    interface View : BaseView {
        fun showMessageUpdate(msg : String)
        fun showMessageDelete(msg : String)
        fun showError(error : String)
        fun onSuccessDelete()
        fun onSuccessUpdate()
    }

    interface Presenter{
        fun updateFood(idMakanan: String, namaMakanan: String, hargaMakanan: String, gambarMakanan: String)
        fun deleteFood(idMakanan: String)
    }
}