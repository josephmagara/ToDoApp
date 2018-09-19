package org.josephmagara.todo.android.activities.android.data.database.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import org.josephmagara.todo.android.activities.android.data.interfaces.SubTaskDoa
import org.josephmagara.todo.android.activities.android.data.interfaces.UserToDoDoa
import org.josephmagara.todo.android.activities.android.data.models.SubTask
import org.josephmagara.todo.android.activities.android.data.models.UserToDo
import org.josephmagara.todo.android.activities.android.util.Converters



@Database(entities = [UserToDo::class, SubTask::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
  abstract fun userToDoDoa() : UserToDoDoa
  abstract fun subTaskDoa() : SubTaskDoa

  companion object {
    @Volatile private var INSTANCE: AppDatabase? = null

    fun getInstance(context: Context, dbName: String): AppDatabase =
        INSTANCE ?: synchronized(this) {
          INSTANCE ?: buildDatabase(context, dbName).also { INSTANCE = it }
        }

    private fun buildDatabase(context: Context, dbName: String) =
        Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, dbName).build()
  }
}
