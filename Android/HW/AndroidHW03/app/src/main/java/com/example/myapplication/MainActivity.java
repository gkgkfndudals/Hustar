package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    ViewPager pager;
    FragmentManager fm;
    Fragment fragment1;
    Fragment fragment2;
    Fragment fragment3;

    NavigationView navigationView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
/////////////////////////////////////////////////////////////////////////////////
        fm = getSupportFragmentManager();

        pager = findViewById(R.id.pager);
        pager.setOffscreenPageLimit(3);

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());

        fragment1= new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

        adapter.addItem(fragment1);
        adapter.addItem(fragment2);
        adapter.addItem(fragment3);

        pager.setAdapter(adapter);


        BottomNavigationView bottomNavigationView =findViewById(R.id.bottm_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.tab1:
                        Toast.makeText(getApplicationContext(), "첫 번째 탭 선택", Toast.LENGTH_LONG).show();
                        pager.setCurrentItem(0);
                        break;
                    case R.id.tab2:
                        Toast.makeText(getApplicationContext(), "두 번째 탭 선택", Toast.LENGTH_LONG).show();
                        pager.setCurrentItem(1);
                        break;
                    case R.id.tab3:
                        Toast.makeText(getApplicationContext(), "세 번째 탭 선택", Toast.LENGTH_LONG).show();
                        pager.setCurrentItem(2);
                        break;


                }
                return true;
            }
        });

        ////////////////////////////////////////////////////////////////////////////
        navigationView= findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer_layout);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Toast.makeText(getApplicationContext(), "hi", Toast.LENGTH_LONG).show();
                switch(item.getItemId()){
                    case R.id.nav_menu1:
                        Toast.makeText(getApplicationContext(), "첫 번째 탭 선택", Toast.LENGTH_LONG).show();
                        pager.setCurrentItem(0);
                        break;
                    case R.id.nav_menu2:
                        Toast.makeText(getApplicationContext(), "두 번째 탭 선택", Toast.LENGTH_LONG).show();
                        pager.setCurrentItem(1);
                        break;
                    case R.id.nav_menu3:
                        Toast.makeText(getApplicationContext(), "세 번째 탭 선택", Toast.LENGTH_LONG).show();
                        pager.setCurrentItem(2);
                        break;
                }
                drawerLayout.closeDrawer(navigationView);
                return true;
            }
        });

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        //NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    class MyPagerAdapter extends FragmentStatePagerAdapter {
        ArrayList<Fragment> items = new ArrayList<Fragment>();

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addItem(Fragment item){
            items.add(item);
        }

        @Override
        public Fragment getItem(int position) {
            return items.get(position);
        }

        @Override
        public int getCount() {
            return items.size();
        }
    }
}