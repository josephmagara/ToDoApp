package org.josephmagara.todo.android.activities.android.ui.activities

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.OnLifecycleEvent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.example.josephmagara.todoapp.R
import kotlinx.android.synthetic.main.activity_list.textInput
import org.josephmagara.todo.android.activities.android.data.models.SubTask
import org.josephmagara.todo.android.activities.android.data.models.UserToDo

class ListActivity : AppCompatActivity(), LifecycleObserver {

  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_list)
    bindView()
  }

  private fun bindView() {
    textInput.setOnEditorActionListener { textView: TextView, i: Int, keyEvent: KeyEvent ->
      if (i == EditorInfo.IME_ACTION_DONE) {
        createToDo(textView.text.toString())
        true
      }
      false
    }
  }

  private fun createToDo(title: String) {
    val newSubtasks = MutableLiveData<MutableList<SubTask>>()
    val newTodo = UserToDo(title,
        newSubtasks)
  }
}
