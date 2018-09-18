package org.josephmagara.todo.android.activities.android.util

import java.text.SimpleDateFormat
import java.util.Date

object DateUtils {
  fun toSimpleString(date: Date) : String {
    val format = SimpleDateFormat("dd/MM/yyy")
    return format.format(date)
  }
}