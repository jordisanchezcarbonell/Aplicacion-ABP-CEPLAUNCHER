package com.example.ceplauncher.utils;


import com.example.ceplauncher.activities.Actividades;
import com.example.ceplauncher.activities.Equipo;
import com.example.ceplauncher.R;
import java.util.ArrayList;
public class Manager {
    public static ArrayList<Actividades> getPlaces()
    {
        ArrayList<Actividades> places = new ArrayList<>();
        places.add(new Actividades("Mi Band 2 Strap Black", R.drawable.actividades));
        places.add(new Actividades("Mi Wireless Mouse", R.drawable.actividades));
        places.add(new Actividades("Rollerball Pen Silver", R.drawable.actividades));
        places.add(new Actividades("Mi Band 2 Strap Blue", R.drawable.actividades));
        return places;
    }
    public static ArrayList<Equipo> getEquipo()
    {
        ArrayList<Equipo> places = new ArrayList<>();
        places.add(new Equipo("Mi Band 2 Strap Black", R.drawable.barcelona));
        places.add(new Equipo("Mi Band 2 Strap Black", R.drawable.barcelona));
        places.add(new Equipo("Mi Band 2 Strap Black", R.drawable.barcelona));
        return places;
    }
}