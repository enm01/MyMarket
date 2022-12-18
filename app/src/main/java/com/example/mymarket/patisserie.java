package com.example.mymarket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.example.mymarket.adapters.patiss_item_adapter;
import com.example.mymarket.models.epic_item;

import java.util.ArrayList;
import java.util.List;

public class patisserie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patisserie);

        //list of item

        List<epic_item> itpatisserie =new ArrayList<>();
        itpatisserie.add(new epic_item("Lait","lait2",3.5));

        //get dridView

        GridView patisseriee=findViewById(R.id.patis);
        patisseriee.setAdapter(new patiss_item_adapter(this,itpatisserie));
    }
}