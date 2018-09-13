package ui.activities

import android.arch.lifecycle.Lifecycle.Event.ON_CREATE
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Window
import com.example.josephmagara.todoapp.R.layout
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit.MILLISECONDS


class SplashActivity : AppCompatActivity() {

  @OnLifecycleEvent(ON_CREATE)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    requestWindowFeature(Window.FEATURE_NO_TITLE)
    setContentView(layout.activity_splash)
    Observable.timer(2000, MILLISECONDS).observeOn(
        Schedulers.io()).subscribe { goToListActivity() }
  }

  private fun goToListActivity() {
    val intent = Intent(this, ListActivity::class.java)
    startActivity(intent)
  }
}

