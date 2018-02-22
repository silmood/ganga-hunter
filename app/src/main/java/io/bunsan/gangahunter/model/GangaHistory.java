package io.bunsan.gangahunter.model;


import java.util.ArrayList;

public class GangaHistory {

    private static final GangaHistory ourInstance = new GangaHistory();

    private static ArrayList<Ganga> history;

    public static GangaHistory getInstance() {
        return ourInstance;
    }

    private GangaHistory() {
        history = new ArrayList<>();
        history.addAll(dummyItems());
    }

    public ArrayList<Ganga> getHistory() {
        return history;
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
