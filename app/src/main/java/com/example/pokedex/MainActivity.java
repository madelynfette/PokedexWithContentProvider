package com.example.pokedex;
import static com.example.pokedex.R.id.male_input;

import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    Button submitButton;
    Button resetButton;
    RadioButton female;

    RadioButton male;

    Spinner spinner;

    EditText nationalNumbInput;
    TextView gender_text;
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
    EditText attackInput;
    TextView attackText;
    EditText defenseInput;
    TextView defenseText;
    Boolean boo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear);

        resetButton = findViewById(R.id.reset_button);
        submitButton = findViewById(R.id.submit_button);
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
        submitButton.setOnClickListener(submit_listener);
        radioGroup = findViewById(R.id.radioGroup);
        male = (RadioButton)findViewById(R.id.male_input);
        female = (RadioButton)findViewById(R.id.Female_input);

        radioGroup = findViewById(R.id.radioGroup);

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
            heightInput.setText ("2.2 m");
            weightInput. setText ("800.0 kg");
            hpInput. setText ("0");
            attackInput.setText ("0") ;
            defenseInput.setText ("0") ;
        }


    };
    View.OnClickListener submit_listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            boo = true;
            String name = nameInput.getText().toString();
            if(name.length() <= 3 || name.length()>=12){
                nationalNumText.setTextColor(Color.RED);
                boo = false;
            }
            Float hp = Float.valueOf(hpInput.getText().toString());
            if(hp <= 1 || hp >= 362){
                hpText.setTextColor(Color.RED);
                boo = false;
            }
            Integer atk = Integer.valueOf(attackInput.getText().toString());
            if(atk <= 5 || atk >= 526){
                attackText.setTextColor(Color.RED);
                boo = false;
            }
            Integer def = Integer.valueOf(defenseInput.getText().toString());
            if(def <= 5 || def >= 614) {
                defenseText.setTextColor(Color.RED);
                boo = false;
            }
            Double height = Double.valueOf(heightInput.getText().toString());
            if(height <= 0.3 || height >= 19.99) {
                heightText.setTextColor(Color.RED);
                boo = false;
            }
            Double weight = Double.valueOf(weightInput.getText().toString());
            if(weight <= 0.1 || weight >= 820.0) {
                weightText.setTextColor(Color.RED);
                boo = false;
            }
           radioGroup = findViewById(R.id.radioGroup);
               male = (RadioButton)findViewById(male_input);
                female = (RadioButton)findViewById(R.id.Female_input);
            boolean checkedm = male.isChecked();
            boolean checkedf = female.isChecked();

            if(checkedm == false && checkedf == false ){
                gender_text.setTextColor(Color.RED);
            }

            if(nationalNumbInput == null){

            }
            if(boo == true){
                String message = "Your information was stored in the database!";
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
            else {
                String message2 = "The information you entered does not meet the field requirements.";
                Toast.makeText(MainActivity.this, message2, Toast.LENGTH_LONG).show();

            }

        };
    };

}