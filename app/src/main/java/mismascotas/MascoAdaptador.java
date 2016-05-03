package mismascotas;

/**
 * Created by JULIAN on 02/05/2016.
 */

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.miscontactos.R;

import java.util.ArrayList;


public class MascoAdaptador extends RecyclerView.Adapter<MascoAdaptador.MyViewHolder> {

    private ArrayList<Mascotas> masco;
    public static ArrayList<Mascotas> masco2 = new ArrayList<Mascotas>();
    Activity activity;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNombreCV, tvrate;
        private ImageButton btnLike;
        private ImageView imgFoto,imgHueso;
        private CardView cv;

        public MyViewHolder(View view) {
            super(view);
            cv = (CardView) view.findViewById(R.id.cv);
            imgFoto = (ImageView) view.findViewById(R.id.imgFoto);
            imgHueso = (ImageView) view.findViewById(R.id.imgHueso);
            tvNombreCV = (TextView) view.findViewById(R.id.tvNombreCV);
            tvrate = (TextView) view.findViewById(R.id.tvrate);
            btnLike = (ImageButton) view.findViewById(R.id.btnLike);
        }
    }


    public MascoAdaptador(ArrayList<Mascotas> masco, Activity activity)
    {
        this.masco = masco;
        this.activity= activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_masco, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final Mascotas con = masco.get(position);
        final int po = position;
        holder.imgFoto.setImageResource(con.getFoto());
        holder.tvNombreCV.setText(con.getNombre());
        holder.tvrate.setText(String.valueOf(con.getRate()));

        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i = con.getRate()+1;
                con.setRate(i);
                masco2.add(con);
                notifyItemChanged(po);
            }
        });
    }

    @Override
    public int getItemCount() {
        return masco.size();
    }
}

