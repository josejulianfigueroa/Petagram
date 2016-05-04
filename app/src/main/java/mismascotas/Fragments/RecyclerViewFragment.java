package mismascotas.Fragments;


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

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment {

    RecyclerView recyclerView;
    private ArrayList<Mascotas> masco;
    private MascoAdaptador mAdapter;

       @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
           View v = inflater.inflate(R.layout.fragment_recycler_view,container,false);

           masco = new ArrayList<Mascotas>();

           masco.add(new Mascotas("Katy",4, R.drawable.ave));
           masco.add(new Mascotas("Carlius",1, R.drawable.caballo));
           masco.add(new Mascotas("KsKbel",2, R.drawable.culebra));
           masco.add(new Mascotas("Rufino",3, R.drawable.delfin));
           masco.add(new Mascotas("Simplin",4, R.drawable.elefante));
           masco.add(new Mascotas("Firulin",5, R.drawable.gato));
           masco.add(new Mascotas("Puka",1, R.drawable.leon));
           masco.add(new Mascotas("Lolita",8, R.drawable.perro2));
           masco.add(new Mascotas("Shakiro",1, R.drawable.pez));
           masco.add(new Mascotas("Queso",0, R.drawable.tigre));


           mAdapter = new MascoAdaptador(masco,getActivity());
           recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
           recyclerView.setHasFixedSize(true);

           RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());

           recyclerView.setLayoutManager(mLayoutManager);

           recyclerView.setAdapter(mAdapter);


           return v;

    }

}
