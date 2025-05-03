package com.fuwafuwa.kaku.Database;

import android.content.Context;

import com.fuwafuwa.kaku.Database.JmDictDatabase.JmDatabaseHelper;
import com.fuwafuwa.kaku.Database.KanjiDict2Database.Kd2DatabaseHelper;

/**
 * Created by 0xbad1d3a5 on 12/1/2016.
 */

public class DbHelperFactory {

    private static Context mContext;

    public DbHelperFactory(Context context){
        mContext = context;
    }

    public DatabaseHelper instance(Class clazz){
        if (clazz == JmDatabaseHelper.class) {
            return JmDatabaseHelper.instance(mContext);
        }
        else if (clazz == Kd2DatabaseHelper.class){
            return Kd2DatabaseHelper.instance(mContext);
        }
        else {
            return null;
        }
    }
}
