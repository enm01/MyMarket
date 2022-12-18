package com.example.mymarket.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mymarket.R;
import com.example.mymarket.models.epic_item;
import com.example.mymarket.singleGridViewActivity;

import java.util.List;

public class leg_item_adapter extends BaseAdapter {

    private Context context;
    private List<epic_item> itepice;
    private LayoutInflater inflater;


    public leg_item_adapter(Context context,List<epic_item> itepice){
        this.context=context;
        this.itepice=itepice;
        this.inflater=LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return itepice.size();
    }

    @Override
    public epic_item getItem(int position) {
        return itepice.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=inflater.inflate(R.layout.adapter_epicerie,null);

        // get item Information
        epic_item current_item=getItem(i);
        String itemName= current_item.getName();
        String mnemonic=current_item.getMnemonic();//item_computer_icon
        double itemPrice= current_item.getPrice();

        //get item icon view
        ImageView itemIconView=view.findViewById(R.id.item_icon);
        String ressourceName="item_"+mnemonic+"_icon";
        int resId=context.getResources().getIdentifier(ressourceName,"drawable",context.getPackageName());
        itemIconView.setImageResource(resId);

        // get Item name view
        TextView itemNameView=view.findViewById(R.id.item_name);
        itemNameView.setText(itemName);

        // get Item price view
        TextView itemPriceView=view.findViewById(R.id.item_price);
        itemPriceView.setText(itemPrice+" MAD");

        itemIconView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = itemNameView.getText().toString();
                String price = itemPriceView.getText().toString();

                Intent i = new Intent(context, singleGridViewActivity.class);
                i.putExtra("image",ressourceName);
                i.putExtra("name",itemName);
                i.putExtra("price",price);

                context.startActivity(i);



            }
        });

        return view;
    }
}
