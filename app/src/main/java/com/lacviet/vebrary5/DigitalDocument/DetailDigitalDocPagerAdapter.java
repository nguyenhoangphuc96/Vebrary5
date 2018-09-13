package com.lacviet.vebrary5.DigitalDocument;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class DetailDigitalDocPagerAdapter extends FragmentStatePagerAdapter {
    private Context context;

    public DetailDigitalDocPagerAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        this.context = context;
    }
    @Override
    public Fragment getItem(int position) {
        Fragment frag=null;
        switch (position){
            case 0:
                frag = new TabDescriptionDigitalDocFragment();
                break;
            case 1:
                frag = new TabContentDigitalDocFragment();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 2;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "Mô tả";
                break;
            case 1:
                title = "Nội dung";
                break;
        }
        return title;
    }


}