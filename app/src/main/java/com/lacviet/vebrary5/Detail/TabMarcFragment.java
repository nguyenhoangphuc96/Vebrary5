package com.lacviet.vebrary5.Detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.lacviet.vebrary5.R;
import com.squareup.picasso.Picasso;

import static com.lacviet.vebrary5.MainActivity.toolbar;

public class TabMarcFragment extends Fragment {
    TextView tvMarc;

    public TabMarcFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_marc,container,false);
        addControl(view);
        tempData();
        return view;
    }



    private void tempData() {
       tvMarc.setText("LDR\t00777cam a2200241 a 4500\n" +
               "001 \t68518\n" +
               "005 \t20180207104519.0\n" +
               "008 \t180207b        |||||||| ||||||||||||||  \n" +
               "041 \t0# |aeng \n" +
               "082 \t0# |a973 |214 ed \n" +
               "084 \t## |aP3(7M5)0 |bG539 |2BBK \n" +
               "100 \t0# |aFoner, Eric \n" +
               "245 \t00 |aGive me liberty! : |ban American history / |cEric Foner \n" +
               "260 \t## |aNew York : |bW.W. Norton , |c2005 \n" +
               "300 \t## |aA-107, 1131 p. : |bill. (some col.), col. maps ; |c27 cm \n" +
               "500 \t## |aIncludes index \n" +
               "541 \t## |aTặng \n" +
               "650 \t00 |aDemocracy |xHistory |zUnited States \n" +
               "650 \t00 |aLiberty |xHistory \n" +
               "651 \t#0 |aUnited States |xHistory \n" +
               "651 \t#0 |aUnited States |xPolitics and government \n" +
               "852 \t## |aPD |jDTK.000006 |tDTK.000006 \n" +
               "852 \t## |aPM |jMTK.000010 |tMTK.000010 ");
    }

    private void addControl(View view) {
        tvMarc = view.findViewById(R.id.tvMarc);

    }
}