package com.example.android.nadiardhian.mobile;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private Button btnPlus, btnMinus; //dekralasi button yang ada di detail activity
    private ImageView capacity; //deklarasi kapasitas yang ada
    private TextView status; //deklarasi status kapasitasnya
    private int level =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView drinksTitle = (TextView)findViewById(R.id.titleDetail); // get id judul minuman
        ImageView drinksImage = (ImageView)findViewById(R.id.drinksImageDetail); //get id foto minuman
        TextView drinksDetail = (TextView)findViewById(R.id.subTitleDetail); //get id detail minuman


        Drawable drawable = ContextCompat.getDrawable
                (this,getIntent().getIntExtra(Drink.IMAGE_KEY, 0)); //Get drawable


        GradientDrawable gradientDrawable = new GradientDrawable(); //Membuat placeholder abu-abu scrim saat gambar dimuat
        gradientDrawable.setColor(Color.GRAY);


        if(drawable!=null) {
            gradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight()); //Menyamakan ukuran dengan image
        }


        drinksTitle.setText(getIntent().getStringExtra(Drink.TITLE_KEY)); //aktifkan intent dengan kata kunci tittle
        Toast.makeText(DetailActivity.this,"Berikut detail dari air mineral merk " + drinksTitle.getText(), Toast.LENGTH_LONG).show(); //toast yang akan dikeluarkan dan get nama air jadi judul


        Glide.with(this).load(getIntent().getIntExtra(Drink.IMAGE_KEY,0)) //Load image menggunakan glide library dan Intent extra
                .placeholder(gradientDrawable).into(drinksImage);


        drinksDetail.setText(getIntent().getStringExtra(Drink.DETAIL_KEY)); //Set text dari Intent extra

        btnPlus = (Button) findViewById(R.id.btnPlus); //get id button plus
        btnMinus = (Button) findViewById(R.id.btnMinus); //get id button minus
        capacity = (ImageView) findViewById(R.id.imgBotol); //get capasitas dengan id image botol
        status = (TextView) findViewById(R.id.status); //get status


        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCapacity();
            }
        }); //Ketika button plus diklik maka akan menjalankan method addCapacity


        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                minusCapacity();
            }
        }); //Ketika button minus diklik maka akan menjalankan method minusCapacity

    }


    private void minusCapacity() { //Method minusCapacity dan toast apabila mencapai level 0
        status();
        if(level==0){
            Toast.makeText(this,"Air Terisi Sedikit",Toast.LENGTH_SHORT).show();
            return;
        }

        capacity.setImageLevel(--level); //setImage dari capacity.xml yang berisi vector asset dari botol
    }


    private void addCapacity() { //Method addCapacity dan toast apabila mencapai level 6
        status();
        if(level==6){
            Toast.makeText(this,"Air Terisi Penuh",Toast.LENGTH_SHORT).show();
            return;
        }

        capacity.setImageLevel(++level); //setImage dari capacity.xml yang berisi vector asset dari botol
    }


    private void status() { //Method status untuk mengisi status pada textView status
        int i = level + 1;
        status.setText(""+ i +"L");
    }


}
