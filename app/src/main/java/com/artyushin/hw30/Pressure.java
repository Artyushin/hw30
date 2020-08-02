package com.artyushin.hw30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

public class Pressure extends AppCompatActivity {

    private final static String TAG = "PressureActivity";
    private ArrayList<APerson> listP = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);

        final EditText etHiPressure = (EditText)  findViewById(R.id.etHiPressure);
        final EditText etLowPressure = (EditText)  findViewById(R.id.etLowPressure);
        final EditText etPulse = (EditText)  findViewById(R.id.etPulse);
        final EditText etDate = (EditText)  findViewById(R.id.etDate);

        final CheckBox checkBox = (CheckBox) findViewById(R.id.cbTachycardia);

        Button buttonSave = (Button) findViewById(R.id.bSaveDataP);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Сохранить");
                String hiPressureStr = etHiPressure.getText().toString();
                String lowPressureStr = etLowPressure.getText().toString();
                String pulseStr = etPulse.getText().toString();
                String date = etDate.getText().toString();
                String tachycardia = " ";

                if (checkBox.isChecked()) {
                    tachycardia = (String) getText(R.string.tachycardiaYes);
                } else {
                    tachycardia = (String) getText(R.string.tachycardiaNo);
                };

                int hiPressure = 0;
                int lowPressure = 0;
                int pulse = 0;

                try {
                    hiPressure = Integer.parseInt(hiPressureStr);
                } catch (NumberFormatException ex) {
                    Log.e(TAG, "Буква вместо числа", ex);
                    etHiPressure.getText().clear();
                    Toast.makeText(Pressure.this, getText(R.string.number_format_massage), Toast.LENGTH_LONG).show();
                }
                try {
                    lowPressure = Integer.parseInt(lowPressureStr);
                } catch (NumberFormatException ex) {
                    Log.e(TAG, "Буква вместо числа", ex);
                    etLowPressure.getText().clear();
                    Toast.makeText(Pressure.this, getText(R.string.number_format_massage), Toast.LENGTH_LONG).show();
                }
                try {
                    pulse = Integer.parseInt(pulseStr);
                } catch (NumberFormatException ex) {
                    Log.e(TAG, "Буква вместо числа", ex);
                    etPulse.getText().clear();
                    Toast.makeText(Pressure.this, getText(R.string.number_format_massage), Toast.LENGTH_LONG).show();
                }

                Toast.makeText(Pressure.this, "Верхнее давление: " + hiPressure + "  Ниженее давление: " + lowPressure +
                        "  Пульс: " + pulse + "  Тахикардия: " + tachycardia + "  Дата замера: " + date, Toast.LENGTH_LONG).show();
                APerson.hiPressure = hiPressure;
                APerson.lowPressure = lowPressure;
                APerson.pulse = pulse;
                APerson.tachycardia = tachycardia;
                APerson.date = date;
                APerson person = new APerson();
                listP.add(person);
                finish();
            };
        });


    }
}