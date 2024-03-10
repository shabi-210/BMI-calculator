package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText weight, heightFt, heightIn;
        TextView result;
        AppCompatButton calculateBMI;



        weight=findViewById(R.id.weight);
        heightFt=findViewById(R.id.heightFt);
        heightIn=findViewById(R.id.heightIn);
        result=findViewById(R.id.result);
        calculateBMI=findViewById(R.id.calculateBMI);

        calculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              int wt= Integer.parseInt(weight.getText().toString());
                int ft=Integer.parseInt(heightFt.getText().toString());
               int inch= Integer.parseInt(heightIn.getText().toString());

               int totalheight=ft*12+inch;
               double heightInCm=totalheight *2.54;
               double heightM=heightInCm/100;

               double BMI=wt/(heightM*heightM);
               if (BMI<18){
                   result.setText("YOU ARE UNDERWEIGHT");
                   Toast.makeText(MainActivity.this, "You are UNDERWEIGHT!", Toast.LENGTH_LONG).show();
               }
               else if (BMI>=18 && BMI<25){
                   result.setText("you are fit");
                   Toast.makeText(MainActivity.this, "You are fit!", Toast.LENGTH_LONG).show();
               } else if (BMI>=25 && BMI<30) {
                   result.setText("you are overweight1");
                   Toast.makeText(MainActivity.this, "You are OVERWEIGHT!", Toast.LENGTH_LONG).show();
               }
               else {
                   result.setText("you are obese!");
                   Toast.makeText(MainActivity.this, "You are OBESE!", Toast.LENGTH_LONG).show();
               }


            }
        });
    }


}