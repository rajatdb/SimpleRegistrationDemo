package com.example.ccna3.registration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class InGridViewActivity extends Activity {

    GridView grid;
    String[] web = {
            "desktop",
            "mobile",
            "ipod",
            "camera",
            "laptop",
            "harddisk",
            "printer",
            "router",
            "tablet"
    };
    int[] Imageid = {
            R.drawable.desktop,
            R.drawable.mobile,
            R.drawable.ipod,
            R.drawable.camera,
            R.drawable.laptop,
            R.drawable.harddisk,
            R.drawable.printer,
            R.drawable.router,
            R.drawable.tablet

    };

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        final Button btn2 = (Button) findViewById(R.id.btn1);

        ImageAdapter adapter = new ImageAdapter(InGridViewActivity.this, web, Imageid);
        grid = (GridView) findViewById(R.id.gridview);
        grid.setAdapter(adapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(InGridViewActivity.this, "" + web[+ position],Toast.LENGTH_SHORT).show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(InGridViewActivity.this, InListViewActivity.class);
                startActivity(intent1);
                finish();
            }
        });
    }
}
