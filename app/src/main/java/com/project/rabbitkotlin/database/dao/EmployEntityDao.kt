package com.project.rabbitkotlin.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.project.rabbitkotlin.database.entities.EmployEntiity

@Dao
interface EmployEntityDao {





    @Query("Select * from employ_details")
    fun readAllEmployees(): MutableList<EmployEntiity>


    @Query("Select count (*) from employ_details ")
   fun getCount(): Int

   @Insert(onConflict = OnConflictStrategy.IGNORE)
   fun saveDatas(tbl: EmployEntiity):Long

    @Query("Select count (*) from employ_details ")
    fun getLiveCount(): LiveData<Int>




   @Query("Select *  from employ_details where id=:id")
    fun readSpecificEmploy(id:Int):EmployEntiity



    @Query("Select *  from employ_details where name like :keyword  ")
    fun readSimilarEmploy(keyword:String): MutableList<EmployEntiity>
}