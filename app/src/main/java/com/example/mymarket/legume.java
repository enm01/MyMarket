package com.example.mymarket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.example.mymarket.adapters.leg_item_adapter;
import com.example.mymarket.models.epic_item;

import java.util.ArrayList;
import java.util.List;

public class legume extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legume);

        //list of item

        List<epic_item> itlegume =new ArrayList<>();
        itlegume.add(new epic_item("Brocoli","brocoli",33));
        itlegume.add(new epic_item("tomate","tomate",9));
        itlegume.add(new epic_item("Pomme","apple",33));
        itlegume.add(new epic_item("Vinaigre","banana",9));
        itlegume.add(new epic_item("Thon de huile","lemon",33));
        itlegume.add(new epic_item("Vinaigre","orange",9));
        itlegume.add(new epic_item("Thon de huile","pear",33));
        itlegume.add(new epic_item("Vinaigre","strawberry",9));


        //get dridView

        GridView legumee=findViewById(R.id.leg);
        legumee.setAdapter(new leg_item_adapter(this,itlegume));
    }
}