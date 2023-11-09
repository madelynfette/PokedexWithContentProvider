package com.example.pokedex;

import android.os.Parcelable;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.annotation.NonNull;

public class Submission{
    RadioGroup radioGroup;
    RadioButton female;
    RadioButton male;
    Spinner spinner;
    int nationalNumber;
    String gender;
    String name;
    String species;
    double height;
    double weight;
    int hp;
    int attack;
    int defense;
    int level;

    public Submission(int nationalNumber, String name, String species, String gender, double height, double weight, int level,  int hp, int attack, int defense){
        this.nationalNumber = nationalNumber;
        this.name = name;
        this.species = species;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.level = level;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;

    }

    public void setNationalNumber(int national){
        nationalNumber = national;
    }
    public int getNationalNumber(){
        return nationalNumber;
    }
    public void setGender(String gen){
        gender = gen;
    }
    public String getGender(){
        return gender;
    }
    public void setName(String nam){
        name = nam;
    }
    public String getName(){
        return name;
    }
    public void setLevel(int level){
        this.level = level;
    }
    public int getLevel(){
        return level;
    }

    public void setSpecies(String spec){
        species = spec;
    }

    public String getSpecies(){
        return species;
    }

    public void setHeight(double hei){
        height = hei;
    }

    public double getHeight(){
        return height;
    }

    public void setWeight(double weig){
        weight = weig;
    }
    public double getWeight(){
        return weight;
    }
    public void setHP(int h_p){
        hp = h_p;
    }
    public int getHP(){
        return hp;
    }
    public void setAttack(int att){
        attack = att;
    }
    public int getAttack(){
        return attack;
    }
    public void setDefense(int def){
        defense = def;
    }
    public int getDefense(){
        return defense;
    }

    @NonNull
    @Override
    public String toString(){

        return "National Number: " + nationalNumber +
                " Name: " + name +
                " Species: " + species
                + " Gender: " + gender + " Height: " + height + " Weight: " + weight + " Level: " +
                level + " HP: " + hp + " Attack: " + attack + " Defense " + defense ;
    }

}
