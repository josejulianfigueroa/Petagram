package mismascotas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.miscontactos.R;

import java.util.ArrayList;

public class Ultimas extends AppCompatActivity {

    RecyclerView recyclerView;
    private ArrayList<Mascotas> masco3 = new ArrayList<Mascotas>();
    private MascoAdaptador mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      // Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        //setSupportActionBar(myToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        masco3.add(MascoAdaptador.masco2.get(MascoAdaptador.masco2.size()-1));
        masco3.add(MascoAdaptador.masco2.get(MascoAdaptador.masco2.size()-2));
        masco3.add(MascoAdaptador.masco2.get(MascoAdaptador.masco2.size()-3));
        masco3.add(MascoAdaptador.masco2.get(MascoAdaptador.masco2.size()-4));
        masco3.add(MascoAdaptador.masco2.get(MascoAdaptador.masco2.size()-5));

        mAdapter = new MascoAdaptador(masco3,this);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setAdapter(mAdapter);
    }
}
