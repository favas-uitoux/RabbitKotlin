package com.project.rabbitkotlin.repos

import android.util.Log
import androidx.lifecycle.LiveData
import com.project.rabbitkotlin.apiservice.ApiClient
import com.project.rabbitkotlin.apiservice.Endpoint
import com.project.rabbitkotlin.apiservice.pojos.fetch_employ.ResponseBase
import com.project.rabbitkotlin.database.dao.EmployEntityDao
import com.project.rabbitkotlin.database.entities.EmployEntiity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//import com.project.rabbitkotlin.database.dao.StockEntityDao
//import com.project.myapplication.database.entities.StockEntiity

class EmployeesRepo(private val employEntiityDao: EmployEntityDao) {


    fun readSize():Int
    {
        return  employEntiityDao.getCount()

    }

    fun readLiveSize(): LiveData<Int>
    {
        return  employEntiityDao.getLiveCount()

    }


    fun saveData(tbl: EmployEntiity):Long
    {
       return employEntiityDao.saveDatas(tbl)
    }


    fun  readSimilarEmploy(ser: String): MutableList<EmployEntiity>
    {
        return employEntiityDao.readSimilarEmploy(ser)
    }


    fun  readAllEmployees(): MutableList<EmployEntiity>
    {

        if(readSize()==0)
        {

            val apiService = ApiClient.getClient(Endpoint::class.java)
            var call = apiService.fetchEmployees();

            call!!.enqueue(object :
                Callback<MutableList<ResponseBase>> {
                override fun onResponse(
                    call: Call<MutableList<ResponseBase>>,
                    response: Response<MutableList<ResponseBase>>
                ) {


                    for (row: ResponseBase in response.body()!!) {

                        var  cmpName="";
                        var  mob="";
                        var profileImage=""
                        try {
                            cmpName = row.company.name
                        } catch (e: Exception) {
                        }


                        try {
                            mob = row.phone
                        } catch (e: Exception) {
                        }

                        try {
                            profileImage = row.profile_image
                        } catch (e: Exception) {
                        }


                        try {
                            saveData(EmployEntiity(0,row.id,row.name,row.username,row.email,row.address.street,row.address.suite,
                                row.address.city,row.address.zipcode,""+row.address.geo.lat,""+row.address.geo.lng,
                                cmpName,row.website,profileImage,mob))
                        }catch (e: Exception) {
                        }


                    }

                    Log.d("result", "ok")


                }

                override fun onFailure(
                    call: Call<MutableList<ResponseBase>>,
                    t: Throwable
                ) {

                    Log.d("result", "failed")

                }
            })


            return employEntiityDao.readAllEmployees()
        }
        else
        {

            Log.d("result", "ok"+employEntiityDao.getCount())
            return employEntiityDao.readAllEmployees()
        }


    }

    fun  readSpecificEmploy(empId: Int): EmployEntiity
    {
        return employEntiityDao.readSpecificEmploy(empId)
    }





}