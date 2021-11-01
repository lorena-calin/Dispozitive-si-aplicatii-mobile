package com.example.seamless;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MeniuAdapter extends BaseAdapter {

    private List<Meniuri> listaMeniuri=new ArrayList<>();

    public MeniuAdapter(List<Meniuri> lista) {
        listaMeniuri=lista;
    }

    @Override
    public int getCount() {
        return listaMeniuri.size();
    }

    @Override
    public Meniuri getItem(int position) {
        return listaMeniuri.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view1=inflater.inflate(R.layout.item_menu, parent, false);
        TextView textNume=view1.findViewById(R.id.nume);
        TextView textRecenzie=view1.findViewById(R.id.recenzie);
        TextView textLivrare=view1.findViewById(R.id.livrare);
        TextView textOferta=view1.findViewById(R.id.oferta);

        Meniuri temp=listaMeniuri.get(position);
        textNume.setText(temp.getNume());
        textRecenzie.setText(temp.getRecenzie()+"");
        textLivrare.setText(temp.getLivrare());
        textOferta.setText(temp.getOferta());
        return view1;
    }

    public void updateList(List<Meniuri> lista){
        listaMeniuri.clear();
        listaMeniuri.addAll(lista);
        notifyDataSetChanged();

    }
}
