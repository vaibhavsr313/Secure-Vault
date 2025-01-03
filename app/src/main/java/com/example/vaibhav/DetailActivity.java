package com.example.vaibhav;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    TextView Titleindetail,mailindetail,paswordindetail;
    ImageView photoindetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Titleindetail = findViewById(R.id.Titleindetail);
        mailindetail = findViewById(R.id.mailindetail);
        paswordindetail = findViewById(R.id.paswordindetail);
        photoindetail = findViewById(R.id.photoindetail);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null)
        {
            mailindetail.setText(bundle.getString("Description"));
            Titleindetail.setText(bundle.getString("Title"));
            paswordindetail.setText(bundle.getString("Lang"));

            Glide.with(this).load(bundle.getString("Image")).into(photoindetail);
        }
    }
}