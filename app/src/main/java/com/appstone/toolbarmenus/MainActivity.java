package com.appstone.toolbarmenus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mToolbar = findViewById(R.id.tl_main);
        setSupportActionBar(mToolbar);

        mDrawer = findViewById(R.id.drawer_layout);

        NavigationView navView = findViewById(R.id.sliding_navigation);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setTitle("MyApp");
        }


        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(MainActivity.this, mDrawer, mToolbar, R.string.open, R.string.close);

        drawerToggle.syncState();

//        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                switch (item.getItemId()) {
//
//                    case R.id.action_edit:
//
//                        break;
//                }
//                return true;
//            }
//        });
        navView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;

            case R.id.action_edit:
                Toast.makeText(MainActivity.this, "Edit is clicked", Toast.LENGTH_LONG).show();
                break;

            case R.id.action_delete:
                break;
        }

        return true;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        mDrawer.closeDrawer(GravityCompat.START);

        switch (item.getItemId()) {
            case R.id.action_move:
                startActivity(new Intent(MainActivity.this, BottomNavActivity.class));
                break;

            case R.id.action_delete:
                startActivity(new Intent(MainActivity.this, TabActivity.class));
                break;

            case R.id.action_edit:

                EditFragment editFragment = new EditFragment();

                FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_container, editFragment);
                fm.commit();

//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new EditFragment()).commit();

                break;
        }
        return true;
    }
}