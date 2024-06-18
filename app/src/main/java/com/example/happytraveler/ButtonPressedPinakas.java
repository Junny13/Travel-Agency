package com.example.happytraveler;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class ButtonPressedPinakas extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_pressed_pinakas);
        getSupportActionBar().setTitle("Εμφάνιση Πινάκων");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String[] queries = {"Όλοι οι πίνακες", "Πίνακας Ταξιδιωτικών Γραφείων ", "Πίνακας Εκδρομών", "Πίνακας Πακέτων Εκδρομών", "Πίνακας με κοινό ID"};
        Spinner spinner = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(this,androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,queries);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("POSITION " + position);
                System.out.println("ID " + id);
                TextView textView = ButtonPressedPinakas.this.findViewById(R.id.txtqueryresult);
                textView.setText(String.valueOf(position));
                if(position == 0) {
                    List<PinakasTaksid> pinakasTaksid = MainDrawerActivity.database.MyDao().getPinakasTaksid();
                    String result0 = "Πίνακας Ταξιδιωτικών Γραφείων\n\n";
                    for (PinakasTaksid i : pinakasTaksid) {
                        int code = i.getId();
                        String name = i.getName();
                        String address = i.getAddress();
                        result0 = result0 + "\n Id:" + code + "\n Name:" + name + "\n address:" + address + "\n\n\n";
                    }

                    List<PinakasEkdr> pinakasEkdr = MainDrawerActivity.database.MyDao().getPinakasEkdr();
                    result0 = result0 + "Πίνακας Εκδρομών\n\n";
                    for (PinakasEkdr i : pinakasEkdr) {
                        int code = i.getId();
                        String xwra = i.getXwra();
                        String poli = i.getPoli();
                        String eidos = i.getEidos();
                        int diarkeia = i.getDiarkeia();
                        result0 = result0 + "\n Id:" + code + "\n Xwra:" + xwra + "\n poli:" + poli + "\n eidos: " + eidos + "\n diarkeia:" + diarkeia +"\n\n\n";
                    }

                    List<PinakasPakEkdr> pinakasPakEkdr = MainDrawerActivity.database.MyDao().getPinakasPakEkdr();
                    result0 = result0 + "Πίνακας Πακέτων Εκρομών\n\n";
                    for (PinakasPakEkdr i: pinakasPakEkdr){
                        int code = i.getIdpaketouek();
                        int codeek = i.getIdekdr();
                        int  codetak = i.getIdtaksid();
                        String date = i.getDate();
                        int price = i.getPrice();
                        result0 = result0 + "\n ID paketou:" + code + "\n ID ekdromis:" + codeek + "\n ID taksidiotikou :" + codetak + "\n price: "  + price + "\n date:" + date + "\n\n\n";
                    }

                    textView.setText(result0);
                }
                else if(position == 1) {

                    List<PinakasTaksid> pinakasTaksid = MainDrawerActivity.database.MyDao().getPinakasTaksid();
                    String result0 = "Πίνακας Ταξιδιωτικών Γραφείων\n\n";
                    for (PinakasTaksid i : pinakasTaksid) {
                        int code = i.getId();
                        String name = i.getName();
                        String address = i.getAddress();
                        result0 = result0 + "\n Id:" + code + "\n Name:" + name + "\n address:" + address + "\n\n\n";
                    }
                    textView.setText(result0);
                }
               else if(position == 2) {
                    List<PinakasEkdr> pinakasEkdr = MainDrawerActivity.database.MyDao().getPinakasEkdr();
                    String result1 = "Πίνακας Εκδρομών\n\n";
                    for (PinakasEkdr i : pinakasEkdr) {
                        int code = i.getId();
                        String xwra = i.getXwra();
                        String poli = i.getPoli();
                        String eidos = i.getEidos();
                        int diarkeia = i.getDiarkeia();
                        result1 = result1 + "\n Id:" + code + "\n Xwra:" + xwra + "\n poli:" + poli + "\n eidos: " + eidos + "\n diarkeia:" + diarkeia+"\n\n\n";
                    }
                    textView.setText(result1);
                }
                else if(position == 3) {
                        List<PinakasPakEkdr> pinakasPakEkdr = MainDrawerActivity.database.MyDao().getPinakasPakEkdr();
                        String result2 = "Πίνακας Πακέτων Εκρομών\n\n";
                        for (PinakasPakEkdr i: pinakasPakEkdr){
                            int code = i.getIdpaketouek();
                            int codeek = i.getIdekdr();
                            int  codetak = i.getIdtaksid();
                            String date = i.getDate();
                            int price = i.getPrice();
                            result2 = result2 + "\n ID paketou:" + code + "\n ID ekdromis:" + codeek + "\n ID taksidiotikou :" + codetak + "\n price: "  + price + "\n date:" + date +"\n\n\n";
                        }
                        textView.setText(result2);
                }
                else if(position == 4) {
                    List<PinakasJoined> pinakasJoined = MainDrawerActivity.database.MyDao().getPinakes();
                    String result4 = "Ενωμένος Πίνακας\n\n";
                    for(PinakasJoined p : pinakasJoined) {
                        PinakasTaksid i = p.getTaksid();
                        int code = i.getId();
                        String name = i.getName();
                        String address = i.getAddress();
                        result4 = result4 + "\n Id:" + code + "\n Name:" + name + "\n address:" + address + "\n\n\n";

                        PinakasEkdr i2 = p.getEkdr();
                        int code2 = i2.getId();
                        String xwra = i2.getXwra();
                        String poli = i2.getPoli();
                        String eidos = i2.getEidos();
                        int diarkeia = i2.getDiarkeia();
                        result4 = result4 + "\n Id:" + code2 + "\n Xwra:" + xwra + "\n poli:" + poli + "\n eidos: " + eidos + "\n diarkeia:" + diarkeia+"\n\n\n";

                        PinakasPakEkdr i3 = p.getPakEkdr();
                        int code3 = i3.getIdpaketouek();
                        int codeek = i3.getIdekdr();
                        int  codetak = i3.getIdtaksid();
                        String date = i3.getDate();
                        int price = i3.getPrice();
                        result4 = result4 + "\n ID paketou:" + code3 + "\n ID ekdromis:" + codeek + "\n ID taksidiotikou :" + codetak + "\n price: "  + price + "\n date:" + date+"\n\n\n";

                    }
                    textView.setText(result4);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}