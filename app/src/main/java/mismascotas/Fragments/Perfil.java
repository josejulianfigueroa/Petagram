package mismascotas.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.miscontactos.R;

import java.util.ArrayList;

import mismascotas.Adapter.MascoAdaptador2;
import mismascotas.Mascotas;

/**
 * A simple {@link Fragment} subclass.
 */
public class Perfil extends Fragment {

    RecyclerView recyclerView2;
    private ArrayList<Mascotas> masco2;
    private MascoAdaptador2 mAdapter2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil,container,false);

        masco2 = new ArrayList<Mascotas>();


        masco2.add(new Mascotas("Rufino",3, R.drawable.delfin));
        masco2.add(new Mascotas("Rufino",1, R.drawable.delfin));
        masco2.add(new Mascotas("Rufino",3, R.drawable.delfin));
        masco2.add(new Mascotas("Rufino",3, R.drawable.delfin));
        masco2.add(new Mascotas("Rufino",8, R.drawable.delfin));
        masco2.add(new Mascotas("Rufino",5, R.drawable.delfin));
        masco2.add(new Mascotas("Rufino",11, R.drawable.delfin));



        mAdapter2 = new MascoAdaptador2(masco2,getActivity());
        recyclerView2 = (RecyclerView) v.findViewById(R.id.recycler_view2);
        recyclerView2.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(),3);

        recyclerView2.setLayoutManager(mLayoutManager);

        recyclerView2.setAdapter(mAdapter2);


        return v;
    }

}
