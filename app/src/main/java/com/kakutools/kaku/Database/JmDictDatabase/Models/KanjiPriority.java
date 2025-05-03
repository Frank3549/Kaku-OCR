package com.kakutools.kaku.Database.JmDictDatabase.Models;

import com.google.gson.annotations.Expose;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import com.kakutools.kaku.KakuTools;

/**
 * Created by 0xbad1d3a5 on 7/25/2016.
 */
@DatabaseTable
public class KanjiPriority {

    @Expose(serialize = false)
    @DatabaseField(generatedId = true)
    private Integer id;

    @Expose(serialize = false)
    @DatabaseField(foreign = true)
    private Kanji fkKanji;

    @Expose
    @DatabaseField
    private String kanjiPriority;

    public String getKanjiPriority() {
        return kanjiPriority;
    }

    public void setKanjiPriority(String kanjiPriority) {
        this.kanjiPriority = kanjiPriority;
    }

    public Kanji getFkKanji() {
        return fkKanji;
    }

    public void setFkKanji(Kanji fkKanji) {
        this.fkKanji = fkKanji;
    }

    @Override
    public String toString() {
        return KakuTools.toJson(this);
    }
}
