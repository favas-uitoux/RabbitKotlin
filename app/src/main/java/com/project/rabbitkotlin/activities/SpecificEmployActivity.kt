package com.project.rabbitkotlin.activities

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.project.rabbitkotlin.R
import com.project.rabbitkotlin.database.appdb.Appdb
import com.project.rabbitkotlin.modelviews.EmployeesViewModel

class SpecificEmployActivity :AppCompatActivity() {

    private lateinit var viewModel: EmployeesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_specific_employ)



        init()

    }


    fun init()
    {
        val extras = intent.extras
        val employID = extras!!.getInt("employID")



        viewModel = ViewModelProvider(this).get(EmployeesViewModel::class.java)


        val  result =    viewModel.readSpecificEmploy(employID)

        val iv: ImageView = findViewById(R.id.iv)
        val txtName: TextView = findViewById(R.id.txtName)
        val txtUsername: TextView = findViewById(R.id.txtUsername)
        val txtEmail: TextView = findViewById(R.id.txtEmail)

        val txtAds1: TextView = findViewById(R.id.txtAds1)
        val txtAds2: TextView = findViewById(R.id.txtAds2)
        val txtAds3: TextView = findViewById(R.id.txtAds3)

        val txtMob: TextView = findViewById(R.id.txtMob)


        val txtweb: TextView = findViewById(R.id.txtweb)

        txtName.setText(result.name)
        txtUsername.setText(result.userName)
        txtEmail.setText(result.email)

        txtAds1.setText(result.street)
        txtAds2.setText(result.city)
        txtAds3.setText(result.suite)
        txtMob.setText(result.phone)
        txtweb.setText(result.web)

        var profilepic = result.profileImageUrl
        Glide.with(this@SpecificEmployActivity).load(profilepic)
            .sizeMultiplier(.5f)
            .placeholder(R.drawable.blanc_pic)
            .error(R.drawable.blanc_pic)
            .fallback(R.drawable.blanc_pic)
            .dontAnimate()
            .into(iv)


    }




}