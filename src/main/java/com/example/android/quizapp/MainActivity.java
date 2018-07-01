package com.example.android.quizapp;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.id;
import static android.R.attr.name;
import static com.example.android.quizapp.R.id.gender;
import static com.example.android.quizapp.R.id.q10Answer;
import static com.example.android.quizapp.R.id.q1Answer;
import static com.example.android.quizapp.R.id.q2Answer;
import static com.example.android.quizapp.R.id.q4;
import static com.example.android.quizapp.R.id.q4Answer;
import static com.example.android.quizapp.R.id.q5Answer;
import static com.example.android.quizapp.R.id.q6Answer;
import static com.example.android.quizapp.R.id.q7Answer;
import static com.example.android.quizapp.R.id.q8Answer;
import static com.example.android.quizapp.R.id.q9Answer;

public class MainActivity extends AppCompatActivity {

    // initialize variables
    int correctAnswers=0;
   final String answerForQ4 = "Hydrogen";
    ArrayList<String> wrongAnswersList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }




    // analyse Question one
    private boolean checkQ1(){
        RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.q1RadioGroup);
      if (radioGroup1.getCheckedRadioButtonId() == q1Answer){
            correctAnswers++;

            return true;
        }
            else {
            wrongAnswersList.add("\n Question 1");
            return false;
        }
    }
    // analyse Question two
    private boolean checkQ2(){
        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.q2RadioGroup);
        if (radioGroup2.getCheckedRadioButtonId() == q2Answer){
            correctAnswers++;

            return true;
        }
        else {
            wrongAnswersList.add("\n Question 2");
            return false;
        }

        }

    // analyse Question three
    public boolean checkQ3(){

        CheckBox c1 = (CheckBox) findViewById(R.id.checkBox1);
        CheckBox c2 = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox c3 = (CheckBox) findViewById(R.id.checkBox3);
        CheckBox c4 = (CheckBox) findViewById(R.id.checkBox4);
        if (!c1.isChecked() && c2.isChecked() && c4.isChecked() && c3.isChecked()){
            correctAnswers++;
            return true;
        }
        else
            wrongAnswersList.add("\n Question 2 you can check more than one box.");
            return false;


}

    // analyse Question four
 private boolean checkQ4(){
     EditText ansField = (EditText) findViewById(q4Answer);
     return  ansField.getText().toString().equalsIgnoreCase(answerForQ4);
 }

    // analyse Question five
    private boolean checkQ5(){
        RadioGroup radioGroup5 = (RadioGroup) findViewById(R.id.q5RadioGroup);
        if (radioGroup5.getCheckedRadioButtonId() == q5Answer){
            correctAnswers++;

            return true;
        }
        else {
            wrongAnswersList.add("\n Question 5");
            return false;
        }
    }


    // analyse Question six
    private boolean checkQ6(){
        RadioGroup radioGroup6 = (RadioGroup) findViewById(R.id.q6RadioGroup);
       if (radioGroup6.getCheckedRadioButtonId() == q6Answer){
            correctAnswers++;

            return true;
        }
        else {
            wrongAnswersList.add("\n Question 6");
            return false;
        }
    }
    // analyse Question seven
    private boolean checkQ7(){
        RadioGroup radioGroup7 = (RadioGroup) findViewById(R.id.q7RadioGroup);
        if (radioGroup7.getCheckedRadioButtonId() == q7Answer){
            correctAnswers++;
            return true;
        }
        else {
            wrongAnswersList.add("\n Question 7");
            return false;
        }
    }
    // analyse Question eight
    private boolean checkQ8(){
        RadioGroup radioGroup8 = (RadioGroup) findViewById(R.id.q8RadioGroup);
        if (radioGroup8.getCheckedRadioButtonId() == q8Answer){
            correctAnswers++;

            return true;
        }
        else {
            wrongAnswersList.add("\n Question 8");
            return false;
        }
    }

    // analyse Question nine
    private boolean checkQ9(){
        RadioGroup radioGroup9 = (RadioGroup) findViewById(R.id.q9RadioGroup);
        if (radioGroup9.getCheckedRadioButtonId() == q9Answer){
            correctAnswers++;

            return true;
        }
        else {
            wrongAnswersList.add("\n Question 9");
            return false;
        }
    }
    // analyse Question ten
    private boolean checkQ10(){
        RadioGroup radioGroup10 = (RadioGroup) findViewById(R.id.q10RadioGroup);
        if (radioGroup10.getCheckedRadioButtonId() == q10Answer){
            correctAnswers++;

            return true;
        }
        else {
            wrongAnswersList.add("\n Question 10");
            return false;
        }
    }





        // Define the submit button
    public void submit(View view){
        RadioGroup radioGroupGender = (RadioGroup) findViewById(R.id.genderRadioGroup);
        RadioButton maleGender = (RadioButton) findViewById(R.id.male) ;
        RadioButton femaleGender = (RadioButton) findViewById(R.id.female) ;
        String genderText = "Mr.";

        // check declarations for analyse questions;
        checkQ1();
        checkQ2();
        checkQ3();

        // check question four
        if ( checkQ4() ){
            correctAnswers++;
        }
        else {
        wrongAnswersList.add("\n Question 4");
        }

        checkQ5();
        checkQ6();
        checkQ7();
        checkQ8();
        checkQ9();
        checkQ10();


        TextView nameField = (TextView) findViewById(R.id.enterName);
        String nameText =  (String) nameField.getText().toString();
        String reviewText;
        if (!wrongAnswersList.isEmpty()) {
             reviewText = "\n Review The following ";
            //Determine if a person is m
        }
        else reviewText = "";

        //Determine if a person is male or female
        if (maleGender.isChecked() && !femaleGender.isChecked()){
            genderText = "Mr.";
        }
        else if(!maleGender.isChecked() && femaleGender.isChecked()){
            genderText = "Mrs.";
        }
        //Determine if a person is m
        else{}
        Context context = getApplicationContext();
        String text = "Hi " +genderText+ " " +nameText+  "\n You Got  "  +correctAnswers+ " Answers Right " +reviewText+ "" +wrongAnswersList ;
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        correctAnswers = 0;
        wrongAnswersList.clear();
    }

    //Define the reset button

  public void resetButton(View view){

   //Create RadioGroup Objects
    RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.q1RadioGroup);
    RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.q2RadioGroup);
    RadioGroup radioGroup5 = (RadioGroup) findViewById(R.id.q5RadioGroup);
    RadioGroup radioGroup6 = (RadioGroup) findViewById(R.id.q6RadioGroup);
    RadioGroup radioGroup7 = (RadioGroup) findViewById(R.id.q7RadioGroup);
    RadioGroup radioGroup8 = (RadioGroup) findViewById(R.id.q8RadioGroup);
    RadioGroup radioGroup9 = (RadioGroup) findViewById(R.id.q9RadioGroup);
    RadioGroup radioGroup10 = (RadioGroup) findViewById(R.id.q10RadioGroup);
    RadioGroup radioGroupGender = (RadioGroup) findViewById(R.id.genderRadioGroup);
// create an object for edit text field
        EditText ansField = (EditText) findViewById(q4Answer);

        wrongAnswersList.clear();
        correctAnswers = 0;

        CheckBox c1 = (CheckBox) findViewById(R.id.checkBox1);
        CheckBox c2 = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox c3 = (CheckBox) findViewById(R.id.checkBox3);
        CheckBox c4 = (CheckBox) findViewById(R.id.checkBox4);

        c1.setChecked(false);
        c2.setChecked(false);
        c3.setChecked(false);
        c4.setChecked(false);

        radioGroup1.clearCheck();
        radioGroup2.clearCheck();
        radioGroup5.clearCheck();
        radioGroup6.clearCheck();
        radioGroup7.clearCheck();
        radioGroup8.clearCheck();
        radioGroup9.clearCheck();
        radioGroup10.clearCheck();
        radioGroupGender.clearCheck();

        ansField.setText("");

    }
}