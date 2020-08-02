package com.artyushin.hw30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";
    private ArrayList list = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etFullName = (EditText)  findViewById(R.id.etFullName);
        final EditText etAge = (EditText)  findViewById(R.id.etAge);

        Button buttonSave = (Button) findViewById(R.id.bSaveData);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Сохранить");
                String name = etFullName.getText().toString();
                String ageStr = etAge.getText().toString();

                int age = 0;
                try {
                    age = Integer.parseInt(ageStr);
                } catch (NumberFormatException ex) {
                    Log.e(TAG, "Буква вместо числа", ex);
                    etAge.getText().clear();
                    Toast.makeText(MainActivity.this, getText(R.string.number_format_massage), Toast.LENGTH_LONG).show();
                }

                Toast.makeText(MainActivity.this, "ФИО: " + name + "  Возраст: " + age, Toast.LENGTH_LONG).show();

                APerson.fullName = name;
                APerson.age = age;
                APerson person = new APerson();
                list.add(person);
            };
        });

        Button buttonPressure = (Button) findViewById(R.id.bGoToRecordPressure);
        buttonPressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Pressure.class);
                startActivity(intent);
            }
        });

        Button buttonVitalSigns = (Button) findViewById(R.id.bGoToRecordVitalSigns);
        buttonVitalSigns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VitalSigns.class);
                startActivity(intent);
            }
        });

        Button buttonTest = (Button) findViewById(R.id.bResult);
        buttonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, XResume.class);
                startActivity(intent);
            }
        });
    }
}