package com.example.mahbub.project.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mahbub.project.R;

public class DetailActivity extends AppCompatActivity {


    TextView Name, Details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Name = (TextView) findViewById(R.id.name);
        Details = (TextView) findViewById(R.id.details);
        String name = getIntent().getExtras().getString("A");
        String details = getIntent().getExtras().getString("B");
        Name.setText(name);
        Details.setText(details);


    }
}
