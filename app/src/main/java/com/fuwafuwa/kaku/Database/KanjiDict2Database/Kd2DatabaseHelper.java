package com.fuwafuwa.kaku.Database.KanjiDict2Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import com.fuwafuwa.kaku.Constants;
import com.fuwafuwa.kaku.Database.DatabaseHelper;
import com.fuwafuwa.kaku.Database.JmDictDatabase.Models.EntryOptimized;
import com.fuwafuwa.kaku.Exceptions.NotImplementedException;

/**
 * Created by 0xbad1d3a5 on 12/1/2016.
 */

public class Kd2DatabaseHelper extends DatabaseHelper {

    private static final String DATABASE_NAME = Constants.JMDICT_DATABASE_NAME;
    private static final int DATABASE_VERSION = 1;

    private static Kd2DatabaseHelper instance;

    private Context mContext;

    public Kd2DatabaseHelper(Context context){
        super(context, String.format("%s/%s", context.getFilesDir().getAbsolutePath(), DATABASE_NAME), null, DATABASE_VERSION);
        mContext = context;
    }

    public static synchronized Kd2DatabaseHelper instance(Context context){
        if (instance == null){
            instance = new Kd2DatabaseHelper(context);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, EntryOptimized.class);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        throw new NotImplementedException();
    }

    @Override
    public void deleteDatabase() {
        //mContext.deleteDatabase(String.format("%s/%s", mContext.getFilesDir().getAbsolutePath(), DATABASE_NAME));
    }

    @Override
    public <T> Dao<T, Integer> getDbDao(Class clazz) throws SQLException {
        return getDao(clazz);
    }
}
