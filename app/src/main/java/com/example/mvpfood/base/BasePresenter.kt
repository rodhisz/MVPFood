package com.example.mvpfood.base

import com.example.mvpfood.main.MainActivity

interface BasePresenter<T : BaseView> {
    fun onAttach(view : MainActivity)
    fun onDetach()
}