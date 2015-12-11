package com.consorciohbo.app.msdvip.UI.ControlsViews;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.consorciohbo.app.msdvip.R;
import com.consorciohbo.app.msdvip.UI.ControlsFragment.ContentFragment;
import com.consorciohbo.app.msdvip.UI.RecycleViewControllers.TravelListAdapter;

public class MainActivity extends AppCompatActivity {

    //Defining Variables
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private RecyclerView mRecyclerView;
    private TravelListAdapter mAdapter;

    private StaggeredGridLayoutManager mStaggeredLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //---------------------------------------------------------------
        //Codigo del toolbar
        //inicializamos el toolbar y ajustes en el action bar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Inicializamos el NavigationView
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {


                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                //Closing drawer on item click
                drawerLayout.closeDrawers();

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {


                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.comunicacion:
                        Toast.makeText(getApplicationContext(), "Comunicacion", Toast.LENGTH_SHORT).show();
                        ContentFragment fragment = new ContentFragment();

                        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame, fragment);

                        fragmentTransaction.commit();
                        return true;


                    // For rest of the options we just show a toast on click

                    case R.id.servicios:
                        Toast.makeText(getApplicationContext(), "Servicios", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.NuevaAfiliacion:
                        Toast.makeText(getApplicationContext(), "Nueva Afiliación", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.perfil:
                        Toast.makeText(getApplicationContext(), "Perfil", Toast.LENGTH_SHORT).show();
                        return true;

                }
                return false;
            }
        });

        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();


    //---------------------------------------------------------------------------------------------------------------
        //Codigo del listview
        mRecyclerView = (RecyclerView) findViewById(R.id.listComunicacion);
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredLayoutManager);
        mAdapter = new TravelListAdapter(this);
        mRecyclerView.setAdapter(mAdapter);

    }
    //---------------

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
        // if (id == R.id.action_settings) {
        //     return true;
        // }

        return super.onOptionsItemSelected(item);
    }

}

