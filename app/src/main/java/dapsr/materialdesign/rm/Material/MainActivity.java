package dapsr.materialdesign.rm.Material;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;

import dapsr.materialdesign.rm.FragmentAndActivity.FloatingActivity;
import dapsr.materialdesign.rm.FragmentAndActivity.viewpager;
import dapsr.materialdesign.rm.R;


public class MainActivity extends ActionBarActivity {


    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

        if (savedInstanceState == null) {
            viewpager view = new viewpager();
            getSupportFragmentManager()

                    .beginTransaction().replace(R.id.frame_container, view)
                    .commit();

        }


        /*
        *
        * implementing floating action button
        *
        * */


        final FloatingActionButton first = (FloatingActionButton) findViewById(R.id.small1);
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this, FloatingActivity.class);
                startActivity(in);

                Toast.makeText(MainActivity.this, "first button", Toast.LENGTH_SHORT).show();

            }
        });

        final FloatingActionButton second = (FloatingActionButton) findViewById(R.id.small2);
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent ini = new Intent(MainActivity.this, FloatingActivity.class);
                startActivity(ini);
                Toast.makeText(MainActivity.this, "second button", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
