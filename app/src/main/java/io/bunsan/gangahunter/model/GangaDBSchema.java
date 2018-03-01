package io.bunsan.gangahunter.model;

public class GangaDBSchema {
    public static final String DATABASE_NAME = "ganga.db";
    public static final int VERSION = 1;

    public static final String CREATE_STATEMENT =
            "CREATE TABLE "+ Ganga.TABLE_NAME +"(" +
                    Ganga.ID + " TEXT PRIMARY_KEY," +
                    Ganga.NAME + " TEXT," +
                    Ganga.PRICE + " DOUBLE," +
                    Ganga.PLACE + " TEXT," +
                    Ganga.DATE + " LONG)";

    public class Ganga {
        public static final String TABLE_NAME = "gangas";
        public static final String ID = "uuid";
        public static final String NAME = "name";
        public static final String PRICE = "price";
        public static final String PLACE = "place";
        public static final String DATE = "date";
    }
}
