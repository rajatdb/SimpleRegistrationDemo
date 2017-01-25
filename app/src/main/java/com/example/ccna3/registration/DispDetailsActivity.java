package com.example.ccna3.registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import static android.R.attr.x;

public class DispDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceSaved){
        super.onCreate(savedInstanceSaved);
        setContentView(R.layout.activity_disp_details);

        TextView tx1 = (TextView) findViewById(R.id.text1);
        TextView tx2 = (TextView) findViewById(R.id.text2);
        TextView tx3 = (TextView) findViewById(R.id.text3);
        TextView spnr = (TextView) findViewById(R.id.text4);
        Button btn = (Button) findViewById(R.id.btn_cont);

        Intent x = getIntent();
        String spinner1 = x.getStringExtra("spinner1");
        spnr.setText(spinner1);

        Intent i = getIntent();
        String edit1 = i.getStringExtra("edit1");
        tx1.setText(edit1);

        Intent j = getIntent();
        String edit2 = j.getStringExtra("edit2");
        tx2.setText(edit2);

        Intent k = getIntent();
        String edit3 = k.getStringExtra("edit3");
        tx3.setText(edit3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DispDetailsActivity.this, InGridViewActivity.class);
                startActivity(intent);
            }
        });

    }
}
