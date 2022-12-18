package com.example.mymarket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.example.mymarket.adapters.epic_item_adapter;
import com.example.mymarket.models.epic_item;

import java.util.ArrayList;
import java.util.List;

public class epicerie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epicerie);

        //list of item

        List<epic_item> itepice =new ArrayList<>();
        itepice.add(new epic_item("Lait","lait2",3.5));

        itepice.add(new epic_item("Huile ","huile",70));
        itepice.add(new epic_item("Oulmès","oulmes",9));




        //get dridView

        GridView epiceriee=findViewById(R.id.epic);
        epiceriee.setAdapter(new epic_item_adapter(this,itepice));
    }
}