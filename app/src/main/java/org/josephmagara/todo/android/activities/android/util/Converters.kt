package org.josephmagara.todo.android.activities.android.util

import android.arch.persistence.room.TypeConverter
import java.util.Date

class Converters {

  companion object {
    @TypeConverter
    @JvmStatic
    fun dateFromLong(long: Long): Date {
      return Date(long)
    }

    @TypeConverter
    @JvmStatic
    fun dateToLong(date: Date): Long {
      return date.time
    }
  }
}