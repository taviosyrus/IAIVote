package com.example.tavio_syrus_gblokpo.iai_vote;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.example.tavio_syrus_gblokpo.iai_vote.slidingTab.SlidingTabLayout;
import com.example.tavio_syrus_gblokpo.iai_vote.slidingTab.ViewPagerAdapter;


public class Menu extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {
    ViewPagerAdapter adapter;
    private int nombreTable = 3;
    private CharSequence Title[] = {"Vote", "List.Prof", "List.Etud"};
    private ViewPager pager;
    private SlidingTabLayout tabLayout;
    private Context context;
    private android.view.Menu menu;


    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        context = this;
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), Title, nombreTable);
        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        pager = findViewById(R.id.vP);
        pager.setAdapter(adapter);
        tabLayout = findViewById(R.id.slid);
        tabLayout.setDistributeEvenly(true);
        tabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.colorPrimaryDark);
            }
        });
        if (pager != null) {
            tabLayout.setViewPager(pager);
        } else {
            pager = findViewById(R.id.vP);
            tabLayout.setViewPager(pager);
        }
        tabLayout.setOnPageChangeListener(this);
    }

    public void voter(View view) {
        Intent intent = new Intent(getApplicationContext(), VoteGri.class);
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                pager.setCurrentItem(0, true);
                return true;
            case R.id.navigation_dashboard:
                pager.setCurrentItem(1, true);
                return true;
            case R.id.navigation_notifications:
                pager.setCurrentItem(2, true);
                return true;
        }
        return false;
    }

    private void scrollChanged(int position) {
        int[] itemId = {R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications};
        bottomNavigationView.setSelectedItemId(itemId[position]);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        //Log.d("DEBUG"," "+position);
        //scrollChanged(position);
    }



    @Override
    public void onPageSelected(int position) {

        switch (position){
            case 0:


                break;

            case 1:

                break;
            case 3:

                break;
        }
        scrollChanged(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.profil47:
                Intent intent = new Intent(getApplicationContext(), Profil.class);

          //  case R.id.deconnection:
            //    Intent intent1 = new Intent(getApplicationContext(), Login.class);
              //  startActivity(intent1);
            case R.id.action_settings:
                Intent intent1 = new Intent(getApplicationContext(), Parametre.class);
                startActivity(intent1);
            case R.id.deconnection:
                Intent intent2 = new Intent(getApplicationContext(), Login.class);
                startActivity(intent2);
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
