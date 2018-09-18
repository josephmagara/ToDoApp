package org.josephmagara.todo.android.activities.android.data.interfaces

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import org.josephmagara.todo.android.activities.android.data.models.UserToDo
import java.util.Date




@Dao
interface UserToDoDoa{

  companion object {
    private const val SELECT_ALL = "SELECT * FROM userToDo"
    private const val SELECT_BY_ID = "SELECT * FROM userToDo WHERE id IN (:toDoIds)"
    private const val SELECT_BY_NAME = "SELECT * FROM userToDo WHERE title LIKE :first LIMIT 1"
    private const val SELECT_BY_TIME_PERIOD = "SELECT * FROM userToDo WHERE creationDate BETWEEN :from AND :to"

  }

  @Query(SELECT_ALL)
  fun getAll(): List<UserToDo>

  @Query(SELECT_BY_ID)
  fun loadAllByIds(toDoIds: IntArray): List<UserToDo>

  @Query(SELECT_BY_NAME)
  fun findByName(first: String, last: String): UserToDo

  @Query(SELECT_BY_TIME_PERIOD)
  fun findUsersBornBetweenDates(from: Date, to: Date): List<*>

  @Insert
  fun insert(todo: UserToDo)

  @Insert
  fun insertAll(vararg todo: UserToDo)

  @Update
  fun updateUsers(vararg todo: UserToDo)

  @Delete
  fun delete(user: UserToDo)
}