package com.example.mymarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.mymarket.adapters.bouch_item_adapter;
import com.example.mymarket.models.epic_item;

import java.util.ArrayList;
import java.util.List;

public class boucherie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boucherie);

        //list of item

        List<epic_item> itbouch =new ArrayList<>();
        itbouch.add(new epic_item("Brochette dinde","brochettedinde",40));
        itbouch.add(new epic_item("émincée poulet","eminceepoulet",55));
        itbouch.add(new epic_item("Filet poulée","filetpoulee",30));
        itbouch.add(new epic_item("Gigot agneau","gigotagneau",80));
        itbouch.add(new epic_item("poulet entier","pouleentier",70));
        itbouch.add(new epic_item("saucisse poulet","saucissepoulet",9));
        itbouch.add(new epic_item("viande hachée","viandeache",28));
        itbouch.add(new epic_item("viande tagine","viandetagine",28));



        //get dridView



        GridView boucheriee=findViewById(R.id.bouch);
        boucheriee.setAdapter(new bouch_item_adapter(this,itbouch));





    }
}