package com.fuwafuwa.kaku.Search

import com.fuwafuwa.kaku.Database.JmDictDatabase.Models.EntryOptimized
import com.fuwafuwa.kaku.Deinflictor.DeinflectionInfo

data class JmSearchResult(
        val entry: EntryOptimized,
        val deinfInfo: DeinflectionInfo,
        val word: String
)