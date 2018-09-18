package org.josephmagara.todo.android.activities.android.data.database.interfaces

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import org.josephmagara.todo.android.activities.android.data.models.UserToDo


@Dao
interface UserToDoDoa{

  companion object {
    private const val SELECT_ALL = "SELECT * FROM userToDo"
    private const val SELECT_BY_ID = "SELECT * FROM userToDo WHERE id IN (:toDoIds)"
    private const val SELECT_BY_NAME = "SELECT * FROM userToDo WHERE title LIKE :first LIMIT 1"
  }

  @Query(
      SELECT_ALL)
  fun getAll(): List<UserToDo>

  @Query(
      SELECT_BY_ID)
  fun loadAllByIds(toDoIds: IntArray): List<UserToDo>

  @Query(
      SELECT_BY_NAME)
  fun findByName(first: String, last: String): UserToDo

  @Insert
  fun insertAll(vararg users: UserToDo)

  @Delete
  fun delete(user: UserToDo)
}