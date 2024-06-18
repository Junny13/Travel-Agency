package com.example.happytraveler;

import androidx.room.Embedded;

public class PinakasJoined {
    @Embedded
    PinakasPakEkdr p1;

    @Embedded
    PinakasEkdr p2;

    @Embedded
    PinakasTaksid p3;

    public PinakasPakEkdr getPakEkdr() { return p1; }
    public PinakasEkdr getEkdr() { return p2; }
    public PinakasTaksid getTaksid() { return p3; }
    //Getter and setter...
}