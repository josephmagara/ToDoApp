package org.josephmagara.todo.android.activities.android.data.interfaces

import org.josephmagara.todo.android.activities.android.data.models.UserToDo

interface ToDoPresenterImpl {
  fun getAllToDos(): ArrayList<UserToDo>
}