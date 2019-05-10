package com.example.ceplauncher.adapterss;


import com.example.ceplauncher.fragments.FragmentActividades;
import com.example.ceplauncher.fragments.FragmentEquipos;
import com.example.ceplauncher.fragments.FragmentInstalaciones;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class AdaptadorViewPagerItemsEntitat extends FragmentPagerAdapter {

    private int numeroTabs;

    public AdaptadorViewPagerItemsEntitat(FragmentManager fm, int numeroTabs) {
        super(fm);
        this.numeroTabs = numeroTabs;
    }

    //COMPARA LA POSICIÓN PARA CARGAR UN FRAGMENT EN ESPECIFICO
    @NonNull
    @Override
    public Fragment getItem(int position)
    {
        switch (position){
            case 0:
                return new FragmentInstalaciones();
            case 1:
                return new FragmentEquipos();
            case 2:
                return new FragmentActividades();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numeroTabs;
    }
}
