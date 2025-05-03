package com.kakutools.kaku.Search

import com.kakutools.kaku.Database.JmDictDatabase.Models.EntryOptimized
import com.kakutools.kaku.Deinflictor.DeinflectionInfo

data class JmSearchResult(
        val entry: EntryOptimized,
        val deinfInfo: DeinflectionInfo,
        val word: String
)