package org.josephmagara.todo.android.activities.android.data.database

import android.arch.persistence.room.Room
import android.content.Context
import org.josephmagara.todo.android.activities.android.data.database.db.AppDatabase
import org.josephmagara.todo.android.activities.android.data.interfaces.UserToDoDoa
import org.josephmagara.todo.android.activities.android.data.models.UserToDo


class DbManager(private val context: Context){

  companion object {
    private const val dbName = "usr_todo"
  }

  private fun getDB() : AppDatabase{
    return Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, dbName).build()
  }

  private fun getDoa(): UserToDoDoa {
    return getDB().userToDoDoa()
  }

  fun getAllUserToDo(): List<UserToDo>{
    val doa = getDoa()
    return doa.getAll()
  }

  fun saveUserToDo(userToDo: UserToDo){
    val doa = getDoa()
    doa.insert(userToDo)
  }
}