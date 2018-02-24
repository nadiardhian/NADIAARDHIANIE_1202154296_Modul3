package com.example.android.nadiardhian.mobile;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;

/**
 * Created by user on 2/24/2018.
 */

public class Drink { //definisikan apa saja yang akan di tampilkan di detail activity
    private final String title; //definisikan judul
    private final String info; //definisikan info
    private final int imageResource; //definisikan foto
    private final String detailDrink; //definisikan detail

    static final String TITLE_KEY = "Title"; //di definisikan sebagai kata kunci untuk mengambil data ada judul foto dan detail
    static final String IMAGE_KEY = "Image Resource";
    static final String DETAIL_KEY = "Detail";


    Drink(String title, String info, int imageResource, String detailDrink) { //konstruktor Drink yang berisi parameter untuk title, info, imageResource dan Detail
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
        this.detailDrink = detailDrink;
    }


    String getTitle(){//getter untuk title drink
        return title;
    }


    String getInfo(){ //getter untuk info drink
        return info;
    }


    int getImageResource(){ //getter untuk imageResource drink
        return imageResource;
    }


    String getDetail() { //getter untuk detail drink
        return detailDrink;
    }


    static Intent starter(Context context, String title, @DrawableRes int imageResId, String detailDrink) { //Intent dan putExtra dari MainActivity ke DetailActivity
        Intent detailIntent = new Intent(context, DetailActivity.class);
        detailIntent.putExtra(TITLE_KEY, title);
        detailIntent.putExtra(IMAGE_KEY, imageResId);
        detailIntent.putExtra(DETAIL_KEY, detailDrink);
        return detailIntent;
    }
}

