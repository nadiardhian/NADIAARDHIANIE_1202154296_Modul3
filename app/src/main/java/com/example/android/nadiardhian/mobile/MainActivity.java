package com.example.android.nadiardhian.mobile;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Member variables
    private RecyclerView mRecyclerView; //deklarasi recyclerview yang sudah di buat di xml
    private ArrayList<Drink> mDrinksData; //array untuk menampilkan list
    private DrinksAdapter mAdapter; //dan adapternya untuk menampung data array

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView); //Inisialisasi RecyclerView
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count); //Get jumlah kolom yang sesuai

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));  //Recyclerview menggunakan Layout Manager jadi harus di set terlebih dahulu
        mDrinksData = new ArrayList<>();//Inisalisasi ArrayList yang berisi data

        mAdapter = new DrinksAdapter(this, mDrinksData); //Inisialisasi adapter dan set ke dalam RecyclerView
        mRecyclerView.setAdapter(mAdapter);

        initializeData(); //Get data
    }

    private void initializeData() { //Get resources dari file XML
        String[] drinksList = getResources().getStringArray(R.array.drinks_titles); //berasal dari string yang mendifinisikan array judul minuman
        String[] drinksInfo = getResources().getStringArray(R.array.info_produk); //berasal dari string yang mendifinisikan array info minuman
        TypedArray drinksImageResources = getResources().obtainTypedArray(R.array.foto_produk); //berasal dari string yang mendifinisikan array foto minuman
        String[] drinksDetail = getResources().getStringArray(R.array.detail_product); //berasal dari string yang mendifinisikan array detail minuman
        mDrinksData.clear(); //Menghapus data(untuk menghindari duplikasi


        for(int i = 0; i<drinksList.length; i++){ //Membuat ArrayList dari objek Drinks yang berisi titles, gambar dan penjelasan tiap drink
            mDrinksData.add(new Drink(drinksList[i], drinksInfo[i],
                    drinksImageResources.getResourceId(i,0), drinksDetail[i]));
        }


        drinksImageResources.recycle();

        mAdapter.notifyDataSetChanged(); //Notifikasi perubahan adapter
    }
}