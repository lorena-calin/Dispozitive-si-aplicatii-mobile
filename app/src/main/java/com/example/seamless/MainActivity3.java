package com.example.seamless;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity3 extends AppCompatActivity {

    private ListView lv;
    private MeniuAdapter meniuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        lv = findViewById(R.id.listview);
        meniuAdapter=new MeniuAdapter(getList());
        lv.setAdapter(meniuAdapter);

        JsonReader reader=new JsonReader();
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                reader.read("https://jsonkeeper.com/b/VPPJ", new IResponse() {
                    @Override
                    public void onSuccess(List<Meniuri> restaurante) {

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity3.this,restaurante.toString(),Toast.LENGTH_LONG).show();
                            }
                        });
                    }

                    @Override
                    public void onError(String mesaj) {

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity3.this,mesaj,Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                });
            }
        });
        thread.start();


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Random r=new Random(1);
                int alegere=r.nextInt();

                if (alegere%2==0) {
                    meniuAdapter.updateList(getList());
                }
                else meniuAdapter.updateList(getList2());
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Meniuri m=meniuAdapter.getItem(position);
                Toast.makeText(MainActivity3.this,m.toString(),Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }

    private List<Meniuri> getList() {
        ArrayList<Meniuri> lista=new ArrayList<>();
        Meniuri restaurant1=new Meniuri("Tres Olivos", 4.9f, "Livrare gratis comanda minima 30 lei", "Prima comanda de pe Seamless are livrarea gratuita!");
        Meniuri restaurant2=new Meniuri("Prestij",  4.7f, "Livrare gratis comanda minima 30 lei", "Voucher la prima comanda 20% reducere!");
        Meniuri restaurant3=new Meniuri("Mcdonalds", 4.5f, "Cost livrare 8 lei", "La orice meniu mare premium, primesti un mcpuisor gratuit!");
        Meniuri restaurant4=new Meniuri("KFC", 4.6f, "Cost livrare 6,99 lei", "Pana la ora 10, la orice comanda de minim 20 lei, primesti o cafea gratis");
        Meniuri restaurant5=new Meniuri("Best Restaurant", 4.3f, "Livrare gratis comanda minima 40 lei", "Oferta mini burgers-35 lei!");
        Meniuri restaurant6=new Meniuri("Shaormeria Baneasa", 4.9f, "Cost livrare 3,99 lei", "Prima comanda de pe Seamless are livrarea gratuita!");
        Meniuri restaurant7=new Meniuri("Le BonBon", 4.7f, "Livrare comanda minima 30 lei", "Prima comanda de pe Seamless are livrarea gratuita!");
        Meniuri restaurant8=new Meniuri("Pizza Hut", 4.8f, "Livrare comanda minima 35 lei", "Voucher 20% reducere la prima comanda!");
        Meniuri restaurant9=new Meniuri("Cartofisserie", 4.6f, "Livrare comanda minima 30 lei", "Prima comanda de pe Seamless are livrarea gratuita!");
        Meniuri restaurant10=new Meniuri("Starbucks", 4.8f, "Cost livrare 5,99 lei", "Meniu mic-dejun, croissant si cafea grande, 15 lei!");

        lista.add(restaurant1);
        lista.add(restaurant2);
        lista.add(restaurant3);
        lista.add(restaurant4);
        lista.add(restaurant5);
        lista.add(restaurant6);
        lista.add(restaurant7);
        lista.add(restaurant8);
        lista.add(restaurant9);
        lista.add(restaurant10);

        return lista;
    }

    private List<Meniuri> getList2() {
        ArrayList<Meniuri> lista=new ArrayList<>();
        Meniuri restaurant1=new Meniuri("Tres Olivos", 4.9f, "Livrare gratis comanda minima 30 lei", "Prima comanda de pe Seamless are livrarea gratuita!");
        Meniuri restaurant2=new Meniuri("Prestij",  4.7f, "Livrare gratis comanda minima 30 lei", "Voucher la prima comanda 20% reducere!");
        Meniuri restaurant3=new Meniuri("Mcdonalds", 4.5f, "Cost livrare 8 lei", "La orice meniu mare premium, primesti un mcpuisor gratuit!");
        Meniuri restaurant4=new Meniuri("KFC", 4.6f, "Cost livrare 6,99 lei", "Pana la ora 10, la orice comanda de minim 20 lei, primesti o cafea gratis");
        Meniuri restaurant5=new Meniuri("Best Restaurant", 4.3f, "Livrare gratis comanda minima 40 lei", "Oferta mini burgers-35 lei!");
        Meniuri restaurant6=new Meniuri("Shaormeria Baneasa", 4.9f, "Cost livrare 3,99 lei", "Prima comanda de pe Seamless are livrarea gratuita!");
        Meniuri restaurant7=new Meniuri("Le BonBon", 4.7f, "Livrare comanda minima 30 lei", "Prima comanda de pe Seamless are livrarea gratuita!");
        Meniuri restaurant8=new Meniuri("Pizza Hut", 4.8f, "Livrare comanda minima 35 lei", "Voucher 20% reducere la prima comanda!");
        Meniuri restaurant9=new Meniuri("Cartofisserie", 4.6f, "Livrare comanda minima 30 lei", "Prima comanda de pe Seamless are livrarea gratuita!");
        Meniuri restaurant10=new Meniuri("Starbucks", 4.8f, "Cost livrare 5,99 lei", "Meniu mic-dejun, croissant si cafea grande, 15 lei!");

        lista.add(restaurant1);
        lista.add(restaurant2);
        lista.add(restaurant3);
        lista.add(restaurant4);
        lista.add(restaurant5);
        lista.add(restaurant6);
        lista.add(restaurant7);
        lista.add(restaurant8);
        lista.add(restaurant9);
        lista.add(restaurant10);

        return lista;
    }
}