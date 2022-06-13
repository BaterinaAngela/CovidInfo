package com.example.covidinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1, spinner2;
    private Button buttonSave;
    private TextView textViewSpinner1, textViewSpinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize component
        initComponent();

        // Load spinner data
        loadData(new String[]{"First Dose", "Second Dose"});
        loadData1(new String[]{"PFizer", "Sinovac", "Moderna", "AstraZeneca"});

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Show a message on the screen
                Toast toast = Toast.makeText(getApplicationContext(), "Spinner 1 value "+spinner1.getSelectedItem().toString(), Toast.LENGTH_SHORT);
                toast.show();
                // Show message on logcat
                Log.i("TEST",spinner1.getSelectedItem().toString());

                String spinnerVal1 = spinner1.getSelectedItem().toString();
                textViewSpinner1.setText(spinnerVal1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                textViewSpinner1.setText("None");
            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Show a message on the screen
                Toast toast = Toast.makeText(getApplicationContext(), "Spinner 2 value "+spinner2.getSelectedItem().toString(), Toast.LENGTH_SHORT);
                toast.show();
                // Show message on logcat
                Log.i("TEST",spinner2.getSelectedItem().toString());

                String spinnerVal2 = spinner2.getSelectedItem().toString();
                textViewSpinner2.setText(spinnerVal2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                textViewSpinner2.setText("None");
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Show a message on the screen
                Toast toast = Toast.makeText(getApplicationContext(), "Spinner 2 value "+spinner2.getSelectedItem().toString() + "Spinner 1 Value" + spinner2.getSelectedItem().toString(), Toast.LENGTH_SHORT);
                toast.show();
                // Show message on logcat
                Log.i("TEST",spinner2.getSelectedItem().toString() + spinner1.getSelectedItem().toString());
            }
        });

    }

    private void initComponent() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        buttonSave = (Button) findViewById(R.id.btnSave);
        textViewSpinner1 = (TextView) findViewById(R.id.txtSpinner1);
        textViewSpinner2 = (TextView) findViewById(R.id.txtSpinner2);
    }


    private void loadData(String[] doses) {
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.spinner_item, doses);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
    }

    private void loadData1(String[] doses) {
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.spinner_item, doses);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
    }
}