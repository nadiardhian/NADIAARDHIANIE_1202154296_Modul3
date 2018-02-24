package com.example.android.nadiardhian.mobile;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by user on 2/24/2018.
 */

public class DrinksAdapter extends RecyclerView.Adapter<DrinksAdapter.DrinksViewHolder>{
    private GradientDrawable mGradientDrawable;
    private ArrayList<Drink> mDrinksData; //panggil array untuk di definisikan di class ini agar bisa ditampilkan
    private Context mContext;

    DrinksAdapter(Context context, ArrayList<Drink> drinksData) {
        this.mDrinksData = drinksData;
        this.mContext = context;


        mGradientDrawable = new GradientDrawable(); //Prepare gray placeholder
        mGradientDrawable.setColor(Color.GRAY);


        Drawable drawable = ContextCompat.getDrawable //Make the placeholder same size as the images
                (mContext,R.drawable.ades);
        if(drawable != null) {
            mGradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }

    @Override
    public DrinksAdapter.DrinksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DrinksViewHolder(mContext, LayoutInflater.from(mContext).
                inflate(R.layout.list_item, parent, false), mGradientDrawable);
    }

    @Override
    public void onBindViewHolder(DrinksAdapter.DrinksViewHolder holder, int position) {
        Drink currentDrink = mDrinksData.get(position); //Get the current sport


        holder.bindTo(currentDrink); //Bind the data to the views
    }

    @Override
    public int getItemCount() {
        return mDrinksData.size();
    }

    static class DrinksViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{

        //Member Variables for the holder data
        private TextView mTitleText;
        private TextView mKeteranganText;
        private ImageView mDrinksImage;
        private Context mContext;
        private Drink mCurrentDrink;
        private GradientDrawable mGradientDrawable;
        private TextView mDetailDrink;

        DrinksViewHolder(Context context, View itemView, GradientDrawable gradientDrawable) {
            super(itemView);

            //Inisialisasi views
            mTitleText = (TextView)itemView.findViewById(R.id.merk); //get judul dengan id merek
            mKeteranganText = (TextView)itemView.findViewById(R.id.keterangan); //get keterangan dengan id keterangan
            mDrinksImage = (ImageView)itemView.findViewById(R.id.drinksImage); //get foto dengan id drinks image
            mDetailDrink = (TextView)itemView.findViewById(R.id.detailDrink); //get detail dengan id detail drink

            mContext = context;
            mGradientDrawable = gradientDrawable;


            itemView.setOnClickListener(this); //Set OnClickListener pada setiap view
        }

        void bindTo(Drink currentDrink){
            mTitleText.setText(currentDrink.getTitle()); //Menempatkan textviews dengan data
            mKeteranganText.setText(currentDrink.getInfo());
            mDetailDrink.setText(currentDrink.getDetail());


            mCurrentDrink = currentDrink;  //Melakukan get current drink




            Glide.with(mContext).load(currentDrink.
                    getImageResource()).placeholder(mGradientDrawable).into(mDrinksImage); //Mengisi images ke ImageView menggunakan Glide library
        }

        @Override
        public void onClick(View view) {

            Intent detailIntent = Drink.starter(mContext, mCurrentDrink.getTitle(),
                    mCurrentDrink.getImageResource(),mCurrentDrink.getDetail()); //Setting detail intent



            mContext.startActivity(detailIntent); //Memulai detail activity
        }
    }
}
