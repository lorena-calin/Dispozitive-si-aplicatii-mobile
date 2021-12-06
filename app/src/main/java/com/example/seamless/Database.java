package com.example.seamless;

import android.content.Context;

import androidx.room.Room;

public class Database {

    private static Database database;
    private DatabasePersoana databasePersoana;

    private Database(Context context){
        databasePersoana= Room.databaseBuilder(
                context,
                DatabasePersoana.class, "clienti-database"
        ).build();
    }

    public static Database getInstance(Context context){
        if(database ==null) {
            database= new Database(context);

        }
        return database;
    }

    public DatabasePersoana getDatabase(){
        return databasePersoana;
    }

}
