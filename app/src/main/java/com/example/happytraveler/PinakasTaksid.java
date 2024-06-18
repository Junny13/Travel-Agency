package com.example.happytraveler;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "PinakasTaksid")
public class PinakasTaksid {
    @PrimaryKey @ColumnInfo(name = "T_ID")
    private int id;
    @ColumnInfo(name = "NameTaks")
    private String name;

    @ColumnInfo(name = "AddressTaks")
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



}
