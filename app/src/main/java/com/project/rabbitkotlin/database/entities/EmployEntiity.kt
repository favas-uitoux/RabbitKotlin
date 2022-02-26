package com.project.rabbitkotlin.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employ_details")
 open class EmployEntiity(
    @PrimaryKey(autoGenerate = true)

    val id: Int,
    val empId: Int,
    val name:String,
    val userName:String?,
    val email:String?,
    val street:String?,
    val suite:String?,
    val city:String?,
    val zip:String?,
    val lat:String,
    val longi:String?,
    val companyName:String?,
    val web:String?,
    val profileImageUrl:String?,
    val phone:String?,



)