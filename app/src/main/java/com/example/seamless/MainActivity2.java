package com.example.seamless;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private Button btnsalvare;
    private EditText etnNume;
    private EditText etnEmail;
    private EditText etnParola;
    private EditText etnAdresa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnsalvare = findViewById(R.id.btnSalvare);
        etnNume = findViewById(R.id.etnNume);
        etnEmail = findViewById(R.id.etnEmail);
        etnParola = findViewById(R.id.etnParola);
        etnAdresa=findViewById(R.id.etnAdresa);
        btnsalvare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValid()) {
                    Toast.makeText(MainActivity2.this, "Ati salvat datele cu succes!", Toast.LENGTH_LONG).show();
                    Persoana p1 = new Persoana();
                    p1.setNume(etnNume.getText().toString());
                    p1.setEmail(etnEmail.getText().toString());
                    p1.setParola(etnParola.getText().toString());
                    p1.setAdresa(etnAdresa.getText().toString());
                    Toast.makeText(MainActivity2.this, p1.toString(), Toast.LENGTH_LONG).show();
                    Bundle wrapperObject=new Bundle();
                    wrapperObject.putSerializable("persoana",p1);
                    Intent intent=new Intent();
                    intent.putExtra("raspunsBundle",wrapperObject);
                    setResult(RESULT_OK,intent);
                    finish();

                }
            }
        });
    }

            boolean isEmailValid(CharSequence email) {
                return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
            }

            private boolean isValid() {

                if(etnEmail.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity2.this, "Completeaza email!",Toast.LENGTH_LONG).show();
                    return false;
                }
                if(!(isEmailValid(etnEmail.getText().toString()))){
                    Toast.makeText(MainActivity2.this, "Introduce o adresa de email valida!",Toast.LENGTH_LONG).show();
                    return false;
                }
                if(etnParola.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity2.this, "Completeaza parola!",Toast.LENGTH_LONG).show();
                    return false;
                }
                if(etnAdresa.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity2.this, "Completeaza adresa!",Toast.LENGTH_LONG).show();
                    return false;
                }

                return true;
                
            }


    }
