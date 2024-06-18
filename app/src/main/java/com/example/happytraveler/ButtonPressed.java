package com.example.happytraveler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ButtonPressed extends AppCompatActivity {

    String name, address;
    int ID;

    EditText editTextTaksID;
    EditText editTextName;
    EditText editTextAddress;

    Button buttonAddTaksid;
    Button buttonclickme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_pressed);
        getSupportActionBar().setTitle("Δημιουργία Νέου Ταξιδιωτικού");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getFragmentManager().popBackStack();


        editTextTaksID=(EditText) findViewById(R.id.editTextTaksID);
        editTextName=(EditText) findViewById(R.id.editTextName);
        editTextAddress=(EditText) findViewById(R.id.editTextAddress);

        editTextName.setSelectAllOnFocus(true);
        editTextTaksID.setSelectAllOnFocus(true);
        editTextAddress.setSelectAllOnFocus(true);


        buttonAddTaksid=(Button) findViewById(R.id.buttonAddTaksid);
        buttonAddTaksid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                name= editTextName.getText().toString();
//                address=editTextAddress.getText().toString();
//                ID=Integer.valueOf(editTextTaksID.getText().toString());
//
//                showToast("Δημιουργήθηκε Ταξιδιωτικό με τιμές:");
//                showToast(String.valueOf(ID));
//                showToast(name);
//                showToast(address);

                    int Var_taxiid = 0;
                    try {
                        Var_taxiid = Integer.parseInt(editTextTaksID.getText().toString());
                    } catch (NumberFormatException ex) {
                        System.out.println("Could not parse " + ex);
                    }
                    String Var_name = editTextName.getText().toString();
                    String Var_address = editTextAddress.getText().toString();



                    try {
                    PinakasTaksid taksid = new PinakasTaksid();
                    taksid.setId(Var_taxiid);
                    taksid.setName(Var_name);
                    taksid.setAddress(Var_address);

                    MainDrawerActivity.database.MyDao().addTaksid(taksid);
                    Toast.makeText(ButtonPressed.this, "Η εγγραφή καταχωρήθηκε.", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    String message = e.getMessage();
                    Toast.makeText(ButtonPressed.this, message, Toast.LENGTH_LONG).show();
                        Toast.makeText(ButtonPressed.this, "Record not added.", Toast.LENGTH_LONG).show();

                    }

                editTextName.setText("");
                editTextAddress.setText("");
                editTextTaksID.setText("");
            }

        });

        buttonclickme=(Button) findViewById(R.id.buttonclickme);
        buttonclickme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ButtonPressed.this, UpdateDeleteTaksid.class);
                ButtonPressed.this.startActivity(myIntent);
            }
        });

    }



}