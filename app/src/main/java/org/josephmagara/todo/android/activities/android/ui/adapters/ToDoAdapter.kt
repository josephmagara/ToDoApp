package org.josephmagara.todo.android.activities.android.ui.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.josephmagara.todoapp.R
import org.josephmagara.todo.android.activities.android.data.models.UserToDo
import org.josephmagara.todo.android.activities.android.data.presenters.ToDoPresenter
import org.josephmagara.todo.android.activities.android.ui.ViewHolders.ToDoViewHolder

class ToDoAdapter(private val context: Context, private var list: MutableList<UserToDo>, private val presenter: ToDoPresenter) : Adapter<ToDoViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ToDoViewHolder {
    return ToDoViewHolder(LayoutInflater.from(context).inflate(R.layout.to_do_view_holder, parent, false))
  }

  override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
    val item = list[position]
    holder.title.text = item.title
    holder.checkbox.isChecked = item.completed
    holder.dateTextView.text = item.getFormattedDateString()

    holder.checkbox.setOnCheckedChangeListener { _, _ ->  presenter.toggleComplete(item)}
  }


  override fun getItemCount(): Int {
    return list.size
  }
}