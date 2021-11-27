package com.example.daggerapplication.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProductDao {
    @Query("SELECT * FROM Product WHERE id=:id")
    List<Product> findById(int id);

    @Query("SELECT * FROM Product")
    List<Product> findAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Product product);

    @Delete
    int delete(Product product);

    default String getDB() {
        return "DB Call Success";
    }
}
