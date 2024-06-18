package com.example.happytraveler;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "PinakasEkdr")
public class PinakasEkdr {
    @PrimaryKey @ColumnInfo(name = "ekid")
    private int id;

    @ColumnInfo(name = "poliek")
        private String poli;

    @ColumnInfo(name = "xwraek")
        private String xwra;

    @ColumnInfo(name = "diarkeiaek")
        private int diarkeia;

    @ColumnInfo(name ="eidosek")
        private String eidos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPoli() {
        return poli;
    }

    public void setPoli(String poli) {
        this.poli = poli;
    }

    public String getXwra() {
        return xwra;
    }

    public void setXwra(String xwra) {
        this.xwra = xwra;
    }

    public int getDiarkeia() {
        return diarkeia;
    }

    public void setDiarkeia(int diarkeia) {
        this.diarkeia = diarkeia;
    }

    public String getEidos() {
        return eidos;
    }

    public void setEidos(String eidos) {
        this.eidos = eidos;
    }
}
