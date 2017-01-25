package com.example.ccna3.registration;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

import org.w3c.dom.Text;


public class RegActivity extends AppCompatActivity implements OnItemSelectedListener {

    String item;
    Button btn;
    String gender;

    @Override

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        item = parent.getItemAtPosition(pos).toString();
        Log.d("NITTTR", item);
    }

    public void onNothingSelected(AdapterView parent) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        btn = (Button) findViewById(R.id.button);
        btn.setEnabled(false);

        final EditText et1 = (EditText) findViewById(R.id.edit_name);
        final EditText et2 = (EditText) findViewById(R.id.edit_email);
        final EditText et3 = (EditText) findViewById(R.id.edit_mobile);
        final TextView error = (TextView) findViewById(R.id.error);

        final RadioGroup rg = (RadioGroup) findViewById(R.id.radio_group);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //checkedId is the RadioButton selected
                Log.d("NITTTR", Integer.toString(checkedId));
                switch (checkedId) {
                    case R.id.male:
                        Log.d("NITTTR", "Male");
                        gender = "Male";
                        break;
                    case R.id.female:
                        Log.d("NITTTR", "Female");
                        gender = "Female";
                        break;
                }
            }
        });

        final Spinner spnr = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Department, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnr.setAdapter(adapter);

        spnr.setOnItemSelectedListener(this);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String edit1 = et1.getText().toString();
                String edit2 = et2.getText().toString();
                String edit3 = et3.getText().toString();
                String spinner1 = item;

                if(!edit2.contains("@")){
                    Toast toast = Toast.makeText(getApplicationContext(), "Invalid Email !!", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if(!(edit3.length() <13)){
                    Toast toast = Toast.makeText(getApplicationContext(), "Invalid Mobile Number !!", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    Intent intent = new Intent(RegActivity.this, DispDetailsActivity.class);
                    intent.putExtra("edit1", edit1);
                    intent.putExtra("edit2", edit2);
                    intent.putExtra("edit3", edit3);
                    intent.putExtra("spinner1", spinner1);
                    startActivity(intent);
                }
            }
        });
    }
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.checkbox:
                if (checked) {
                    btn.setEnabled(true);
                } else {
                    btn.setEnabled(false);
                }
        }
    }
}
