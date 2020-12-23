package io.github.cloudyhug.praefektur

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    // a click on the button launches the game
    playButton.setOnClickListener { _ ->
      val intent = Intent(this, GameActivity::class.java)
      startActivityForResult(intent, 0)
    }
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.main_menu, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    return when (item.itemId) {
      // a click on the learn icon displays all the prefectures
      R.id.learn -> {
        val intent = Intent(this, CountyDataActivity::class.java)
        startActivity(intent)
        true
      }
      // a click on the info icon shows a dialog
      R.id.appInfo -> {
        AppInfoDialogFragment().show(supportFragmentManager, "appinfo")
        true
      }
      else -> super.onOptionsItemSelected(item)
    }
  }

}