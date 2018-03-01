package io.bunsan.gangahunter.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GangaDBOpenHelper extends SQLiteOpenHelper{

    public GangaDBOpenHelper(Context context) {
        super(context, GangaDBSchema.DATABASE_NAME, null, GangaDBSchema.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(GangaDBSchema.CREATE_STATEMENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
