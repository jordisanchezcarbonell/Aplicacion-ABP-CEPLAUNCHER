package com.example.ceplauncher.fragments;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.ceplauncher.activities.Equipo;
import com.example.ceplauncher.R;
import com.example.ceplauncher.adapterss.EquiposHolder;
import com.example.ceplauncher.utils.Manager;
import java.util.ArrayList;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentEquipos extends androidx.fragment.app.Fragment {
    private RecyclerView mRecyclerView;
    private ArrayList<Equipo> carModels;
    public FragmentEquipos() {
        // Required empty public constructor
    }
    private void llenar(){
        carModels.add(new Equipo("Mi Band 2 Strap Black", R.drawable.actividades));
        carModels.add(new Equipo("Mi Band 2 Strap Black", R.drawable.actividades));
        carModels.add(new Equipo("Mi Band 2 Strap Black", R.drawable.actividades));
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment recyclerView
        RecyclerView rv = new RecyclerView(getContext());
        View vista = inflater.inflate(R.layout.fragment_equipos, container, false);
        carModels=Manager.getEquipo();
        mRecyclerView = (RecyclerView) vista.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        EquiposHolder adapter = new EquiposHolder(carModels);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //  mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        // mRecyclerView.addItemDecoration(new LineDividerItemDecoration(getContext(), R.drawable.line_divider));
        mRecyclerView.setAdapter(adapter);
        return vista;
    }
}