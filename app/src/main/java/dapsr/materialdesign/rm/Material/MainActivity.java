package dapsr.materialdesign.rm.Material;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import dapsr.materialdesign.rm.FragmentAndActivity.viewpager;
import dapsr.materialdesign.rm.R;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{


    private Toolbar toolbar;
    private static final String TAG_One = "Subbutton";
    private static final String TAG_two = "subbutton1";
    private static final String TAG_three = "subbutton3";
    private static final String TAG_Main = "MAIN";

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
        * Implementing Floating Action Button
        *
        * */

        ImageView floatbutton = new ImageView(this);
        floatbutton.setImageResource(R.drawable.floating);

        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
                .setContentView(floatbutton)
                .setBackgroundDrawable(R.drawable.selector_button_red)
                .build();

        ImageView subbutton1 = new ImageView(this);
        ImageView subbutton2 = new ImageView(this);
        ImageView subbutton3 = new ImageView(this);
        subbutton1.setImageResource(R.drawable.ic_action_articles);
        subbutton2.setImageResource(R.drawable.ic_action_home);
        subbutton3.setImageResource(R.drawable.ic_action_personal);


        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);
        itemBuilder.setBackgroundDrawable(getResources().getDrawable(R.drawable.selector_sub_button_gray));
        SubActionButton button1 = itemBuilder.setContentView(subbutton1).build();
        SubActionButton button2 = itemBuilder.setContentView(subbutton2).build();
        SubActionButton button3 = itemBuilder.setContentView(subbutton3).build();

        button1.setTag(TAG_One);
        button2.setTag(TAG_two);
        button3.setTag(TAG_three);



        /*
        *
        * onclick subbuttons
        *
        * */

         button1.setOnClickListener(this);
         button2.setOnClickListener(this);
         button3.setOnClickListener(this);


        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(button1)
                .addSubActionView(button2)
                .addSubActionView(button3)
                .attachTo(actionButton)
                .build();

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

    @Override
    public void onClick(View v) {

        if(v.getTag().equals(TAG_One)){

            Toast.makeText(this,"One",Toast.LENGTH_SHORT).show();
        }
        if(v.getTag().equals(TAG_two)){

            Toast.makeText(this,"two",Toast.LENGTH_SHORT).show();

        }
        if(v.getTag().equals(TAG_three)){

            Toast.makeText(this,"three",Toast.LENGTH_SHORT).show();



        }


    }
}
