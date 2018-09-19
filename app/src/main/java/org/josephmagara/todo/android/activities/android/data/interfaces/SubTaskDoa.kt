package org.josephmagara.todo.android.activities.android.data.interfaces

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import org.josephmagara.todo.android.activities.android.data.models.SubTask
import java.util.Date

@Dao
interface SubTaskDoa {
  companion object {
    private const val SELECT_ALL = "SELECT * FROM sub_tasks"
    private const val SELECT_BY_NAME = "SELECT * FROM sub_tasks WHERE title LIKE :title LIMIT 1"
    private const val SELECT_BY_TIME_PERIOD = "SELECT * FROM sub_tasks WHERE dateSubTaskCreated BETWEEN :from AND :to"
    private const val SELECT_BY_PARENT_ID = "SELECT * FROM sub_tasks WHERE parentUserToDoId = :parentUserToDoId"
  }
  @Query(SELECT_ALL)
  fun getAll(): List<SubTask>

  @Query(SELECT_BY_NAME)
  fun findByTitle(title: String): SubTask

  @Query(SELECT_BY_TIME_PERIOD)
  fun findToDosCreatedBetween(from: Date, to: Date): List<SubTask>

  @Query(SELECT_BY_PARENT_ID)
  fun getAllByParentUserToDoId(parentUserToDoId: Long): List<SubTask>

  @Insert
  fun insert(subTask: SubTask) : Long

  @Update
  fun updateSubtask(vararg subTask: SubTask) : Int

  @Delete
  fun delete(subTask: SubTask)
}