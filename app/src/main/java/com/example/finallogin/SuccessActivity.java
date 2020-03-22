package com.example.finallogin;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class SuccessActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private int id;
    private View v;
    private GoogleApiClient mGoogleApiClient;
    private FirebaseAuth mAuth;
    private static final int RC_SIGN_IN = 9001;
    public static String usetidtestt;

    private ListView postlistView;
    private PostListadapter adapter;
    private List<receivepost> postlist;
    private ImageView bigdata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);


        final Intent intent = getIntent();
        usetidtestt = intent.getStringExtra("userid");


        //게시판 글작성 번호
        final FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent ifab = new Intent(SuccessActivity.this, PostCategory.class);
                ifab.putExtra("id", usetidtestt);
                startActivity(ifab);
            }
        });


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setItemIconTintList(null);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        final Button Button1 = (Button) findViewById(R.id.button1);
        final Button Button2 = (Button) findViewById(R.id.button2);
        final Button Button3 = (Button) findViewById(R.id.button3);


        final LinearLayout main = (LinearLayout) findViewById(R.id.main);
        final RelativeLayout fragment=(RelativeLayout)findViewById(R.id.fragment);

        main.setVisibility(View.GONE);
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment,new Fragment1());
        fragmentTransaction.commit();



        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.setVisibility(View.GONE);
                Button1.setBackgroundResource(R.color.colorAccent);
                Button2.setBackgroundResource(R.color.colorPrimaryDark);
                Button3.setBackgroundResource(R.color.colorPrimaryDark);
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment,new Fragment1());
                fragmentTransaction.commit();

            }
        });
        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.setVisibility(View.GONE);
                Button2.setBackgroundResource(R.color.colorAccent);
                Button1.setBackgroundResource(R.color.colorPrimaryDark);
                Button3.setBackgroundResource(R.color.colorPrimaryDark);

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment Fragment2 = new Fragment2();
                Bundle bundle = new Bundle();
                bundle.putString("user", usetidtestt);
                Fragment2.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment, Fragment2);
                fragmentTransaction.commit();


            }
        });
        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.setVisibility(View.GONE);
                Button3.setBackgroundResource(R.color.colorAccent);
                Button2.setBackgroundResource(R.color.colorPrimaryDark);
                Button1.setBackgroundResource(R.color.colorPrimaryDark);

                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment,new Fragment3());
                fragmentTransaction.commit();


            }
        });
    }

    public void headClick(View v){
        Intent cloud = new Intent(SuccessActivity.this, bigdata.class);
        startActivity(cloud);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.asia_icon) {
            Intent asia = new Intent(SuccessActivity.this, Itemasia.class);
            startActivity(asia);
        } else if (id == R.id.europe_icon) {
            Intent europe = new Intent(SuccessActivity.this, Itemeurope.class);
            startActivity(europe);
        } else if (id == R.id.afreeca_icon) {
            Intent afreeca = new Intent(SuccessActivity.this, Itemafreeca.class);
            startActivity(afreeca);
        } else if (id == R.id.southamerica_icon) {
            Intent south = new Intent(SuccessActivity.this, Itemsouthamerica.class);
            startActivity(south);
        } else if (id == R.id.northamerica_icon) {
            Intent north = new Intent(SuccessActivity.this, Itemnorthamerica.class);
            startActivity(north);
        } else if (id == R.id.oceania_icon) {
            Intent oceeania = new Intent(SuccessActivity.this, Itemoceania.class);
            startActivity(oceeania);
        } else if (id == R.id.setting) {
        } else if (id == R.id.logout) {
            new AlertDialog.Builder(this, R.style.MyAlertDialogStyle)
                    .setTitle("로그아웃").setMessage("로그아웃 하시겠습니까?")
                    .setPositiveButton("로그아웃", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent out = new Intent(SuccessActivity.this, MainActivity.class);
                            out.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            startActivity(out);
                            finish();
                        }
                    })
                    .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    })
                    .show();
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.actionfillter:
                Toast.makeText(this, "카테고리", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(SuccessActivity.this, Category.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
