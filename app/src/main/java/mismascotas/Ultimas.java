package mismascotas;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.android.miscontactos.R;

import java.util.ArrayList;

import mismascotas.Adapter.MascoAdaptador;
import mismascotas.bd.BaseDatos;

public class Ultimas extends AppCompatActivity {

    RecyclerView recyclerView;
    private ArrayList<Mascotas> masco3 = new ArrayList<Mascotas>();
    private MascoAdaptador mAdapter;
    private Context context;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_recycler_view2);

       Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
      setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        BaseDatos db = new BaseDatos(getApplicationContext());
        masco3 = db.obtenerMascotas2();

        mAdapter = new MascoAdaptador(masco3,this);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setAdapter(mAdapter);
    }
}
