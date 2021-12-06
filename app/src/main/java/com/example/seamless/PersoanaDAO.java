package com.example.seamless;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PersoanaDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert (Persoana_Bazadedate... client);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Persoana_Bazadedate... client);

    @Delete
    void delete(Persoana_Bazadedate client);

    @Query("SELECT * FROM clienti")
    public List<Persoana_Bazadedate> getAll();

    @Query("SELECT * FROM clienti WHERE `numar comenzi` > :nrcomenzi")
    List<Persoana_Bazadedate> getPersoanaComenziHigh(int nrcomenzi);

    @Query("DELETE FROM clienti")
    void deleteAll();
}
























