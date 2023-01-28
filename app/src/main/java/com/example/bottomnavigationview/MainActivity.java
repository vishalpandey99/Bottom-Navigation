package com.example.bottomnavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
BottomNavigationView bnView;
FrameLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnView = findViewById(R.id.bnView);
        container = findViewById(R.id.container);

        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if (id==R.id.nav_home){

                    loadFrag(new HomeFragment(),0);
                }
                else if (id==R.id.nav_search){

                    loadFrag(new SearchFragment(),0);
                }
                else if (id==R.id.nav_setting){
                   loadFrag(new SettingFragment(),0);
                }
                else if (id==R.id.nav_contacts){
                    loadFrag(new ContactFragment(),0);
                }
                return true;
            }
        });

        bnView.setSelectedItemId(R.id.nav_search);
    }

    public void loadFrag(Fragment fragment, int flag){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (flag==0){
            ft.replace(R.id.container, fragment);
        }
        else if (flag==1){
            ft.add(R.id.nav_search,fragment);
        }
        ft.commit();
    }
}