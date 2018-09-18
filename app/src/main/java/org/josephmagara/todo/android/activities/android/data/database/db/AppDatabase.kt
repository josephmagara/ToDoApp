package org.josephmagara.todo.android.activities.android.data.database.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import org.josephmagara.todo.android.activities.android.data.interfaces.UserToDoDoa
import org.josephmagara.todo.android.activities.android.data.models.UserToDo

@Database(entities = [UserToDo::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
  abstract fun userToDoDoa() : UserToDoDoa
}
