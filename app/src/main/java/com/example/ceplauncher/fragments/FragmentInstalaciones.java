package com.example.ceplauncher.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ceplauncher.R;

import androidx.cardview.widget.CardView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentInstalaciones extends androidx.fragment.app.Fragment {

    CardView cardViewInstalaciones;

    public FragmentInstalaciones() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View root = inflater.inflate(R.layout.fragment_instalaciones, container, false);


        return root;
    }

}
