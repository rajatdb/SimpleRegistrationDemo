package com.example.ccna3.registration;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class InListViewActivity extends Activity {
    ListView list;
    String[] web = {
            "laptop",
            "desktop",
            "tablet",
            "ipod",
            "mobile",
            "camera",
            "printer"
    } ;
    Integer[] imageId = {
            R.drawable.laptop,
            R.drawable.desktop,
            R.drawable.tablet,
            R.drawable.ipod,
            R.drawable.mobile,
            R.drawable.camera,
            R.drawable.printer

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListAdapter adapter = new ListAdapter(InListViewActivity.this, web, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(InListViewActivity.this, " " +web[+ position], Toast.LENGTH_SHORT).show();
            }
        });

    }

}