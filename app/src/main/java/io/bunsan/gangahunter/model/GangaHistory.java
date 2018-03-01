package io.bunsan.gangahunter.model;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class GangaHistory {

    private static GangaHistory ourInstance;

    private static ArrayList<Ganga> history;

    public static GangaHistory getInstance(Context context) {
        if (ourInstance == null){
            ourInstance = new GangaHistory(context);
        }

        return ourInstance;
    }

    private SQLiteDatabase db;

    private GangaHistory(Context context) {
        history = new ArrayList<>();
        GangaDBOpenHelper openHelper = new GangaDBOpenHelper(context);
        db = openHelper.getWritableDatabase();
    }

    public ArrayList<Ganga> getHistory() {
        return history;
    }

    @Nullable
    public Ganga findGangaById(String id) {

        for (Ganga ganga:
             history) {
            if (ganga.getId().equals(id))
                return ganga;
        }

        return null;
    }

    @Nullable
    public Ganga createGanga() {
        Ganga createdGanga = new Ganga();
        history.add(createdGanga);

        return createdGanga;
    }

    private ArrayList<Ganga> dummyItems() {
        ArrayList<Ganga> gangas = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Ganga ganga = new Ganga("Ganga # " + i, 10F);
            ganga.setPlace("Place #" + (i + 100));
            gangas.add(ganga);
        }

        return gangas;
    }

}
