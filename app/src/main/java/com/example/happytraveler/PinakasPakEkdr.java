package com.example.happytraveler;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity (tableName = "PinakasPakEkdr"  ,
        primaryKeys = {"idpakekdr"},
        foreignKeys = {
                @ForeignKey(entity = PinakasTaksid.class,
                        parentColumns = "T_ID",
                        childColumns = "idtaksid",
                        onUpdate = ForeignKey.CASCADE,
                        onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = PinakasEkdr.class,
                        parentColumns = "ekid",
                        childColumns = "idekd",
                        onUpdate = ForeignKey.CASCADE,
                        onDelete = ForeignKey.CASCADE)
        }
)
public class PinakasPakEkdr {
    @ColumnInfo (name = "idpakekdr")
    private int idpaketouek;

    @ColumnInfo (name = "idtaksid")
    private int idtaksid;

    @ColumnInfo (name = "idekd")
    private int idekdr;

    @ColumnInfo (name = "datePaek")
    private String date;

    @ColumnInfo (name = "pricePaek")
    private int price;


    public int getIdpaketouek() {
        return idpaketouek;
    }

    public void setIdpaketouek(int idpaketouek) {
        this.idpaketouek = idpaketouek;
    }

    public int getIdtaksid() {
        return idtaksid;
    }

    public void setIdtaksid(int idtaksid) {
        this.idtaksid = idtaksid;
    }

    public int getIdekdr() {
        return idekdr;
    }

    public void setIdekdr(int idekdr) {
        this.idekdr = idekdr;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
