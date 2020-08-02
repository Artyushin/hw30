package com.artyushin.hw30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class XResume extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_x_resume);

        final TextView textInfo = (TextView) findViewById(R.id.tvResume);
        APerson person = new APerson();
        textInfo.setText(person.toString());

        Button buttonExit = (Button) findViewById(R.id.bExit);
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            };
        });

    }
}