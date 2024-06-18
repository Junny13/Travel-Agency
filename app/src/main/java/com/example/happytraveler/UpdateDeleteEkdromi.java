package com.example.happytraveler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class UpdateDeleteEkdromi extends AppCompatActivity {
    EditText editTextDeleteIdek,editTextUpdateIdek,editTextUpdatePoli,editTextUpdateXwra,editTextUpdateDiarkeia,editTextEidosEk;
    Button buttondeleteek, buttonUpdateek, buttonifindipek;
    PinakasEkdr pinakasEkdr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete_ekdromi);

        getSupportActionBar().setTitle("Διαγραφή/Ενημέρωση Εκδρομής");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getFragmentManager().popBackStack();
        Intent intent = getIntent();

        editTextDeleteIdek=(EditText) findViewById(R.id.editTextDeleteIdek);
        editTextUpdateIdek=(EditText) findViewById(R.id.editTextUpdateIdek);
        editTextUpdatePoli=(EditText) findViewById(R.id.editTextUpdatePoli);
        editTextUpdateXwra=(EditText) findViewById(R.id.editTextUpdateXwra);
        editTextUpdateDiarkeia=(EditText) findViewById(R.id.editTextUpdateDiarkeia);
        editTextEidosEk=(EditText) findViewById(R.id.editTextEidosEk);


        editTextDeleteIdek.setSelectAllOnFocus(true);
        editTextUpdateIdek.setSelectAllOnFocus(true);
        editTextUpdatePoli.setSelectAllOnFocus(true);
        editTextUpdateXwra.setSelectAllOnFocus(true);
        editTextUpdateDiarkeia.setSelectAllOnFocus(true);
        editTextEidosEk.setSelectAllOnFocus(true);

        buttondeleteek=(Button) findViewById(R.id.buttondeleteek);
        buttondeleteek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    int id=Integer.parseInt(editTextDeleteIdek.getText().toString());
                    PinakasEkdr pinakasekdr=new PinakasEkdr();
                    pinakasekdr.setId(id);
                    int deleted = MainDrawerActivity.database.MyDao().deleteEkdr(pinakasekdr);
                    if(deleted==0)
                        throw new Exception();
                    Toast.makeText(UpdateDeleteEkdromi.this, "Ο πίνακας διαγράφτηκε.", Toast.LENGTH_LONG).show();

                }catch (Exception e){
                    Toast.makeText(UpdateDeleteEkdromi.this, "Μη έγκυρο ID ", Toast.LENGTH_LONG).show();
                }

            }
        });

        buttonifindipek=(Button) findViewById(R.id.buttonifindipek);
        buttonifindipek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextUpdateIdek.getText()== null){
                    return;
                }try{
                    int id= Integer.parseInt(editTextUpdateIdek.getText().toString());
                    List<PinakasEkdr> pinakasekdr= MainDrawerActivity.database.MyDao().getPinakasEkdr();
                    for(PinakasEkdr i: pinakasekdr){
                        if(i.getId()== id){
                            pinakasEkdr = i;
                            editTextUpdatePoli.setText(i.getPoli());
                            editTextUpdateXwra.setText(i.getXwra());
                            editTextUpdateDiarkeia.setText(String.valueOf(i.getDiarkeia()));
                            editTextEidosEk.setText(i.getEidos());
                            return;
                        }
                    }
                }catch (Exception e){
                    Toast.makeText(UpdateDeleteEkdromi.this, "Μη έγκυρο ID ", Toast.LENGTH_LONG).show();

                }
            }
        });

        buttonUpdateek=(Button) findViewById(R.id.buttonUpdateek);
        buttonUpdateek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (pinakasEkdr == null)
                        return;
                    pinakasEkdr.setPoli(editTextUpdatePoli.getText().toString());
                    pinakasEkdr.setXwra(editTextUpdateXwra.getText().toString());
                    pinakasEkdr.setDiarkeia(Integer.parseInt(editTextUpdateDiarkeia.getText().toString()));
                    pinakasEkdr.setEidos(editTextEidosEk.getText().toString());
                    MainDrawerActivity.database.MyDao().updateEkdr(pinakasEkdr);
                    editTextUpdatePoli.setText("");
                    editTextUpdateXwra.setText("");
                    editTextUpdateDiarkeia.setText("");
                    editTextEidosEk.setText("");
                    pinakasEkdr = null;
                    Toast.makeText(UpdateDeleteEkdromi.this, "Ο πίνακας ενημερώθηκε.", Toast.LENGTH_LONG).show();
                }catch(Exception e){
                        Toast.makeText(UpdateDeleteEkdromi.this, "Ο πίνακας δεν ενημερώθηκε.", Toast.LENGTH_LONG).show();
                }


            }
        });


    }
}