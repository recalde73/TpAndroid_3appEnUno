package com.example.myapplication;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean viewIsAtEjercicio1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_ejercicio1);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.nav_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                Fragment SelectFragment = null;
                switch (itemId){
                    case R.id.nav_ejercicio1:
                        SelectFragment = new Ejercicio1();
                        break;
                    case R.id.nav_ejercicio2:
                        SelectFragment = new Ejercicio2();
                        break;
                    case R.id.nav_ejercicio3:
                        SelectFragment = new Ejercicio3();
                        break;
                }
                return true;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.nav_ejercicio1);
    }

    @Override
    public void onBackPressed() {
        if (!viewIsAtEjercicio1) { //Si la vista actual no es el fragment Home
            BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.nav_view);
            bottomNavigationView.setSelectedItemId(R.id.nav_ejercicio1); //Selecciona el fragment Home
        } else {
            moveTaskToBack(true);  //Si presionas Back cuando ya muestras el fragment Home, sale de la app
        }
    }

}
