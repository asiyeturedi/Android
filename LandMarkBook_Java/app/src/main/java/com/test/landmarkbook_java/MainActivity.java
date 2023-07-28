package com.test.landmarkbook_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.test.landmarkbook_java.databinding.ActivityDetailsBinding;
import com.test.landmarkbook_java.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    ArrayList<Landmark> landmarkArrayList;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        //baglananları gorunume cevirir
        View view = binding.getRoot();
        setContentView(view);

        landmarkArrayList = new ArrayList<>();


        Landmark pisa = new Landmark("Pisa Tower", "Italy", R.drawable.pisa);
        Landmark london = new Landmark("London Bridge", "UK", R.drawable.london);
        Landmark colessium = new Landmark("Colessium", "Italy", R.drawable.colessum);
        Landmark familia = new Landmark("La Sagrada Familia", "Spain", R.drawable.familia);


        landmarkArrayList.add(pisa);
        landmarkArrayList.add(london);
        landmarkArrayList.add(colessium);
        landmarkArrayList.add(familia);

        //Adapter

        //mapping
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,landmarkArrayList.stream().map(landmark -> landmark.name).collect(Collectors.toList()));
        //landmarkArraylist icinden sadece isimleri sergile - mapping ile donusturme yapıldı
        binding.listView.setAdapter(arrayAdapter);

        //her bir elemana tıklanınca ne yapılacak
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
            {
                //Toast.makeText(MainActivity.this,landmarkArrayList.get(position).name,Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this , DetailsActivity.class);
                    //diger aktiviteye gitme
                //tek tek gondermek yerine landmark classına serieazible eklenir
                   // intent.putExtra("landmarkname",landmarkArrayList.get(position).name);
                intent.putExtra("landmarkname",landmarkArrayList.get(position));
            }
        });
    }
}