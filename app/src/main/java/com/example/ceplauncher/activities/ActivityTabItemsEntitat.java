package com.example.ceplauncher.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ceplauncher.R;
import com.example.ceplauncher.adapterss.AdaptadorViewPagerItemsEntitat;
import com.example.ceplauncher.utils.LoginManager;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

public class ActivityTabItemsEntitat extends BaseActivity {

    Toolbar toolbarPersonalizada;
    TabLayout tabLayoutItemsEntitat;
    ViewPager viewPagerTabItemsEntitat;
    AdaptadorViewPagerItemsEntitat adaptadorVP;
    TabItem tabItemEntitatInstalaciones, tabItemEntitatEquipos, tabItemEntitatActividades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_items_entitat);

        toolbarPersonalizada = (Toolbar) findViewById(R.id.toolbarPersonalizada);
        setSupportActionBar(toolbarPersonalizada);

        String emailUserGuardado = LoginManager.getEmail(getApplicationContext());
        setTitle(emailUserGuardado);

        //DECLARACION VARIABLES
        tabLayoutItemsEntitat = (TabLayout) findViewById(R.id.tabLayoutItemsEntitat);
        tabItemEntitatInstalaciones = (TabItem) findViewById(R.id.tabItemEntitatInstalaciones);
        tabItemEntitatEquipos = (TabItem) findViewById(R.id.tabItemEntitatEquipos);
        tabItemEntitatActividades = (TabItem) findViewById(R.id.tabItemEntitatActividades);
        viewPagerTabItemsEntitat = (ViewPager) findViewById(R.id.viewPagerTabItemsEntitat);

        adaptadorVP = new AdaptadorViewPagerItemsEntitat(getSupportFragmentManager(), tabLayoutItemsEntitat.getTabCount());
        viewPagerTabItemsEntitat.setAdapter(adaptadorVP);

        tabLayoutItemsEntitat.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPagerTabItemsEntitat.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPagerTabItemsEntitat.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayoutItemsEntitat));

    }

    //INFLA LA TOOLBAR CON LOS ICONOS
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.iconos_toolbar_items_entitat, menu);
        return true;
    }

    //METODO PARA ESCRIBIR QUE SE HARÁ EN CADA EVENTO CLIC DEL ICONO
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId())
        {
            case R.id.itemIconoUser:
                startActivity(new Intent(getApplicationContext(), ActivityMainUser.class));
                break;

            case R.id.itemOptions:
                startActivity(new Intent(getApplicationContext(), ActivityConfiguracion.class));
                break;

            default:
                return super.onOptionsItemSelected(item);

        }
        return true;
    }
}
