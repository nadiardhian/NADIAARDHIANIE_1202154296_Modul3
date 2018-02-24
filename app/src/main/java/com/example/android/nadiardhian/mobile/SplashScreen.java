package com.example.android.nadiardhian.mobile;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {
    // Splash screen timer
    private static int splashInterval = 2000; //waktu jeda 2 detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //menghilangkan ActionBar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, //splashscreen yang di tampilkan akan fullscreen
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen); //layout splash screen

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {  //menjalankan splash screen
                //Memulai main activity
                Intent i = new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(i);
                //Toast ketika splashscreen muncul
                Toast.makeText(SplashScreen.this,"NADIAARDHIANIE_1202154296", Toast.LENGTH_LONG).show();
                this.finish();
            }
            //Aktivity selesai
            private void finish(){

            }
            //timer saat splashscreen selesai
        }, splashInterval);
    }
}
