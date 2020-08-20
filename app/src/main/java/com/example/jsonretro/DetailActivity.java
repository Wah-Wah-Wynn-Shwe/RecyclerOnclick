package com.example.jsonretro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView t1=findViewById(R.id.t1);
        String id="id not set";
        Bundle extras=getIntent().getExtras();
        if(extras != null){
            id=extras.getString("id");
        }

        t1.setText(id);
    }
}
