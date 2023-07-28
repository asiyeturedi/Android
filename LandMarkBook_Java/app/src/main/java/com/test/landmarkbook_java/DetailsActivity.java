package com.test.landmarkbook_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.test.landmarkbook_java.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity
{

    private ActivityDetailsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_details);

        //inflate - kod ve xml baglama
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());

        //baglananları gorunume cevirir
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();

        //casting - koda (Landmark) ekleme yapılarak
        Landmark selectedLandmark = (Landmark) intent.getSerializableExtra("landmark");

        binding.nameText.setText(selectedLandmark.name);
        binding.nameText.setText(selectedLandmark.country);
        binding.imageView.setImageResource(selectedLandmark.image);



    }
}