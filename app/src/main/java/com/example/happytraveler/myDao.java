package com.example.happytraveler;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
import java.util.Map;

@Dao
public interface myDao {
    @Insert
        public void addTaksid(PinakasTaksid taksid);

    @Insert
        public void addEkdr(PinakasEkdr ekdr);

    @Insert
        public void addPakEkdr(PinakasPakEkdr pakekdr);

    @Query("select * from PinakasTaksid ORDER BY T_ID")
    public List<PinakasTaksid> getPinakasTaksid();

    @Query("select * from PinakasEkdr ORDER BY ekid")
    public List<PinakasEkdr> getPinakasEkdr();

    @Query("select * from PinakasPakEkdr ORDER BY idpakekdr")
    public List<PinakasPakEkdr> getPinakasPakEkdr();

    @Query("SELECT PinakasPakEkdr.* , PinakasEkdr.*, PinakasTaksid.*  FROM PinakasPakEkdr " +
            "INNER JOIN PinakasEkdr ON PinakasEkdr.ekid = PinakasPakEkdr.idekd " +
            "INNER JOIN PinakasTaksid ON PinakasTaksid.T_ID = PinakasPakEkdr.idtaksid " +
            "ORDER BY idpakekdr")
    public List<PinakasJoined> getPinakes();

    @Delete
    public int deleteTaksid(PinakasTaksid taksid);

    @Delete
    public int deleteEkdr(PinakasEkdr ekdr);

    @Delete
    public int deletePakEkdr(PinakasPakEkdr pakekdr);

    @Update
    public void updateTaksid(PinakasTaksid taksid);

    @Update
    public void updateEkdr(PinakasEkdr ekdr);

    @Update
    public void updatePakEkdr(PinakasPakEkdr pakekdr);
}
