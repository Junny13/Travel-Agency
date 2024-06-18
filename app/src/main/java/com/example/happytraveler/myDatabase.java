package com.example.happytraveler;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;


@Database(entities = {PinakasTaksid.class,PinakasEkdr.class,PinakasPakEkdr.class}, version = 2)

public abstract class myDatabase extends RoomDatabase{
    public static myDatabase database;
    public abstract myDao MyDao();


}
