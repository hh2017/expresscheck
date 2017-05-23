package com.zzptc.fox.expresscheck.Myhelps;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.zzptc.fox.expresscheck.beans.ExpressCheckBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanderders on 2016/10/30.
 */
public class DBDao {
    private MyHelp myHelp;
    public DBDao(Context context){
        myHelp = new MyHelp(context);
    }


    /*
    * 添加快递查询的历史记录到数据库里
    * */
    public boolean insert(ExpressCheckBean expresscheck) {
        SQLiteDatabase database = myHelp.getWritableDatabase();
        ContentValues values = new ContentValues(3);
        if (!contant(expresscheck.getTv_danhao())){
            values.put("tv_companyname", expresscheck.getTv_companyname());
            values.put("tv_danhao", expresscheck.getTv_danhao());
            values.put("tv_date", expresscheck.getTv_date());
            database.insert("ExpresscheckDB", null, values);
        }else {
            values.put("tv_companyname", expresscheck.getTv_companyname());
            values.put("tv_danhao", expresscheck.getTv_danhao());
            values.put("tv_date", expresscheck.getTv_date());
            database.update("ExpresscheckDB",values,"tv_danhao="+expresscheck.getTv_danhao(),null);
        }

        /*long l = database.insert("ExpresscheckDB", null, values);
        if (l > 0){
            return true;
        }*/
        database.close();
        return false;
    }


    private boolean contant(String tv_danhao){
        boolean content = false;
        SQLiteDatabase database = myHelp.getWritableDatabase();
        Cursor cursor = database.query("ExpresscheckDB",null,"tv_danhao=?",new String[]{tv_danhao}, null, null, null);
        int count = cursor.getCount();
        content = count > 0;
        return content;
    }

/*
* 查询快递的查询历史记录
* */
    public List<ExpressCheckBean> selectAllExpre(){
        List<ExpressCheckBean> list = new ArrayList<>();
        SQLiteDatabase database = myHelp.getReadableDatabase();
        Cursor cursor = database.query("ExpresscheckDB", null, null, null, null, null, null);
        while(cursor.moveToNext()){
            ExpressCheckBean bean = new ExpressCheckBean();
            bean.setId(cursor.getInt(cursor.getColumnIndex("_id")));
            bean.setTv_companyname(cursor.getString(cursor.getColumnIndex("tv_companyname")));
            bean.setTv_danhao(cursor.getString(cursor.getColumnIndex("tv_danhao")));
            bean.setTv_date(cursor.getString(cursor.getColumnIndex("tv_date")));
            list.add(bean);
        }
        return list;
    }


    public void delete(String date){
        SQLiteDatabase database = myHelp.getWritableDatabase();
        database.execSQL("delete from ExpresscheckDB where tv_date = ? ",new Object[]{date});
        database.close();
    }


}
