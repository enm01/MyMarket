package com.example.mymarket;



import static com.example.mymarket.productDBHelper.DATABASE_NAME;
import  com.example.mymarket.productDBcontract;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.mymarket.productDBHelper;
import com.example.mymarket.productDBcontract.productDB;

import com.example.mymarket.models.epic_item;

public class singleGridViewActivity extends AppCompatActivity {

    TextView ajouterPanier;
    ImageView imagev, plus, moins;
    TextView name, price, num;
    epic_item object;
    int quantite = 1;
    double prix;

    productDBHelper dbHelper;

    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_grid_view);

        dbHelper = new productDBHelper(this);
        db = dbHelper.getWritableDatabase();

        imagev = (ImageView) findViewById(R.id.item_iconS);
        name = findViewById(R.id.item_nameS);
        price = findViewById(R.id.item_priceS);
        ajouterPanier = findViewById(R.id.ajouter);
        plus = findViewById(R.id.plus);
        moins = findViewById(R.id.moins);
        num = findViewById(R.id.num);

        String name1 = name.getText().toString();
        String price1 = price.getText().toString();


        Intent i = getIntent();

        String pname = i.getStringExtra("name");
        String pprice = i.getStringExtra("price");

        name.setText(pname);
        price.setText(pprice);
        imagev.setImageDrawable(ContextCompat.getDrawable(this, this.getResources().getIdentifier(getIntent().getStringExtra("image"), "drawable", this.getPackageName())));


        ajouterPanier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(singleGridViewActivity.this, ProductDetails.class);
//                startActivity(intent);


                ContentValues values = new ContentValues();
                values.put(productDB.COLUMN_NAME_COL1, String.valueOf(name));
                values.put(productDB.COLUMN_NAME_COL2, String.valueOf(price));
                values.put(productDB.COLUMN_NAME_COL3, quantite);

                long rowId = db.insert(productDBcontract.productDB.TABLE_NAME, null, values);
                if (rowId != -1) {
                    Toast.makeText(singleGridViewActivity.this, "Produit ajouté au panier ", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(singleGridViewActivity.this, "réessayez de nouveau ! ", Toast.LENGTH_SHORT).show();
                }

            }

        });
        plus.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {

                                           quantite++;
                                           displayQuantity();

                                       }
                                   }
        );


        moins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // because we dont want the quantity go less than 0
                if (quantite == 0) {
                    Toast.makeText(singleGridViewActivity.this, "impossible de diminuer la quantité", Toast.LENGTH_SHORT).show();
                } else {
                    quantite--;
                    displayQuantity();


                }
            }
        });


//        private int CalculatePrice() {
//            return price1 * quantite;
//        }


    }


    private void displayQuantity() {
        num.setText(String.valueOf(quantite));
    }


}


