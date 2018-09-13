package org.josephmagara.todo.android.activities.android.ui

import android.app.Activity
import android.arch.lifecycle.Lifecycle.Event.ON_CREATE
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.widget.ImageView.ScaleType.FIT_XY
import com.example.josephmagara.todoapp.R.layout
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_splash.backgroundImageView
import java.util.concurrent.TimeUnit.SECONDS


class SplashActivity : Activity() {

  @OnLifecycleEvent(ON_CREATE)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    requestWindowFeature(Window.FEATURE_NO_TITLE)
    setContentView(layout.activity_splash)
    backgroundImageView.scaleType = FIT_XY
    Observable.timer(3, SECONDS).observeOn(
        Schedulers.io()).subscribe { goToListActivity() }
  }

  private fun goToListActivity() {
    val intent = Intent(this, ListActivity::class.java)
    startActivity(intent)
  }
}

