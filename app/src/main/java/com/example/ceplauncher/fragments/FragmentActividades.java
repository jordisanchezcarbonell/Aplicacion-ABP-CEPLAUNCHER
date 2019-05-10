package com.example.ceplauncher.fragments;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import com.example.ceplauncher.R;
import com.example.ceplauncher.adapterss.AdapterActividad;
import com.example.ceplauncher.utils.Manager;
import androidx.annotation.Nullable;
/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentActividades extends androidx.fragment.app.Fragment {
    public FragmentActividades() {
        // Required empty public constructor
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_actividades, container, false);
        GridView gridView = (GridView)getActivity().findViewById(R.id.GrdMenu);
        final AdapterActividad adapter = new AdapterActividad(getActivity(),Manager.getPlaces());
        gridView.setAdapter(adapter);
        // Inflate the layout for this fragment
        return vista;
    }
}