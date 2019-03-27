package com.example.tavio_syrus_gblokpo.iai_vote.BD_LOCAL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public abstract class DAOBase {
    protected final static int Version = 1;
    protected final String NAME ="db_vote.db";
    protected SQLiteDatabase myDb = null;
    protected DataBaseHandler myHandler = null;
    public DAOBase(Context context){
        this.myHandler = new DataBaseHandler(context,NAME,null,Version);
    }
    public SQLiteDatabase open(){
        this.myDb = this.myHandler.getWritableDatabase();
        return this.myDb;
    }
    public void close(){
        this.myDb.close();
    }
    public SQLiteDatabase getMyDb(){return this.myDb;}
}
