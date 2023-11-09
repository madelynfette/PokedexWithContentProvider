package com.example.pokedex;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

import java.util.LinkedList;

public class PokedexContentProvider extends ContentProvider {

    public final static String DBNAME = "POKEDEXDB";
    public static final String AUTHORITY = ".com.pokedex.app.main";
    public static String TABLENAME = "POKEDEX";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + TABLENAME);
    public static String Column1_Name = "NATIONALNUMBER";
    public static String Column2_Name = "NAME";
    public static String Column3_Name = "SPECIES";
    public static String Column4_Name = "GENDER";
    public static String Column5_Name = "HEIGHT";
    public static String Column6_Name = "WEIGHT";
    public static String Column7_Name = "LEVEL";
    public static String Column8_Name = "HP";
    public static String Column9_Name = "ATTACK";
    public static String Column10_Name = "DEFENSE";
    private static final String CREATE_DB_QUERY = "CREATE TABLE " +
            TABLENAME +
            "(" +
            " _ID INTEGER PRIMARY KEY, " +
            Column1_Name + " INTEGER," +
            Column2_Name + " TEXT," +
            Column3_Name + " TEXT," +
            Column4_Name + " TEXT," +
            Column5_Name + " REAL," +
            Column6_Name + " REAL," +
            Column7_Name + " TEXT," +
            Column8_Name + " INTEGER," +
            Column9_Name + " INTEGER," +
            Column10_Name + " INTEGER)";
    private MainDatabaseHelper SQLHelper;

    public PokedexContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return SQLHelper.getWritableDatabase().
                delete(TABLENAME, selection, selectionArgs);
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        int nationalNumber = values.getAsInteger("NATIONALNUMBER");
        String name = values.getAsString("NAME");
        String species = values.getAsString("SPECIES");
        String gender = values.getAsString("GENDER");
        double height = values.getAsDouble("HEIGHT");
        double weight = values.getAsDouble("WEIGHT");
        int level = values.getAsInteger("LEVEL");
        int attack = values.getAsInteger("ATTACK");
        int defense = values.getAsInteger("DEFENSE");
        int hp = values.getAsInteger("HP");

        if (name != null) {
            long id = SQLHelper.getWritableDatabase().insert("POKEDEX", null, values);
            uri = Uri.withAppendedPath(CONTENT_URI, "" + id);
        } else {
            uri = null;
        }
        return uri;
    }

    @Override
    public boolean onCreate() {
        SQLHelper = new MainDatabaseHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        return SQLHelper.getReadableDatabase().query(TABLENAME, projection, selection, selectionArgs,
                null, null, sortOrder);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    protected static final class MainDatabaseHelper extends SQLiteOpenHelper {
        MainDatabaseHelper(Context context) {
            super(context, DBNAME, null, 4);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_DB_QUERY);
        }

        @Override
        public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        }
    }

}
