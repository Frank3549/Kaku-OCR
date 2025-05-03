package com.kakutools.kaku.Ocr

import android.graphics.Bitmap
import com.kakutools.kaku.TextDirection

data class OcrParams(val bitmap: Bitmap,
                     val originalBitmap: Bitmap,
                     val box: BoxParams,
                     val textDirection: TextDirection,
                     val instantMode: Boolean)
{
    override fun toString() : String {
        return "Box: $box InstantOCR: $instantMode TextDirection: $textDirection"
    }
}

