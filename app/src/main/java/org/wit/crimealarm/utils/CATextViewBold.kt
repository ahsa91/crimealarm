package org.wit.crimealarm.utils

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class CATextViewBold(context: Context, attrs: AttributeSet) : AppCompatTextView(context, attrs) {

    init {
        applyFont()
    }


    /**
     * applies font to relevant textview
     */
    private fun applyFont() {

        // This is used to get the file from the assets folder and set it to the title textView.
        val typeface: Typeface =
            Typeface.createFromAsset(context.assets, "Montserrat-Bold.ttf")
        setTypeface(typeface)
    }
}