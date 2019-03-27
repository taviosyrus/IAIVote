package com.example.tavio_syrus_gblokpo.iai_vote.BD_LOCAL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.CONTENT.CritereContent;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.CONTENT.EtudiantContent;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.CONTENT.GcContent;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.CONTENT.Mon_CompteContent;
import com.example.tavio_syrus_gblokpo.iai_vote.CLASSES.CONTENT.ProfesseurContent;


public class DataBaseHandler extends SQLiteOpenHelper {

    public DataBaseHandler(Context context, String name, SQLiteDatabase.CursorFactory cursorFactory, int version){
        super(context,name,cursorFactory,version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {


      db.execSQL(Mon_CompteContent.CREATE);
      db.execSQL(ProfesseurContent.CREATE);
        db.execSQL(EtudiantContent.CREATE);
        db.execSQL(GcContent.CREATE);
        db.execSQL(CritereContent.CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


       db.execSQL(Mon_CompteContent.DROP);
       db.execSQL(ProfesseurContent.DROP);
        db.execSQL(EtudiantContent.DROP);
        db.execSQL(GcContent.DROP);
        db.execSQL(CritereContent.DROP);
        onCreate(db);
    }
}
