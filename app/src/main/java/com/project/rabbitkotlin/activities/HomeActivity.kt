package com.project.rabbitkotlin.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.project.rabbitkotlin.R
import com.project.rabbitkotlin.Utils
import com.project.rabbitkotlin.fragments.EmployeesFragment
import com.project.rabbitkotlin.interfaces.HomeActivityInterfaces


class HomeActivity:AppCompatActivity(),HomeActivityInterfaces {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        Utils.homeActivityInterface=this@HomeActivity


        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, EmployeesFragment(), "EmployeesFragment").commit()

    }

    override fun showEmploy(id: Int) {

    val intent=    Intent(this@HomeActivity, SpecificEmployActivity::class.java)
        intent.putExtra("employID",id)

            startActivity(intent)
    }


}