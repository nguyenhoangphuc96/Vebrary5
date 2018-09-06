package com.lacviet.vebrary5.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lacviet.vebrary5.Detail.TabDescriptionFragment;
import com.lacviet.vebrary5.Detail.TabMarcFragment;

public class DetailPagerAdapter extends FragmentStatePagerAdapter {
    private Context context;

    public DetailPagerAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        this.context = context;
    }
    @Override
    public Fragment getItem(int position) {
        Fragment frag=null;
        switch (position){
            case 0:
                frag = new TabDescriptionFragment();
                break;
            case 1:
                frag = new TabMarcFragment();
                break;
            case 2:
                frag = new TabDescriptionFragment();
                break;
            case 3:
                frag = new TabDescriptionFragment();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 4;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "Mô tả";
                break;
            case 1:
                title = "Biểu ghi MARC";
                break;
            case 2:
                title = "Mô tả vật lý";
                break;
            case 3:
                title = "Kho lưu trữ";
                break;

        }
        return title;
    }


}