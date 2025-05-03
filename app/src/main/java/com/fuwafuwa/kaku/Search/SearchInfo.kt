package com.fuwafuwa.kaku.Search

import com.fuwafuwa.kaku.Windows.Data.ISquareChar

/**
 * Created by 0xbad1d3a5 on 12/16/2016.
 */

class SearchInfo(val squareChar: ISquareChar)
{
    val text: String get() = squareChar.displayData.text

    val textOffset: Int
        get() {
            var index = 0

            for (char in squareChar.displayData.squareChars)
            {
                if (char === squareChar)
                {
                    break
                }
                index += char.char.length
            }

            return index
        }

    val index: Int get() = squareChar.index
}