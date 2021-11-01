package com.example.seamless;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnlogin;
    private EditText etEmail;
    private EditText etParola;
    private Button btnmembru;
    private final int mainActivityRequest=100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("tagCautare","Found");
        Log.e("tagCautare","Found Eroare");
        Log.i("tagCautare","Info");
        Log.d("tagCautare","Debug");

       Log.v("lifecycle","onCreate");

       btnlogin= findViewById(R.id.btnlogin);
       etEmail=findViewById(R.id.etEmail);
       etParola=findViewById(R.id.etParola);
       btnlogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (isValid()) {
                   Toast.makeText(MainActivity.this, "Ati intrat in cont cu succes!", Toast.LENGTH_LONG).show();
                   Intent newWindow=new Intent(MainActivity.this,MainActivity3.class);
                   startActivity(newWindow);
               }
           }
       });

        btnmembru= findViewById(R.id.btncontnou);
        btnmembru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Hai sa incepem!",Toast.LENGTH_LONG).show();
                Intent newWindow=new Intent(MainActivity.this,MainActivity2.class);
               // startActivity(newWindow);
                startActivityForResult(newWindow,mainActivityRequest);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.v("lifecycle","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.v("lifecycle","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.v("lifecycle","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.v("lifecycle","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.v("lifecycle","onDestroy");
    }

    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValid() {

        if (etEmail.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Completeaza email!", Toast.LENGTH_LONG).show();
            return false;
        }
        if (!(isEmailValid(etEmail.getText().toString()))) {
            Toast.makeText(MainActivity.this, "Introduce o adresa de email valida!", Toast.LENGTH_LONG).show();
            return false;
        }
        if (etParola.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Completeaza parola!", Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == mainActivityRequest) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    Bundle newBundle=data.getBundleExtra("raspunsBundle");
                    Persoana persoana=(Persoana) newBundle.getSerializable("persoana");
                    etEmail.setText(persoana.getEmail());
                    etParola.setText(persoana.getParola());
                }
            }
        }
    }
}