package com.example.pokedex;

import static com.example.pokedex.R.id.male_input;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    //buttons
    RadioGroup radioGroup;
    Button submitButton;
    Button resetButton;
    RadioButton female;
    RadioButton male;
    Spinner spinner;
    EditText nationalNumbInput;
    TextView nationalNumText;
    EditText nameInput;
    TextView nameText;
    EditText speciesInput;
    TextView speciesText;
    EditText heightInput;
    TextView heightText;
    EditText weightInput;
    TextView weightText;
    EditText hpInput;
    TextView hpText;
    Button viewdatabasebutton;
    EditText attackInput;
    TextView attackText;
    EditText defenseInput;
    TextView defenseText;
    Boolean boo;
    LinkedList<Submission> submissions;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);

        resetButton = findViewById(R.id.reset_button);
        submitButton = findViewById(R.id.submit_button);
        viewdatabasebutton = findViewById(R.id.db_button);
        nationalNumbInput = findViewById(R.id.nationalnumb_input);
        nameInput = findViewById(R.id.name_input);
        speciesInput = findViewById(R.id.species_input);
        heightInput = findViewById(R.id.height_input);
        weightInput = findViewById(R.id.weight_input);
        hpInput = findViewById(R.id.hp_input);
        attackInput =findViewById(R.id.attack_text_et);
        defenseInput= findViewById(R.id.defense_input);
        nationalNumText = findViewById(R.id.natnumb_text);
        nameText = findViewById(R.id.name_text);
        speciesText = findViewById(R.id.species_text);
        heightText = findViewById(R.id.height_text);
        weightText = findViewById(R.id.weight_text);
        hpText = findViewById(R.id.hp_text);
        attackText = findViewById(R.id.attack_text);
        defenseText = findViewById(R.id.defense_input_TV);
        spinner = findViewById(R.id.level);
        resetButton.setOnClickListener(reset_listener);
        viewdatabasebutton.setOnClickListener(db_listener);
        submitButton.setOnClickListener(submit_listener);
        radioGroup = findViewById(R.id.radioGroup);
        male = findViewById(R.id.male_input);
        female = findViewById(R.id.Female_input);
        radioGroup = findViewById(R.id.radioGroup);
        submitButton.setOnClickListener(submit_listener);





        ArrayList<Integer> level = new ArrayList<>();
        for(int i = 1; i<51; i++){
            level.add(i);
        }
        ArrayAdapter<Integer> TypeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, level);
        spinner.setAdapter(TypeAdapter);
        }






    View.OnClickListener reset_listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            nationalNumbInput.setText ("896" );
            nameInput.setText ("Glastrier");
            speciesInput. setText ("Wild Horse Pokemon");
            heightInput.setText ("2.2");//2.2 m
            weightInput. setText ("800"); //800.0 kg
            hpInput. setText ("15"); //0
            attackInput.setText ("15") ; //0
            defenseInput.setText ("50") ; //0
        }


    };




    View.OnClickListener db_listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            setContentView(R.layout.activity_database);
            Intent intent = new Intent(getApplicationContext(), DatabaseActivity.class);
            startActivity(intent);
        }

    };




    View.OnClickListener submit_listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            boo = true;


            //getting values
            String name = nameInput.getText().toString();
            int nationalNumber = Integer.parseInt(nationalNumbInput.getText().toString());
            String species = speciesInput.getText().toString();
            double heightt = Double.parseDouble(heightInput.getText().toString());
            double weightt = Double.parseDouble(weightInput.getText().toString());
            int attack = Integer.parseInt(attackInput.getText().toString());
            int defense = Integer.parseInt(defenseInput.getText().toString());
            int hpp = Integer.parseInt(hpInput.getText().toString());

            if (name.length() <= 3 || name.length() >= 12) {
                nameInput.setText("");
                nameInput.setHint("Please enter a valid name");
                boo = false;
            }
            Float hp = Float.parseFloat(hpInput.getText().toString());
            if (hp <= 1 || hp >= 362) {
                hpInput.setText("");
                hpInput.setHint("Please enter a valid hp");
                boo = false;
            }
            Integer atk = Integer.parseInt(attackInput.getText().toString());
            if (atk <= 5 || atk >= 526) {
                attackInput.setText("");
                attackInput.setHint("Please enter a valid attack input");
                boo = false;
            }
            Integer def = Integer.parseInt(defenseInput.getText().toString());
            if (def <= 5 || def >= 614) {
                defenseInput.setText("");
                defenseInput.setHint("Please enter a valid defense input");
                boo = false;
            }

            double height = Double.parseDouble(heightInput.getText().toString());
            if (height <= 0.3 || height >= 19.99) {
                heightInput.setText("");
                heightInput.setHint("Please enter a valid height input");
                boo = false;
            }
            Double weight = Double.parseDouble(weightInput.getText().toString());
            if (weight <= 0.1 || weight >= 820.0) {
                weightInput.setText("");
                weightInput.setHint("Please enter a valid weight input");
                boo = false;
            }
            radioGroup = findViewById(R.id.radioGroup);
            male = findViewById(male_input);
            female = findViewById(R.id.Female_input);
            boolean checkedm = male.isChecked();
            boolean checkedf = female.isChecked();
            String gender = "string";

            if (checkedm) {
                gender = "male";
            } else if (checkedf) {
                gender = "female";
            } else {
                gender = "female";
            }
            int level = spinner.getSelectedItemPosition();


            if (nationalNumbInput.getText().toString().trim().isEmpty()) {
                nationalNumbInput.setHint("Please enter a national number");
                boo = false;
            }
            if (nameInput.getText().toString().trim().isEmpty()) {
                nameInput.setHint("Please enter a name");
                boo = false;
            }
            if (speciesInput.getText().toString().trim().isEmpty()) {
                speciesInput.setHint("Please enter a species");
                boo = false;
            }
            if (heightInput.getText().toString().trim().isEmpty()) {
                heightInput.setHint("Please enter a height");
                boo = false;
            }
            if (weightInput.getText().toString().trim().isEmpty()) {
                weightInput.setHint("Please enter a weight");
                boo = false;

            }
            if (hpInput.getText().toString().trim().isEmpty()) {
                hpInput.setHint("Please enter an HP");
                boo = false;

            }
            if (attackInput.getText().toString().trim().isEmpty()) {
                attackInput.setHint("Please enter an attack");
                boo = false;

            }
            if (defenseInput.getText().toString().trim().isEmpty()) {
                defenseInput.setHint("Please enter an defense");
                boo = false;
            }
            if(!checkDupes()){
                boo = false;
                Toast.makeText(MainActivity.this, "Duplicate Values Entered", Toast.LENGTH_SHORT).show();
            }

            if (boo) {
                String message = "Your information was stored in the database!";
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                Submission newSub = new Submission(nationalNumber, name, species, gender, heightt, weightt, attack, defense, level, hpp);
                addToList(newSub);

            } else {
                String message2 = "The information you entered does not meet the field requirements.";
                Toast.makeText(MainActivity.this, message2, Toast.LENGTH_LONG).show();

            }
            clear();

        }

        public void clear() {
            nationalNumbInput.setText("");
            nameInput.setText("");
            heightInput.setText("");
            weightInput.setText("");
            hpInput.setText("");
            attackInput.setText("");
            defenseInput.setText("");
            spinner.setSelection(0);
            radioGroup.clearCheck();
            speciesInput.setText("");
        }

        public void addToList(Submission s) {
            if (submissions == null) {
                submissions = new LinkedList<>();
            }
            submissions.add(s);
            ContentValues newValues = new ContentValues();

            newValues.put(PokedexContentProvider.Column1_Name, s.getNationalNumber());
            newValues.put(PokedexContentProvider.Column2_Name, s.getName());
            newValues.put(PokedexContentProvider.Column3_Name, s.getSpecies());
            newValues.put(PokedexContentProvider.Column4_Name, s.getGender());
            newValues.put(PokedexContentProvider.Column5_Name, s.getHeight());
            newValues.put(PokedexContentProvider.Column6_Name, s.getWeight());
            newValues.put(PokedexContentProvider.Column7_Name, s.getLevel());
            newValues.put(PokedexContentProvider.Column8_Name, s.getHP());
            newValues.put(PokedexContentProvider.Column9_Name, s.getAttack());
            newValues.put(PokedexContentProvider.Column10_Name, s.getDefense());

            getContentResolver().insert(PokedexContentProvider.CONTENT_URI, newValues);

        }

        private boolean checkDupes() {

            String name = nameInput.getText().toString();
            int nationalNumber = Integer.parseInt(nationalNumbInput.getText().toString());
            String species = speciesInput.getText().toString();
            double heightt = Double.parseDouble(heightInput.getText().toString());
            double weightt = Double.parseDouble(weightInput.getText().toString());
            int attack = Integer.parseInt(attackInput.getText().toString());
            int defense = Integer.parseInt(defenseInput.getText().toString());
            int hpp = Integer.parseInt(hpInput.getText().toString());

            Cursor cursor = getContentResolver().query(
                    PokedexContentProvider.CONTENT_URI, null, null,
                    null, null);
            submissions = new LinkedList<>();
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.getCount() > 0) {
                    while (!cursor.isAfterLast()) {
                        int number = cursor.getInt(1);
                        String nam = cursor.getString(2);
                        String specie = cursor.getString(3);
                        double height = cursor.getDouble(5);
                        double weight = cursor.getDouble(6);
                        int hp = cursor.getInt(8);
                        int attac = cursor.getInt(9);
                        int defens = cursor.getInt(10);
                        cursor.moveToNext();

                        if (nationalNumber == number && name == nam && specie == species && heightt == height &&
                                weight == weightt && attack == attac && hp == hpp && defens == defense) {
                            return false;
                        }

                    }
                }

            }
            return true;}
    };}



