package com.example.ceplauncher.adapterss;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.ceplauncher.activities.Actividades;
import com.example.ceplauncher.activities.Equipo;
import com.example.ceplauncher.R;
import java.util.ArrayList;
import androidx.recyclerview.widget.RecyclerView;
/*CLASE PARA RECYCLERVIEW*/
public class EquiposHolder  extends RecyclerView.Adapter<EquiposHolder.EquiposViewHolder>  implements View.OnClickListener {
    private View.OnClickListener listener;
    private ArrayList<Equipo> datos;
    Context contextActual;
    public static class EquiposViewHolder
            extends RecyclerView.ViewHolder {
        private TextView txtTitulo;
        private ImageView IMGN;
        public EquiposViewHolder(View itemView) {
            super(itemView);
            txtTitulo = (TextView) itemView.findViewById(R.id.txtName);
            //txtSubtitulo = (TextView)itemView.findViewById(R.id.TxtMenuPlace);
            IMGN = (ImageView) itemView.findViewById(R.id.IMG1);
            //itemView.setOnClickListener((View.OnClickListener) this);
        }
        public void bindTitular(Equipo t) {
            txtTitulo.setText(t.getNom());
            IMGN.setImageResource(t.getImgaen());
        }
    }
    public EquiposHolder(ArrayList<Equipo> datos) {
        this.datos = datos;
    }
    @Override
    public EquiposViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview_equipos, viewGroup, false);
        itemView.setOnClickListener(this);
        EquiposViewHolder tvh = new EquiposViewHolder(itemView);
        return tvh;
    }
    @Override
    public void onBindViewHolder(EquiposViewHolder viewHolder, int pos) {
        Equipo item = datos.get(pos);
        viewHolder.bindTitular(item);
    }
    @Override
    public int getItemCount() {
        return datos.size();
    }
    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }
    @Override
    public void onClick(View view) {
        if (listener != null)
            listener.onClick(view);
    }
}