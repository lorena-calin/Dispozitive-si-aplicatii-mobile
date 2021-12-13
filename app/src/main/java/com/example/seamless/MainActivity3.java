package com.example.seamless;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity3 extends AppCompatActivity {

    private ListView lv;
    private MeniuAdapter meniuAdapter;
    private PersoanaDAO persoanaDAO;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        lv = findViewById(R.id.listview);
        meniuAdapter=new MeniuAdapter(getList());
        lv.setAdapter(meniuAdapter);
        writeToDataBase();

        persoanaDAO=Database.getInstance(this).getDatabase().persoanaDAO();
        List<Persoana_Bazadedate> lista2=getPersoana();
    //    persoanaDAO.insert(lista2.get(0),lista2.get(1));
        for (int i=0;i<lista2.size();i++){
            persoanaDAO.insert(lista2.get(i));
        }
        List<Persoana_Bazadedate> lista3=persoanaDAO.getPersoanaComenziHigh(3);
        Log.v("comenziHigh",lista3.toString());

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                persoanaDAO = Database.getInstance(MainActivity3.this).getDatabase().persoanaDAO();
                List<Persoana_Bazadedate> lista = getPersoana();
                persoanaDAO.deleteAll();
                for(int i=0; i<lista.size();i++){
                    persoanaDAO.insertAll(lista.get(i));
                }
            }
        });
        thread.start();

        JsonReader reader=new JsonReader();
        Thread thread2=new Thread(new Runnable() {
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
        ArrayList<Meniuri> lista1=new ArrayList<>();
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

        lista1.add(restaurant1);
        lista1.add(restaurant2);
        lista1.add(restaurant3);
        lista1.add(restaurant4);
        lista1.add(restaurant5);
        lista1.add(restaurant6);
        lista1.add(restaurant7);
        lista1.add(restaurant8);
        lista1.add(restaurant9);
        lista1.add(restaurant10);

        return lista1;
    }


    public List<Persoana_Bazadedate> getPersoana(){
        Persoana_Bazadedate persoana1=new Persoana_Bazadedate(getPersoana().get(i).getIdclient(), "Calin","hag@ja.com","haghg",5);
        Persoana_Bazadedate persoana2=new Persoana_Bazadedate(getPersoana().get(i).getIdclient(), "Andrei","hags@jahs.com","jagah",9);
        List<Persoana_Bazadedate> lista2=new ArrayList<>();
        lista2.add(persoana1);
        lista2.add(persoana2);
        return lista2;
    }

    private void writeToDataBase(){
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://seamless-dbf48-default-rtdb.firebaseio.com/");
        DatabaseReference myRef = database.getReference("Persoana");
        for (int i=0;i<getPersoana().size();i++){
            Persoana_Bazadedate p = new Persoana_Bazadedate (getPersoana().get(i).getIdclient(),
                    getPersoana().get(i).getNume(),getPersoana().get(i).getEmail(),
                    getPersoana().get(i).getParola(),
                    getPersoana().get(i).getNrcomenzi());
            myRef.child("Persoana cu numarul "+ i).setValue(p);
        }
    }

    private void readFromDatabase(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Persoana");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    Persoana_Bazadedate p = new Persoana_Bazadedate(dataSnapshot1.getValue(Persoana_Bazadedate.class).getIdclient(),
                            dataSnapshot1.getValue(Persoana_Bazadedate.class).getNume(),
                            dataSnapshot1.getValue(Persoana_Bazadedate.class).getEmail(),
                            dataSnapshot1.getValue(Persoana_Bazadedate.class).getParola(),
                            dataSnapshot1.getValue(Persoana_Bazadedate.class).getNrcomenzi()
                    );
                    Log.d("citire","Persoana citita " + p.toString());
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w("cancelled", "Failed to read value.", error.toException());
            }
        });
    }

}