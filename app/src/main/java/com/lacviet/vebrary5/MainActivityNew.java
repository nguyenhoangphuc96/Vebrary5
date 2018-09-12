package com.lacviet.vebrary5;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.lacviet.vebrary5.Adapter.MainscreenRecyclerViewAdapter;
import com.lacviet.vebrary5.Home.Fragment1;
import com.lacviet.vebrary5.Home.Fragment2;
import com.lacviet.vebrary5.Login.LoginActivity;
import com.lacviet.vebrary5.MenuNavigation.BookMenuFragment;
import com.lacviet.vebrary5.MenuNavigation.EbookMenuFragment;
import com.lacviet.vebrary5.MenuNavigation.IntroMenuFragment;
import com.lacviet.vebrary5.MenuNavigation.NewsMenuFragment;
import com.lacviet.vebrary5.MenuNavigation.SearchMenuFragment;
import com.lacviet.vebrary5.Model.MainScreenWithImageModel;

import java.util.ArrayList;

public class MainActivityNew extends AppCompatActivity implements View.OnClickListener {
    public static Toolbar toolbar;
    TextView tvTitleToolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ProgressBar pbMainScreen;
    Spinner spinnerSearch;
    //menu
    private int arrImageViewId[] = {R.id.imvHomeMenu, R.id.imvIntroMenu, R.id.imvNewsMenu, R.id.imvSearchMenu, R.id.imvEbookMenu, R.id.imvBookMenu, R.id.imvContactMenu, R.id.imvConfig, R.id.imvExitMenu};
    private ImageView arrImageView[] = new ImageView[arrImageViewId.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);
        addControl();
        actionBar();
        showFragment();
        dropDownSpinner();
        showIntroMenu();
    }
    private void showIntroMenu() {
        //show fragment
        IntroMenuFragment introMenuFragment = new IntroMenuFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.layout_show_menu, introMenuFragment, introMenuFragment.getTag())
                .commit();
        //set color
        setDefaultIconMenu();
        arrImageView[1].setImageDrawable(getResources().getDrawable(R.drawable.ic_intro_circle_yellow));
    }
    private void dropDownSpinner() {
        spinnerSearch = findViewById(R.id.spinnerSearch);

        String[] items = new String[]{"Tra cứu Opac", "Tra cứu nâng cao"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, items);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSearch.setAdapter(adapter);

        spinnerSearch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                if (parent.getChildAt(0) != null) {
                    ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                    ((TextView) parent.getChildAt(0)).setTextSize(13);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });
    }

    private void showFragment() {
        FragmentManager manager = getSupportFragmentManager();
        Fragment1 fragment1 = new Fragment1();
        manager.beginTransaction()
                .replace(R.id.layout1, fragment1, fragment1.getTag())
                .commit();
        Fragment2 fragment2 = new Fragment2();
        manager.beginTransaction()
                .replace(R.id.layout2, fragment2, fragment2.getTag())
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_search:
                //startOpacSearchActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.imvHomeMenu: {
                Intent intent = new Intent(MainActivityNew.this, MainActivityNew.class);
                startActivity(intent);

                break;
            }
            case R.id.imvIntroMenu: {
                //show fragment
                IntroMenuFragment introMenuFragment = new IntroMenuFragment();
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.layout_show_menu, introMenuFragment, introMenuFragment.getTag())
                        .commit();
                //set color
                setDefaultIconMenu();
                arrImageView[1].setImageDrawable(getResources().getDrawable(R.drawable.ic_intro_circle_yellow));
                break;
            }
            case R.id.imvNewsMenu: {
                //show fragment
                NewsMenuFragment newsMenuFragment = new NewsMenuFragment();
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.layout_show_menu, newsMenuFragment, newsMenuFragment.getTag())
                        .commit();
                //set color
                setDefaultIconMenu();
                arrImageView[2].setImageDrawable(getResources().getDrawable(R.drawable.ic_news_circle_yellow));
                break;
            }
            case R.id.imvSearchMenu: {
                //show fragment
                SearchMenuFragment searchMenuFragment = new SearchMenuFragment();
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.layout_show_menu, searchMenuFragment, searchMenuFragment.getTag())
                        .commit();
                //set color
                setDefaultIconMenu();
                arrImageView[3].setImageDrawable(getResources().getDrawable(R.drawable.ic_search_circle_yellow));
                break;
            }
            case R.id.imvEbookMenu: {
                //show fragment
                EbookMenuFragment ebookMenuFragment = new EbookMenuFragment();
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.layout_show_menu, ebookMenuFragment, ebookMenuFragment.getTag())
                        .commit();
                //set color
                setDefaultIconMenu();
                arrImageView[4].setImageDrawable(getResources().getDrawable(R.drawable.ic_ebook_circle_yellow));
                break;
            }
            case R.id.imvBookMenu: {
                //show fragment
                BookMenuFragment bookMenuFragment = new BookMenuFragment();
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.layout_show_menu, bookMenuFragment, bookMenuFragment.getTag())
                        .commit();
                //set color
                setDefaultIconMenu();
                arrImageView[5].setImageDrawable(getResources().getDrawable(R.drawable.ic_book_circle_yellow));
                break;
            }
            case R.id.imvContactMenu: {

                break;

            }
            case R.id.imvConfig: {
                startLogin();
                break;

            }
            case R.id.imvExitMenu: {
                onBackPressed();

                break;
            }
            default:
                break;
        }
    }

    private void startLogin() {
        Intent intent = new Intent(MainActivityNew.this, LoginActivity.class);
        startActivity(intent);
    }

    private void setDefaultIconMenu() {
        int index = 0;
        for (index = 0; index < arrImageView.length; index++) {
            switch (index) {
                case 0: {
                    break;
                }
                case 1: {
                    arrImageView[1].setImageDrawable(getResources().getDrawable(R.drawable.ic_intro_circle));
                }
                case 2: {
                    arrImageView[2].setImageDrawable(getResources().getDrawable(R.drawable.ic_new_circle));
                }
                case 3: {
                    arrImageView[3].setImageDrawable(getResources().getDrawable(R.drawable.ic_search_circle));
                }
                case 4: {
                    arrImageView[4].setImageDrawable(getResources().getDrawable(R.drawable.ic_ebook_circle));
                }
                case 5: {
                    arrImageView[5].setImageDrawable(getResources().getDrawable(R.drawable.ic_book_circle));
                }
                default:
                    break;
            }
        }
    }
    private void addControl() {
        toolbar = findViewById(R.id.toolbarMainscreen);
        navigationView = findViewById(R.id.ngvMainscreen);
        drawerLayout = findViewById(R.id.drawerLayout);
        tvTitleToolbar = findViewById(R.id.tvTitleToolbar);
        pbMainScreen = findViewById(R.id.pbMainScreen);
        spinnerSearch = findViewById(R.id.spinnerSearch);
        //Menu
        for (int index = 0; index < arrImageView.length; index++) {
            arrImageView[index] = findViewById(arrImageViewId[index]);
            arrImageView[index].setOnClickListener(this);
        }
    }

    private void actionBar() {
        setSupportActionBar(toolbar);
        tvTitleToolbar.setText(toolbar.getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Đồng ý thoát khỏi ứng dụng?");
        alertDialogBuilder
                .setMessage("Chọn có để thoát")
                .setCancelable(false)
                .setPositiveButton("Có",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                moveTaskToBack(true);
                                android.os.Process.killProcess(android.os.Process.myPid());
                                System.exit(1);
                            }
                        })

                .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    public void hideView(View view) {
        view.setVisibility(View.INVISIBLE);
    }

    public void showView(View view) {
        view.setVisibility(View.VISIBLE);
    }
}
