package com.example.happytraveler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class UpdateDeletePakEk extends AppCompatActivity {
    EditText editTextdelpakek,editTextupdatepakid,editTextUpdateidek,editTextUpdateidtak,editTextUpdateDate,editTextUpdatePrice;
    Button buttondelpakek, buttonupdatepakek,buttonfindid;
    PinakasPakEkdr pinakasPakEkdr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete_pak_ek);
        Intent intent = getIntent();

        getSupportActionBar().setTitle("Διαγραφή/Ενημέρωση Πακέτου Εκδρομής");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getFragmentManager().popBackStack();

        editTextdelpakek=(EditText) findViewById(R.id.editTextdelpakek);
        editTextupdatepakid=(EditText) findViewById(R.id.editTextupdatepakid);
        editTextUpdateidek=(EditText) findViewById(R.id.editTextUpdateidek);
        editTextUpdateidtak=(EditText) findViewById(R.id.editTextUpdateidtak);
        editTextUpdateDate=(EditText) findViewById(R.id.editTextUpdateDate);
        editTextUpdatePrice=(EditText) findViewById(R.id.editTextUpdatePrice);


        editTextdelpakek.setSelectAllOnFocus(true);
        editTextupdatepakid.setSelectAllOnFocus(true);
        editTextUpdateidek.setSelectAllOnFocus(true);
        editTextUpdateidtak.setSelectAllOnFocus(true);
        editTextUpdateDate.setSelectAllOnFocus(true);
        editTextUpdatePrice.setSelectAllOnFocus(true);

        buttondelpakek=(Button) findViewById(R.id.buttondelpakek);
        buttondelpakek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    int id=Integer.parseInt(editTextdelpakek.getText().toString());
                    PinakasPakEkdr pinakaspakekdr=new PinakasPakEkdr();
                    pinakaspakekdr.setIdpaketouek(id);
                    int deleted = MainDrawerActivity.database.MyDao().deletePakEkdr(pinakaspakekdr);
                    Toast.makeText(UpdateDeletePakEk.this, "Ο πίνακας διαγράφτηκε.", Toast.LENGTH_LONG).show();
                    if(deleted==0)
                        throw new Exception();
                }catch (Exception e){
                    Toast.makeText(UpdateDeletePakEk.this, "Μη έγκυρο ID ", Toast.LENGTH_LONG).show();
                }

            }
        });


        buttonfindid=(Button) findViewById(R.id.buttonfindid);
        buttonfindid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextupdatepakid.getText()== null){
                    return;
                }try{
                    int id= Integer.parseInt(editTextupdatepakid.getText().toString());
                    List<PinakasPakEkdr> pinakaspakekdr= MainDrawerActivity.database.MyDao().getPinakasPakEkdr();
                    for(PinakasPakEkdr i: pinakaspakekdr){
                        if(i.getIdpaketouek()== id){
                            pinakasPakEkdr = i;
                            editTextUpdateidek.setText(String.valueOf(i.getIdekdr()));
                            editTextUpdateidtak.setText(String.valueOf(i.getIdtaksid()));
                            editTextUpdateDate.setText(i.getDate());
                            editTextUpdatePrice.setText(String.valueOf(i.getPrice()));

                            return;
                        }
                    }
                }catch (Exception e){
                    Toast.makeText(UpdateDeletePakEk.this, "Μη έγκυρο ID ", Toast.LENGTH_LONG).show();

                }
            }
        });

        buttonupdatepakek=(Button) findViewById(R.id.buttonupdatepakek);
        buttonupdatepakek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (pinakasPakEkdr == null)
                        return;
                    pinakasPakEkdr.setPrice(Integer.parseInt(editTextUpdatePrice.getText().toString()));
                    pinakasPakEkdr.setDate(editTextUpdateDate.getText().toString());
                    MainDrawerActivity.database.MyDao().updatePakEkdr(pinakasPakEkdr);
                    editTextUpdatePrice.setText("");
                    editTextUpdateDate.setText("");
                    editTextUpdateidek.setText("");
                    editTextUpdateidtak.setText("");
                    pinakasPakEkdr = null;
                    Toast.makeText(UpdateDeletePakEk.this, "Ο πίνακας ενημερώθηκε.", Toast.LENGTH_LONG).show();
                }catch(Exception e){
                    Toast.makeText(UpdateDeletePakEk.this, "Ο πίνακας δεν ενημερώθηκε.", Toast.LENGTH_LONG).show();
                }


            }
        });

    }
}