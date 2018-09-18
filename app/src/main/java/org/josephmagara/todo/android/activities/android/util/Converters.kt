package org.josephmagara.todo.android.activities.android.util

import java.util.Date

class Converters {

  fun dateFromLong(long: Long): Date {
    return Date(long)
  }

  fun dateToLong(date:Date): Long{
    return date.time
  }
}