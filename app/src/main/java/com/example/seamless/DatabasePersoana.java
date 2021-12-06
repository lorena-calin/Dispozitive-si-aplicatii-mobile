package com.example.seamless;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Persoana_Bazadedate.class}, version=1, exportSchema = false)
public abstract class DatabasePersoana extends RoomDatabase {

    public abstract PersoanaDAO persoanaDAO();
}
