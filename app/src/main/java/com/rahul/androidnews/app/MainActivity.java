package com.rahul.androidnews.app;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.rahul.androidnews.app.fragment.SlidingFragment;
import com.rahul.androidnews.app.fragment.SlidingFragment2;
import com.rahul.androidnews.app.fragment.SlidingFragment3;
import com.rahul.androidnews.app.fragment.SlidingFragment4;
import com.rahul.androidnews.app.fragment.SlidingFragment5;
import com.rahul.androidnews.app.fragment.SlidingFragment6;
import com.rahul.androidnews.app.fragment.SlidingFragment7;
import com.rahul.androidnews.app.fragment.SlidingFragment8;
import com.rahul.androidnews.app.fragment.SlidingFragment9;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private  Toolbar toolbar;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar!=null) {
            setSupportActionBar(toolbar);
        }

       drawer = (DrawerLayout) findViewById(R.id.drawer_layout);



        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        Fragment home = new SlidingFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.container1, home)
                .commit();


    }




    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        toggle.onConfigurationChanged(newConfig);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        selectDrawerItem(item);
        return true;
    }

    public void selectDrawerItem(MenuItem menuItem) {


        Fragment fragment = null;
        Class fragmentClass = null;
        switch(menuItem.getItemId()) {
            case R.id.nav_home:
                fragmentClass = SlidingFragment.class;
                break;
            case R.id.nav_tamil:
                fragmentClass = SlidingFragment2.class;
                break;
            case R.id.nav_malayalam:
                fragmentClass = SlidingFragment3.class;
                break;
            case R.id.nav_hindi:
                fragmentClass = SlidingFragment4.class;
                break;
            case R.id.nav_telugu:
                fragmentClass = SlidingFragment5.class;
                break;
            case R.id.nav_kannada:
                fragmentClass = SlidingFragment6.class;
                break;
            case R.id.nav_bengali:
                fragmentClass = SlidingFragment7.class;
                break;
            case R.id.nav_gujarati:
                fragmentClass = SlidingFragment8.class;
                break;
            case R.id.nav_punjabi:
                fragmentClass = SlidingFragment9.class;
                break;
            default:
               break;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }


        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container1, fragment).commit();


        menuItem.setChecked(true);

        setTitle(menuItem.getTitle());

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

}
