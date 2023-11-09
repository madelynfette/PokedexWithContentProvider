package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class DatabaseActivity extends AppCompatActivity {
    ListView database;
    LinkedList<Submission> submissions;
    Cursor cursor;
    SQLiteOpenHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        database = findViewById(R.id.database_listview);
        cursor = getContentResolver().query(
                PokedexContentProvider.CONTENT_URI, null, null,
                null, null);
        submissions = new LinkedList<>();
        if(cursor != null){
            cursor.moveToFirst();
            if (cursor.getCount() > 0) {
                while(!cursor.isAfterLast()) {
                    int number = cursor.getInt(1);
                    String name = cursor.getString(2);
                    String species = cursor.getString(3);
                    String gender = cursor.getString(4);
                    double height = cursor.getDouble(5);
                    double weight = cursor.getDouble(6);
                    int level = cursor.getInt(7);
                    int hp = cursor.getInt(8);
                    int attack = cursor.getInt(9);
                    int defense = cursor.getInt(10);
                    submissions.add(new Submission(number, name, species, gender, height, weight, level, hp, attack, defense));
                    cursor.moveToNext();
                }
            }

        ArrayAdapter<Submission> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,submissions);
        database.setAdapter(adapter);}
        database.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Submission selection = (Submission) database.getAdapter().getItem(position);
                String numb = String.valueOf(selection.getNationalNumber());
                String name = selection.getName();
                String species = selection.getSpecies();
                String gender = selection.getGender();
                String height = String.valueOf(selection.getHeight());
                String weight = String.valueOf(selection.getWeight());
                String level = String.valueOf(selection.getLevel());
                String attack = String.valueOf(selection.getAttack());
                String defense = String.valueOf(selection.getDefense());
                String hp = String.valueOf(selection.getHP());

                String selectionClause = PokedexContentProvider.Column1_Name + " = ? ";



                String[] selectionArgs ={ numb};

                int deleted = getContentResolver().delete(PokedexContentProvider.CONTENT_URI, selectionClause, selectionArgs);
                database.invalidateViews();




            }
        });
}}