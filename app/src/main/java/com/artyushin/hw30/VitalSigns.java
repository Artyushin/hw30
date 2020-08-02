package com.artyushin.hw30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class VitalSigns extends AppCompatActivity {

    private final static String TAG = "VitalSigns";
    private ArrayList<APerson> listVS = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vital_signs);

        final EditText etWeight = (EditText)  findViewById(R.id.etWeight);
        final EditText etNumberSteps = (EditText)  findViewById(R.id.etNumberSteps);

        Button buttonSaveVS = (Button) findViewById(R.id.bSaveDataVS);
        buttonSaveVS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Сохранить");
                String weightStr = etWeight.getText().toString();
                String numberStepsStr = etNumberSteps.getText().toString();

                double weight = 0;
                int numberSteps = 0;
                try {
                    weight = Double.parseDouble(weightStr);
                } catch (NumberFormatException ex) {
                    Log.e(TAG, "Буква вместо числа", ex);
                    etWeight.getText().clear();
                    Toast.makeText(VitalSigns.this, getText(R.string.number_format_massage), Toast.LENGTH_LONG).show();
                }
                try {
                    numberSteps = Integer.parseInt(numberStepsStr);
                } catch (NumberFormatException ex) {
                    Log.e(TAG, "Буква вместо числа", ex);
                    etNumberSteps.getText().clear();
                    Toast.makeText(VitalSigns.this, getText(R.string.number_format_massage), Toast.LENGTH_LONG).show();
                }

                Toast.makeText(VitalSigns.this, "Вес: " + weight + "  Количество шагов: " + numberSteps, Toast.LENGTH_LONG).show();
                APerson.weight = weight;
                APerson.numberSteps = numberSteps;
                APerson person = new APerson();
                listVS.add(person);
                finish();
            };
        });

    }
}