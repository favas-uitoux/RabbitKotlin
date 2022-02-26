package com.project.rabbitkotlin.modelviews

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.project.rabbitkotlin.repos.EmployeesRepo
import com.project.rabbitkotlin.database.appdb.Appdb
import com.project.rabbitkotlin.database.entities.EmployEntiity


class EmployeesViewModel(application: Application) : AndroidViewModel(application) {


    private val repo: EmployeesRepo

    init {
        val employEntityDao = Appdb.getDatabaseInstance(application).getEmloyEntityDao()
        repo = EmployeesRepo(employEntityDao)


    }


    fun readAllEmployees(): MutableList<EmployEntiity> {
        return repo.readAllEmployees()
    }

    fun readSimilarEmploy(word:String): MutableList<EmployEntiity> {
        return repo.readSimilarEmploy(word)
    }

    fun readSpecificEmploy(empId:Int): EmployEntiity {
        return repo.readSpecificEmploy(empId)
    }

    fun readLiveSize(): LiveData<Int>
    {
        return  repo.readLiveSize()

    }

}