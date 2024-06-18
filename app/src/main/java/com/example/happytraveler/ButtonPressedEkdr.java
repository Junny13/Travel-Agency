package com.example.happytraveler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ButtonPressedEkdr extends AppCompatActivity {

    String country, city, eidos ;
    int ID,days;

    EditText editTextEidos;
    EditText editTextCity;
    EditText editTextCountry;
    EditText editTextEkdrId;
    EditText editTextDiarkeia;

    Button buttonAddEkdromi;
    Button buttonclickme2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_pressed_ekdr);


        getSupportActionBar().setTitle("Δημιουργία Νέας Εκδρομής");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        editTextEidos=(EditText) findViewById(R.id.editTextEidos);
        editTextCountry=(EditText) findViewById(R.id.editTextCountry);
        editTextCity=(EditText) findViewById(R.id.editTextCity);
        editTextEkdrId=(EditText) findViewById(R.id.editTextEkdrId);
        editTextDiarkeia=(EditText) findViewById(R.id.editTextDiarkeia);

        editTextEidos.setSelectAllOnFocus(true);
        editTextCity.setSelectAllOnFocus(true);
        editTextCountry.setSelectAllOnFocus(true);
        editTextEkdrId.setSelectAllOnFocus(true);
        editTextDiarkeia.setSelectAllOnFocus(true);



        buttonAddEkdromi=(Button) findViewById(R.id.buttonAddEkdromi);
        buttonAddEkdromi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int Var_ekid = 0;
                try {
                    Var_ekid = Integer.parseInt(editTextEkdrId.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                int Var_diarkeia = 0;
                try {
                    Var_diarkeia = Integer.parseInt(editTextDiarkeia.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                String Var_eidosek = editTextEidos.getText().toString();
                String Var_poliek = editTextCity.getText().toString();
                String Var_xwraek = editTextCountry.getText().toString();


                try {
                        PinakasEkdr ekdr = new PinakasEkdr();
                        ekdr.setId(Var_ekid);
                        ekdr.setPoli(Var_poliek);
                        ekdr.setXwra(Var_xwraek);
                        ekdr.setDiarkeia(Var_diarkeia);
                        ekdr.setEidos(Var_eidosek);
                         MainDrawerActivity.database.MyDao().addEkdr(ekdr);
                         Toast.makeText(ButtonPressedEkdr.this, "Record added.", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        String message = e.getMessage();
                        Toast.makeText(ButtonPressedEkdr.this, message, Toast.LENGTH_LONG).show();
                    }
                editTextEidos.setText("");
                editTextCountry.setText("");
                editTextCity.setText("");
                editTextDiarkeia.setText("");
                editTextEkdrId.setText("");



            }

        });

        buttonclickme2=(Button) findViewById(R.id.buttonclickme2);
        buttonclickme2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ButtonPressedEkdr.this, UpdateDeleteEkdromi.class);
                ButtonPressedEkdr.this.startActivity(myIntent);
            }
        });

    }

}
