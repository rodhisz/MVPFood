package com.example.mvpfood.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mvpfood.R
import com.example.mvpfood.model.DataItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var mainPresenter : MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter = MainPresenter(this)
        mainPresenter?.getAllFood()
    }

    fun showDataFood(dataFood:List<DataItem?>?){
        val adapterFood = FoodAdapter(dataFood,this)
        rv_food.apply {
            layoutManager = GridLayoutManager(this@MainActivity,2)
            setHasFixedSize(true)
            adapter = adapterFood
        }
    }

    fun showMessage(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()

    }

    fun showError(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }


    private fun onDetachView() {
        mainPresenter?.onDetach()
    }

    private fun onAttachView() {
        mainPresenter?.onAttach(this)
    }

    override fun onStart() {
        super.onStart()
        onAttachView()
    }

    override fun onDestroy() {
        super.onDestroy()
        onDetachView()
    }

    override fun onResume() {
        super.onResume()
        mainPresenter?.getAllFood()
    }
}