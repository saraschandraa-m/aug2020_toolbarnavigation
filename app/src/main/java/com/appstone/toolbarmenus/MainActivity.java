package com.appstone.toolbarmenus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mToolbar = findViewById(R.id.tl_main);
        setSupportActionBar(mToolbar);

        DrawerLayout mDrawer = findViewById(R.id.drawer_layout);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setTitle("MyApp");
        }



        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(MainActivity.this, mDrawer, mToolbar, R.string.open, R.string.close);

        drawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
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



}