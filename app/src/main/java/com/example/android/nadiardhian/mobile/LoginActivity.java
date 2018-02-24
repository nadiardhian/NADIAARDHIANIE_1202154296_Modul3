package com.example.android.nadiardhian.mobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText username, password; //deklarasi username dan password
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        username = (EditText)findViewById(R.id.username); //get username dengan id username
        password = (EditText)findViewById(R.id.password); //get password dengan id password

    }

    public void login(View view) { //ketika button login di klik
        final String user = username.getText().toString(); //get text dari username dan password
        String pass = password.getText().toString();

        //pengkondisian untuk login
        if(user.equals("EAD") && pass.equals("MOBILE")){ //apabila username EAD dan pass MOBILE
            Toast.makeText(this,"Anda berhasil login", Toast.LENGTH_LONG).show(); //akan muncul toast ini
            Intent login = new Intent(LoginActivity.this,MainActivity.class); //Melakukan intent ke aktivitas Main
            startActivity(login); //menjalankan activity

        }else if(user.isEmpty() || pass.isEmpty()){ //kondisi apabila text username atau password kosong
            Toast.makeText(this,"Silahkan isi terlebih dahulu", Toast.LENGTH_LONG).show(); //akan muncul toast seperti ini
        }else{
            //kondisi apabila username atau password yang dimasukkan salah
            Toast.makeText(this,"Login gagal",Toast.LENGTH_LONG).show(); //akan muncul toast ini
        }
    }
}