package com.example.info_pariwisata;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class detail_wisata extends AppCompatActivity {

    private ImageView detailImageView;
    private TextView detailTitleTextView;
    private TextView detailLocationTextView;
    private TextView detailDescriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);

        // Initialize views
        detailImageView = findViewById(R.id.detailImageView);
        detailTitleTextView = findViewById(R.id.detailTitleTextView);
        detailLocationTextView = findViewById(R.id.detailLocationTextView);
        detailDescriptionTextView = findViewById(R.id.detailDescriptionTextView);

        // Get data from the Intent
        String title = getIntent().getStringExtra("title");
        String location = getIntent().getStringExtra("location");
        String description = getIntent().getStringExtra("description");
        int imageResId = getIntent().getIntExtra("image", -1);
        double latitude = getIntent().getDoubleExtra("latitude", 0);
        double longitude = getIntent().getDoubleExtra("longitude", 0);

        // Set data to views
        detailTitleTextView.setText(title);
        detailLocationTextView.setText(location);
        detailDescriptionTextView.setText(description);
        detailImageView.setImageResource(imageResId);

        Button navigateButton = findViewById(R.id.button2);
        navigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(detail_wisata.this, dashboard_info_pariwisata.class);
                startActivity(intent);
            }
        });


        Button mapButton = findViewById(R.id.openMapButton);
        mapButton.setOnClickListener(view -> {
            String uri = String.format("geo:%f,%f?q=%s", latitude, longitude, Uri.encode(title));
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            intent.setPackage("com.google.android.apps.maps");
            startActivity(intent);
        });
    }
}
