package com.kakutools.kaku.Database.JmDictDatabase.Models;

import com.google.gson.annotations.Expose;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import com.kakutools.kaku.KakuTools;

/**
 * Created by 0xbad1d3a5 on 7/25/2016.
 */
@DatabaseTable
public class MeaningMisc {

    @Expose(serialize = false)
    @DatabaseField(generatedId = true)
    private Integer id;

    @Expose(serialize = false)
    @DatabaseField(foreign = true)
    private Meaning fkMeaning;

    @Expose
    @DatabaseField
    private String misc;

    public String getMisc() {
        return misc;
    }

    public void setMisc(String misc) {
        this.misc = misc;
    }

    public Meaning getFkMeaning() {
        return fkMeaning;
    }

    public void setFkMeaning(Meaning fkMeaning) {
        this.fkMeaning = fkMeaning;
    }

    @Override
    public String toString() {
        return KakuTools.toJson(this);
    }
}
