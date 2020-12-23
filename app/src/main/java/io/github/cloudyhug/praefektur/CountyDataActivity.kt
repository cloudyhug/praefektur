package io.github.cloudyhug.praefektur

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_county_data.*

class CountyDataActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_county_data)

    countyDataList.adapter = CountyDatumRecyclerViewAdapter(GameData.frenchCounties)
  }
}