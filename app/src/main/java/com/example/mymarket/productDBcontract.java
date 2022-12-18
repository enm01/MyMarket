package com.example.mymarket;
import android.provider.BaseColumns;

public final class productDBcontract implements BaseColumns{
    private productDBcontract() {
    }
    public static class productDB implements BaseColumns {
        public static final String TABLE_NAME = "panier";
        public static final String COLUMN_NAME_COL1 = "name";
        public static final String COLUMN_NAME_COL2 = "price";
        public static final String COLUMN_NAME_COL3 = "quantite";
        public static final String COLUMN_NAME_COL4 = "image";
    }
}
