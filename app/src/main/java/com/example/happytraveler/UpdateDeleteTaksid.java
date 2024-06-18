package com.example.happytraveler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class UpdateDeleteTaksid extends AppCompatActivity {
    EditText editTextdeleteid,editTextUdateId,editTextUpdateName,UpdateAddress;
    Button buttondeletetaks, buttonUpdateTaks, buttonfindidtak;
    PinakasTaksid pinakasTaksid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete_taksid);

        getSupportActionBar().setTitle("Διαγραφή/Ενημέρωση Ταξιδιωτικού");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getFragmentManager().popBackStack();
        Intent intent = getIntent();

        editTextdeleteid=(EditText) findViewById(R.id.editTextdeleteid);
        editTextUdateId=(EditText) findViewById(R.id.editTextUdateId);
        editTextUpdateName=(EditText) findViewById(R.id.editTextUpdateName);
        UpdateAddress=(EditText) findViewById(R.id.UpdateAddress);


        editTextdeleteid.setSelectAllOnFocus(true);
        editTextUdateId.setSelectAllOnFocus(true);
        editTextUpdateName.setSelectAllOnFocus(true);
        UpdateAddress.setSelectAllOnFocus(true);

        buttondeletetaks=(Button) findViewById(R.id.buttondeletetaks);
        buttondeletetaks.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try{
                int id=Integer.parseInt(editTextdeleteid.getText().toString());
                PinakasTaksid pinakastaksid=new PinakasTaksid();
                pinakastaksid.setId(id);
                int deleted= MainDrawerActivity.database.MyDao().deleteTaksid(pinakastaksid);
                Toast.makeText(UpdateDeleteTaksid.this, "Ο πίνακας διαγράφτηκε.", Toast.LENGTH_LONG).show();
                if(deleted==0)
                    throw new Exception();

            }catch (Exception e){
                Toast.makeText(UpdateDeleteTaksid.this, "Μη έγκυρο ID ", Toast.LENGTH_LONG).show();
            }

        }
    });
        buttonfindidtak=(Button) findViewById(R.id.buttonfindidtak);
        buttonfindidtak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextUdateId.getText()== null){
                    return;
                }try{
                    int id= Integer.parseInt(editTextUdateId.getText().toString());
                    List<PinakasTaksid> pinakasTaksids= MainDrawerActivity.database.MyDao().getPinakasTaksid();
                    for(PinakasTaksid i: pinakasTaksids){
                        if(i.getId()== id){
                            pinakasTaksid = i;
                            editTextUpdateName.setText(i.getName());
                            UpdateAddress.setText(i.getAddress());
                            return;
                        }
                    }
                }catch (Exception e){
                    Toast.makeText(UpdateDeleteTaksid.this, "Μη έγκυρο ID ", Toast.LENGTH_LONG).show();

                }
            }
        });

        buttonUpdateTaks=(Button) findViewById(R.id.buttonUpdateTaks);
        buttonUpdateTaks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (pinakasTaksid == null)
                        return;
                    pinakasTaksid.setName(editTextUpdateName.getText().toString());
                    pinakasTaksid.setAddress(UpdateAddress.getText().toString());
                    MainDrawerActivity.database.MyDao().updateTaksid(pinakasTaksid);
                    editTextUpdateName.setText("");
                    UpdateAddress.setText("");
                    pinakasTaksid = null;
                    Toast.makeText(UpdateDeleteTaksid.this, "Ο πίνακας ενημερώθηκε.", Toast.LENGTH_LONG).show();
                }catch(Exception e){
                    Toast.makeText(UpdateDeleteTaksid.this, "Ο πίνακας δεν ενημερώθηκε.", Toast.LENGTH_LONG).show();
                }


            }
        });



}
}