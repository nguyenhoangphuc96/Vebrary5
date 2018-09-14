package com.lacviet.vebrary5.MenuNavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lacviet.vebrary5.DigitalDocument.HomeDigitalDocActivity;
import com.lacviet.vebrary5.MagazineOnline.HomeMagazineOnlineActivity;
import com.lacviet.vebrary5.R;

public class EbookMenuFragment extends Fragment {
    private TextView tvDigitalDocument,tvOnlineMagazine,tvExcerpt,tvChildren;
    public EbookMenuFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_ebook,container,false);
        addControl(view);

        addEvent();
        return view;
    }

    private void addEvent() {
        tvDigitalDocument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDigitalDocHome();
            }
        });
        tvExcerpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        tvOnlineMagazine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMagazineOnlineHome();
            }
        });
        tvChildren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void startDigitalDocHome() {
        Intent intent = new Intent(getActivity(), HomeDigitalDocActivity.class);
        startActivity(intent);
    }
    private void startMagazineOnlineHome() {
        Intent intent = new Intent(getActivity(), HomeMagazineOnlineActivity.class);
        startActivity(intent);
    }


    private void addControl(View view) {
        tvDigitalDocument = view.findViewById(R.id.tvDigitalDocument);
        tvOnlineMagazine = view.findViewById(R.id.tvOnlineMagazine);
        tvExcerpt = view.findViewById(R.id.tvExcerpt);
        tvChildren = view.findViewById(R.id.tvChildren);

    }
}