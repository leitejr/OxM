package com.example.sO2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class O2Result extends AppCompatActivity {

    private String user, Date;
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    Date today = Calendar.getInstance().getTime();
    int O2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o2_result);

        Date = df.format(today);
        TextView RO2 = this.findViewById(R.id.O2R);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            O2 = bundle.getInt("O2R");
            user = bundle.getString("Usr");
            RO2.setText(String.valueOf(O2)+" %");
        }

        Button Abt = this.findViewById(R.id.button);

        Abt.setOnClickListener(v -> {
            Intent i = new Intent(v.getContext(), AboutApp.class);
            startActivity(i);
            finish();
        });


    }

    @Override
    public void onBackPressed() {

        Intent i = new Intent(O2Result.this, O2Process.class);
        i.putExtra("Usr", user);
        startActivity(i);
        finish();
        super.onBackPressed();

    }
}
