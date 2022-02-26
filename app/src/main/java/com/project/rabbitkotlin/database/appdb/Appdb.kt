package com.project.rabbitkotlin.database.appdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.project.rabbitkotlin.database.dao.EmployEntityDao
import com.project.rabbitkotlin.database.entities.EmployEntiity

@Database(version = 6, entities = [EmployEntiity::class], exportSchema = false)
abstract class Appdb : RoomDatabase() {


    abstract fun getEmloyEntityDao(): EmployEntityDao


    companion object {

        private var INSTANCE: Appdb? = null

        fun getDatabaseInstance(context: Context): Appdb {

            val tempInstance = INSTANCE
            if (tempInstance == null) {


                synchronized(this)
                {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        Appdb::class.java, com.project.rabbitkotlin.Utils.Database
                    )   .fallbackToDestructiveMigration()
                        .allowMainThreadQueries().build()

                    INSTANCE = instance

                    return instance

                }

            }

           return INSTANCE!!


        }


    }


}
