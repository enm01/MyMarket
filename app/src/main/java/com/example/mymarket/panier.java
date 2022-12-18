package com.example.mymarket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mymarket.adapters.ProductDetailsAdapter;
import com.example.mymarket.productDBcontract.productDB;

import java.util.ArrayList;
import java.util.List;
public class panier extends AppCompatActivity {
    productDBHelper dbHelper;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter userAdapter;
    private RecyclerView.LayoutManager layoutManager;

    List<ProductDetails> productDetailsList;
    SQLiteDatabase db;
    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panier);

                dbHelper = new productDBHelper(this);
                db = dbHelper.getReadableDatabase();
                recyclerView = (RecyclerView) findViewById(R.id.rv_product);

                productDetailsList = new ArrayList<ProductDetails>();
                productDetailsList.clear();
                Cursor c1 = db.query(productDB.TABLE_NAME, null, null, null, null, null, null);
                if (c1 != null && c1.getCount() != 0) {
                    productDetailsList.clear();
                    while (c1.moveToNext()) {
                        ProductDetails productDetailsItem = new ProductDetails();

                        productDetailsItem.setName(c1.getString(c1.getColumnIndex(productDB.COLUMN_NAME_COL1)));
                        productDetailsItem.setPrice(c1.getString(c1.getColumnIndex(productDB.COLUMN_NAME_COL2)));
                        productDetailsItem.setQuantite(c1.getString(c1.getColumnIndex(productDB.COLUMN_NAME_COL3)));

                        productDetailsList.add(productDetailsItem);
                    }
                }
                c1.close();
                layoutManager = new LinearLayoutManager(this);
                userAdapter = new ProductDetailsAdapter(productDetailsList);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(userAdapter);
            }
            @Override
            protected void onDestroy() {
                db.close();
                super.onDestroy();
            }

    }
