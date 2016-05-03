package mismascotas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.miscontactos.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private ArrayList<Mascotas> masco;
    private MascoAdaptador mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        //setSupportActionBar(myToolbar);

        getSupportActionBar().setIcon(R.drawable.huella);

        masco = new ArrayList<Mascotas>();

        masco.add(new Mascotas("Katy",0, R.drawable.ave));
        masco.add(new Mascotas("Carlius",0, R.drawable.caballo));
        masco.add(new Mascotas("KsKbel",0, R.drawable.culebra));
        masco.add(new Mascotas("Rufino",0, R.drawable.delfin));
        masco.add(new Mascotas("Simplin",0, R.drawable.elefante));
        masco.add(new Mascotas("Firulin",0, R.drawable.gato));
        masco.add(new Mascotas("Puka",0, R.drawable.leon));
        masco.add(new Mascotas("Lolita",0, R.drawable.perro2));
        masco.add(new Mascotas("Shakiro",0, R.drawable.pez));
        masco.add(new Mascotas("Queso",0, R.drawable.tigre));


        mAdapter = new MascoAdaptador(masco,this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setAdapter(mAdapter);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.estre:
                Intent intent = new Intent(MainActivity.this,Ultimas.class);
              //  intent.putExtra("mas",masco);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);

    }
}
