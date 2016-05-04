package mismascotas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.android.miscontactos.R;

import java.util.ArrayList;

import mismascotas.Adapter.MascoAdaptador;

public class Ultimas extends AppCompatActivity {

    RecyclerView recyclerView;
    private ArrayList<Mascotas> masco3 = new ArrayList<Mascotas>();
    private MascoAdaptador mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_recycler_view2);

       Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
      setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        masco3.add(new Mascotas("Katy",4, R.drawable.ave));
        masco3.add(new Mascotas("Carlius",1, R.drawable.caballo));
        masco3.add(new Mascotas("KsKbel",2, R.drawable.culebra));
        masco3.add(new Mascotas("Rufino",3, R.drawable.delfin));
        masco3.add(new Mascotas("Simplin",4, R.drawable.elefante));

        mAdapter = new MascoAdaptador(masco3,this);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setAdapter(mAdapter);
    }
}
