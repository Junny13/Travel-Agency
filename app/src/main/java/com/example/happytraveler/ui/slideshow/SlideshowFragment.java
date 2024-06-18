package com.example.happytraveler.ui.slideshow;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.happytraveler.ButtonPressed;
import com.example.happytraveler.ButtonPressedEkdr;
import com.example.happytraveler.ButtonPressedPakEkdr;
import com.example.happytraveler.ButtonPressedPinakas;
import com.example.happytraveler.R;
import com.example.happytraveler.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {
    private FragmentSlideshowBinding binding;
    private Button button;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_slideshow, container, false);

        Button buttonekdr = view.findViewById(R.id.buttonEkdr);
        Button button = view.findViewById(R.id.buttonTaksid);
        Button buttonpak = view.findViewById(R.id.buttonPakEkdr);
        Button buttonpinakas = view.findViewById(R.id.buttonPinakasEkd);

        buttonpinakas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ButtonPressedPinakas.class);
                startActivity(intent);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Fragment ButtonPressed= new ButtonPressed();
//                FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.nav_slideshow1,new ButtonPressed());
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();

            Intent intent = new Intent(getActivity(), ButtonPressed.class);
                startActivity(intent);
            }
        });
        buttonpak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ButtonPressedPakEkdr.class);
                startActivity(intent);
            }
        });

            buttonekdr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), ButtonPressedEkdr.class);
                    startActivity(intent);
                }
            });

            return view;
        }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}