package com.example.happytraveler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ButtonPressedPakEkdr extends AppCompatActivity {

    int P_ID,T_ID, EK_ID, date, price;

    EditText editTextPakId;
    EditText editTextTaksID2;
    EditText editTextEkdrId2;
    EditText editTextDate;
    EditText editTextPrice;

    Button button;
    Button buttonclickme3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_pressed_pak_ekdr);

         getSupportActionBar().setTitle("Δημιουργία Νέου Πακέτου Εκδρομής");
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        editTextPakId=(EditText) findViewById(R.id.editTextPakId);
        editTextTaksID2=(EditText) findViewById(R.id.editTextTaksID2);
        editTextEkdrId2=(EditText) findViewById(R.id.editTextEkdrId2);
        editTextDate=(EditText) findViewById(R.id.editTextDate);
        editTextPrice=(EditText) findViewById(R.id.editTextPrice);

        editTextPakId.setSelectAllOnFocus(true);
        editTextTaksID2.setSelectAllOnFocus(true);
        editTextEkdrId2.setSelectAllOnFocus(true);
        editTextDate.setSelectAllOnFocus(true);
        editTextPrice.setSelectAllOnFocus(true);



        button=(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                //P_ID,T_ID, EK_ID, date, price
//                P_ID=Integer.valueOf(editTextPakId.getText().toString());
//                T_ID=Integer.valueOf(editTextTaksID2.getText().toString());
//                EK_ID=Integer.valueOf(editTextEkdrId2.getText().toString());
//                date=Integer.valueOf(editTextDate.getText().toString());
//                price=Integer.valueOf(editTextPrice.getText().toString());
//
//                showToast("Δημιουργήθηκε Εκδρομή με τιμές:");
//                showToast(String.valueOf(P_ID));
//                showToast(String.valueOf(T_ID));
//                showToast(String.valueOf(EK_ID));
//                showToast(String.valueOf(date));
//                showToast(String.valueOf(price));

                int Var_pakekid = 0;
                try {
                    Var_pakekid = Integer.parseInt(editTextPakId.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                int Var_taksid = 0;
                try {
                    Var_taksid = Integer.parseInt(editTextTaksID2.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                int Var_ekdrid = 0;
                try {
                    Var_ekdrid = Integer.parseInt(editTextEkdrId2.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                int Var_price = 0;
                try {
                    Var_price = Integer.parseInt(editTextPrice.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                String Var_date = editTextDate.getText().toString();


                try {
                    PinakasPakEkdr pakekdr = new PinakasPakEkdr();
                    pakekdr.setIdpaketouek(Var_pakekid);
                    pakekdr.setIdekdr(Var_ekdrid);
                    pakekdr.setIdtaksid(Var_taksid);
                    pakekdr.setDate(Var_date);
                    pakekdr.setPrice(Var_price);
                    MainDrawerActivity.database.MyDao().addPakEkdr(pakekdr);
                    Toast.makeText(ButtonPressedPakEkdr.this, "Record added.", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    String message = e.getMessage();
                    Toast.makeText(ButtonPressedPakEkdr.this, message, Toast.LENGTH_LONG).show();
                    Toast.makeText(ButtonPressedPakEkdr.this, "Record added.", Toast.LENGTH_LONG).show();

                }
                editTextPakId.setText("");
                editTextEkdrId2.setText("");
                editTextTaksID2.setText("");
                editTextDate.setText("");
                editTextPrice.setText("");





            }
        });
        buttonclickme3=(Button) findViewById(R.id.buttonclickme3);
        buttonclickme3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ButtonPressedPakEkdr.this, UpdateDeletePakEk.class);
                ButtonPressedPakEkdr.this.startActivity(myIntent);
            }
        });
    }
}