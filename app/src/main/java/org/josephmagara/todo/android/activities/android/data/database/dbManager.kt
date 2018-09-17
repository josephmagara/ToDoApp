package org.josephmagara.todo.android.activities.android.data.database

import android.arch.persistence.room.Room
import android.content.Context
import org.josephmagara.todo.android.activities.android.data.database.db.AppDatabase


class DbManager(private val context: Context){

  companion object {
    private const val dbName = "UserDefinedToDo"
  }

  private fun getDB() : AppDatabase{
    return Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "").build()
  }

  fun getAllUserToDo(){

  }
}