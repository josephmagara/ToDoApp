package org.josephmagara.todo.android.activities.android.data.interfaces

import android.content.Context

interface ListDisplayImpl{
  fun notifyAdapterOfDataChange()
  fun getContext() : Context
}