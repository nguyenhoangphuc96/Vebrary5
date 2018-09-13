package com.lacviet.vebrary5.DigitalDocument;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.lacviet.vebrary5.R;

public class DetailDigitalDocActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView tvTitleToolbar;
    private ViewPager pager;
    private TabLayout tabLayout;
    private TextView tvSee;
    //


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_digitaldocument);
        addControl();
        actionBar();
        showDataToView();
        addEvent();
    }

    private void addEvent() {
    }

    private void addControl() {
        toolbar = findViewById(R.id.toolbar);
        tvTitleToolbar = findViewById(R.id.tvTitleToolbar);
        pager = findViewById(R.id.container);
        tabLayout = findViewById(R.id.tabLayoutDetail);
        tvSee = findViewById(R.id.tvSee);
    }
    private void actionBar() {
        setSupportActionBar(toolbar);
        tvTitleToolbar.setText(toolbar.getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_back_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
    private void showDataToView() {
        // Set up the ViewPager with the sections adapter.
        FragmentManager manager = getSupportFragmentManager();
        DetailDigitalDocPagerAdapter adapter = new DetailDigitalDocPagerAdapter(manager,this);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setTabsFromPagerAdapter(adapter);
        pager.setOffscreenPageLimit(2);//no reload when change tab
    }
}