package mismascotas.Adapter;

/**
 * Created by JULIAN on 02/05/2016.
 */

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.miscontactos.R;

import java.util.ArrayList;

import mismascotas.Mascotas;


public class MascoAdaptador2 extends RecyclerView.Adapter<MascoAdaptador2.MyViewHolder> {

    private ArrayList<Mascotas> masco;
    public static ArrayList<Mascotas> masco2 = new ArrayList<Mascotas>();
    Activity activity;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvrate;

        private ImageView imgFoto,imgHueso;
        private CardView cv;

        public MyViewHolder(View view) {
            super(view);
            cv = (CardView) view.findViewById(R.id.cv);
            imgFoto = (ImageView) view.findViewById(R.id.imgFoto3);
            imgHueso = (ImageView) view.findViewById(R.id.imgHueso3);

            tvrate = (TextView) view.findViewById(R.id.tvrate3);

        }
    }


    public MascoAdaptador2(ArrayList<Mascotas> masco, Activity activity)
    {
        this.masco = masco;
        this.activity= activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardgrid, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final Mascotas con = masco.get(position);
        final int po = position;
        holder.imgFoto.setImageResource(con.getFoto());
        holder.tvrate.setText(String.valueOf(con.getRate()));

           }

    @Override
    public int getItemCount() {
        return masco.size();
    }
}

