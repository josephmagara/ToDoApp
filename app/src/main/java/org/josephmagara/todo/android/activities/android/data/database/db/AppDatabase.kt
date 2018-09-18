package org.josephmagara.todo.android.activities.android.data.database.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import org.josephmagara.todo.android.activities.android.data.interfaces.UserToDoDoa
import org.josephmagara.todo.android.activities.android.data.models.UserToDo
import org.josephmagara.todo.android.activities.android.util.Converters

@Database(entities = [UserToDo::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
  abstract fun userToDoDoa() : UserToDoDoa
}
