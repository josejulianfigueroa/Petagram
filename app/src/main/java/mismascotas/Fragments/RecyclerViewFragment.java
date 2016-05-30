package mismascotas.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.miscontactos.R;

import java.util.ArrayList;

import mismascotas.Adapter.MascoAdaptador;
import mismascotas.Mascotas;
import mismascotas.bd.BaseDatos;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment {

    RecyclerView recyclerView;
    private ArrayList<Mascotas> masco;
    private MascoAdaptador mAdapter;

    private Context context;
       @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
           View v = inflater.inflate(R.layout.fragment_recycler_view,container,false);

           BaseDatos db = new BaseDatos(getContext());
           db.insertarMasc();

           masco = db.obtenerMascotas();
           mAdapter = new MascoAdaptador(masco,getActivity());
           recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
           recyclerView.setHasFixedSize(true);

           RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());

           recyclerView.setLayoutManager(mLayoutManager);

           recyclerView.setAdapter(mAdapter);


           return v;

    }

}
