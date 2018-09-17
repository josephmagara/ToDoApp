package org.josephmagara.todo.android.activities.android.ui.ViewHolders

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import kotlinx.android.synthetic.main.to_do_view_holder.view.dateCreated
import kotlinx.android.synthetic.main.to_do_view_holder.view.title
import kotlinx.android.synthetic.main.to_do_view_holder.view.toDoItemCheckbox

class ToDoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

  val checkbox: CheckBox = itemView.toDoItemCheckbox
  val title: TextView = itemView.title
  val dateTextView: TextView = itemView.dateCreated
}