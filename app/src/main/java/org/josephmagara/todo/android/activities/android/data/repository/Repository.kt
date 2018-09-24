package org.josephmagara.todo.android.activities.android.data.repository

import org.josephmagara.todo.android.activities.android.data.models.UserToDo
import org.josephmagara.todo.android.activities.android.data.repository.databases.DbManager
import javax.inject.Inject

class Repository{
  @Inject private val dbManager: DbManager? = null
  fun getAllUserToDo(): List<UserToDo> {
    return dbManager?.getAllUserToDo() ?: listOf()

  }

  fun saveUserToDo(userToDo: UserToDo){
    dbManager?.saveUserToDo(userToDo)
  }
}