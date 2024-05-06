package com.example.myapplication.utils

import android.os.SystemClock
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.showToast(message: String) {
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()

}
fun loge(message: String?) {
    Log.e("myAppLog", "$message")
}

var mLastClickTime: Long = 0

fun View.clickListener(
    action: (view: View) -> Unit,
) {
    this.setOnClickListener {
        if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
            return@setOnClickListener
        }
        mLastClickTime = SystemClock.elapsedRealtime()
        action(it)
    }
}