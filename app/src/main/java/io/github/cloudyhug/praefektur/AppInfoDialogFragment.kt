package io.github.cloudyhug.praefektur

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

// when info icon is clicked
class AppInfoDialogFragment : DialogFragment() {
  override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
    return activity?.let {
      AlertDialog.Builder(it, R.style.AppThemeCustom)
        .setTitle(R.string.app_info_title)
        .setMessage(R.string.app_info_content)
        .setPositiveButton(R.string.ok, null)
        .create()
    } ?: throw IllegalStateException("Activity cannot be null")
  }
}