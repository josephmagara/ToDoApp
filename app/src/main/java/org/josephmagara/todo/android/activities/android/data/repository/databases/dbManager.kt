package org.josephmagara.todo.android.activities.android.data.repository.databases

import android.content.Context
import org.josephmagara.todo.android.activities.android.data.interfaces.UserToDoDoa
import org.josephmagara.todo.android.activities.android.data.models.UserToDo
import org.josephmagara.todo.android.activities.android.data.repository.databases.db.AppDatabase


class DbManager(private val context: Context){

  private fun getDB() : AppDatabase{
    return AppDatabase.getInstance(context, getDbName(context))
  }

  private fun getUserToDoDoa(): UserToDoDoa {
    return getDB().userToDoDoa()
  }

  fun getAllUserToDo(): List<UserToDo>{
    val doa = getUserToDoDoa()
    return doa.getAll()
  }

  fun saveUserToDo(userToDo: UserToDo){
    val doa = getUserToDoDoa()
    doa.insert(userToDo)
  }

  private fun getDbName(context: Context):String{
    return context.applicationInfo.loadLabel(context.packageManager).toString()
  }

}