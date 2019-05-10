package com.example.ceplauncher.adapterss;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.ceplauncher.R;
import com.example.ceplauncher.activities.Actividades;
import java.util.ArrayList;
public class AdapterActividad extends ArrayAdapter {
    Context contextActual;
    ArrayList<Actividades> llistadeproductes;
    public AdapterActividad(Context context, ArrayList<Actividades> llistadeproductesaux) {
        super(context, R.layout.cardvieactividades, llistadeproductesaux);
        this.contextActual = context;
        this.llistadeproductes = llistadeproductesaux;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.cardvieactividades, null);
        ImageView imagen = item.findViewById(R.id.ImgMenuPlace);
        Actividades posExacta = llistadeproductes.get(position);
        imagen.setImageResource(posExacta.getImgaen());
        TextView text = item.findViewById(R.id.TxtMenuPlace);
        text.setText(posExacta.getNom());
        return item;
    }
}