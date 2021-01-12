package com.example.practicals;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class db_helper extends SQLiteOpenHelper {
    public db_helper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create query
        db.execSQL("create table test(id text, name text)"); //execSQL for anything other then Select
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS test");
        onCreate(db);
    }

    public void setValue(int i, String data) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues(); //To put data column wise in table
        cv.put("id", i);
        cv.put("name", data);
        db.insert("test", null, cv);

    }

    public List getValue() {
        List<String> result = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from test", null); //rawQuery returns cursor
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Log.d("------", "getValue() in dbHelper" + cursor.getString(cursor.getColumnIndex("name")));
            result.add(cursor.getString(cursor.getColumnIndex("name")));
            cursor.moveToNext();
        }
        return result;
    }
}
