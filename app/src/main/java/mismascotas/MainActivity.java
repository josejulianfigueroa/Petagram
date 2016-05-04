package mismascotas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.miscontactos.R;

import java.util.ArrayList;

import mismascotas.Adapter.PageAdapter;
import mismascotas.Fragments.Perfil;
import mismascotas.Fragments.RecyclerViewFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tablayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tablayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        setUpViewPager();

        if (toolbar != null)
        {setSupportActionBar(toolbar);}
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new Perfil());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tablayout.setupWithViewPager(viewPager);

        tablayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tablayout.getTabAt(1).setIcon(R.drawable.ic_action_name);
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
                startActivity(intent);
                break;
            case R.id.action_contacto:
               Intent intent2 = new Intent(MainActivity.this,Contacto.class);
                startActivity(intent2);
                break;
            case R.id.action_acercade:
                Intent intent3 = new Intent(MainActivity.this,Bio.class);
                startActivity(intent3);
                break;
        }
        return super.onOptionsItemSelected(item);

    }
}
