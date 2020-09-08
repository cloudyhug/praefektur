package io.github.cloudyhug.praefektur

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_game.*
import kotlin.random.Random

class GameActivity : AppCompatActivity() {
  // 0 - must ask a question
  // 1 - must display the answer
  private val QUESTION_STATE: Int = 0
  var state: Int = 0

  var currentDatum: CountyDatum? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_game)

    supportActionBar?.setTitle(R.string.find_the_prefectures)
    play() // the game is launched automatically
  }

  override fun onTouchEvent(event: MotionEvent?): Boolean {
    event?.let {
      // trigger the game when touching the screen
      if (it.action == MotionEvent.ACTION_DOWN)
        play()
    }
    return super.onTouchEvent(event)
  }

  fun play() {
    if (state == QUESTION_STATE) {
      GameData.frenchCounties.let { data ->
        var newDatum: CountyDatum? = null
        // not twice the same county
        do {
          newDatum = data[Random.nextInt(data.size)]
        } while (newDatum == currentDatum)
        currentDatum = newDatum
      }
      // erase the previous answers
      countyNameDynamicText.text = ""
      prefectureCityDynamicText.text = ""
      // display the county number correctly
      countyNumberDynamicText.text =
        when (currentDatum!!.number) {
          201 -> "2A"
          202 -> "2B"
          else ->
            (if (currentDatum!!.number < 10) "0" else "") + currentDatum!!.number.toString()
        }
    } else {
      // answer mode, just print them on the screen
      countyNameDynamicText.text = currentDatum!!.county
      prefectureCityDynamicText.text = currentDatum!!.city
    }
    // invert the state
    state = 1 - state
  }
}