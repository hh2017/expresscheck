package com.zzptc.fox.expresscheck.Myhelps;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by wanderders on 2016/10/30.
 */
public class MyHelp extends SQLiteOpenHelper {
    public MyHelp(Context context) {
        super(context, "Mydb.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table ExpresscheckDB(_id integer primary key autoincrement,tv_companyname text not null," +
                "tv_danhao text not null,tv_date text not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
