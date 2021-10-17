package com.example.seamless;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnlogin;
    private Button btnmembru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("tagCautare","Found");
        Log.e("tagCautare","Found Eroare");
        Log.i("tagCautare","Info");
        Log.d("tagCautare","Debug");

        Toast.makeText(this,"Salut",Toast.LENGTH_LONG).show();

       Log.v("lifecycle","onCreate");

       btnlogin= findViewById(R.id.button);
       btnlogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(MainActivity.this, "Ati creat cont cu succes!",Toast.LENGTH_LONG).show();
               Intent newWindow=new Intent(MainActivity.this,MainActivity2.class);
               startActivity(newWindow);
           }
       });

        btnmembru= findViewById(R.id.button2);
        btnmembru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Ati intrat in cont cu succes!",Toast.LENGTH_LONG).show();
                Intent newWindow=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(newWindow);
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

}