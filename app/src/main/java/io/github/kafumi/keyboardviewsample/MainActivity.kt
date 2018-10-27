package io.github.kafumi.keyboardviewsample

import android.inputmethodservice.Keyboard
import android.inputmethodservice.KeyboardView
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val keyboardView = findViewById<KeyboardView>(R.id.keyboard) ?: return
        val textView = findViewById<TextView>(R.id.text) ?: return
        val buffer = StringBuffer()

        keyboardView.keyboard = Keyboard(this, R.xml.keyboard)
        keyboardView.isPreviewEnabled = false
        keyboardView.setOnKeyboardActionListener(object : KeyboardView.OnKeyboardActionListener {
            override fun swipeRight() {
            }

            override fun onPress(primaryCode: Int) {
            }

            override fun onRelease(primaryCode: Int) {
            }

            override fun swipeLeft() {
            }

            override fun swipeUp() {
            }

            override fun swipeDown() {
            }

            override fun onKey(primaryCode: Int, keyCodes: IntArray?) {
                Log.d(TAG, "onKey: primaryCode=$primaryCode, keyCodes=$keyCodes")

                val char = primaryCode.toChar()
                when (char) {
                    '\b' -> buffer.setLength((buffer.length - 1).coerceAtLeast(0))
                    else -> buffer.append(char)
                }
                textView.text = buffer
            }

            override fun onText(text: CharSequence) {
                Log.d(TAG, "onText: text=$text")
            }
        })
    }

    companion object {
        private const val TAG = "KeyboardViewSample"
    }
}
