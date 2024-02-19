package com.example.acostastudio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConexionSQLite extends SQLiteOpenHelper {

    public static final String db = "androidapp";

    public ConexionSQLite(@Nullable Context context) {
        super(context, db, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE usuarios (mail TEXT PRIMARY KEY, pwd TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
    }

    public boolean insertValues(String mail, String pwd){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("mail",mail);
        values.put("pwd",pwd);
        long resultado = db.insert("usuarios",null,values);
        if (resultado == -1) return false;
        else return true;
    }
    public boolean verificarMail(String mail){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM usuarios WHERE mail = ?", new String[]{mail});
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }
    public boolean verificarMailPwd(String mail, String pwd){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM usuarios WHERE mail = ? AND pwd = ?", new String[]{mail,pwd});
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }
}
