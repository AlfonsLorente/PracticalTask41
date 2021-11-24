package com.example.practicaltask41;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    private String mSpinnerLabel = "";
    private TextView phoneRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        if(spinner != null){
            spinner.setOnItemSelectedListener(this);
        }
        adapter = ArrayAdapter.createFromResource(this, R.array.labels_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }

    }

    public void showText(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        if (editText != null) {
            if(!editText.getText().toString().equals("")) {
                String showString = (editText.getText().toString() + " - " + mSpinnerLabel);

                Toast.makeText(this, showString, Toast.LENGTH_SHORT).show();
                phoneRes = (TextView) findViewById(R.id.text_phonelabel);
                if (phoneRes != null) {
                    phoneRes.setText(showString);
                }

            }
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mSpinnerLabel = parent.getItemAtPosition(position).toString();
        showText(view);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Log.d(TAG, getString(R.string.nothing_selected));
    }

    public void showAlert(View view) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle("Alert");
        alertBuilder.setMessage("Click whatever man, it doesn't matter anyway");
        //Buttons
        alertBuilder.setPositiveButton("Useless text", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Ohh, now the text is depressed, awesome...", Toast.LENGTH_SHORT).show();
            }
        });
        alertBuilder.setNegativeButton("Even more useless text",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "God... You are a monster...", Toast.LENGTH_SHORT).show();
            }
        });

        alertBuilder.show();

    }
}